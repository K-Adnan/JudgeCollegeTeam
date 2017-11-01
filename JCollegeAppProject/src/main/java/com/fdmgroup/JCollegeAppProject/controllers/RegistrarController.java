package com.fdmgroup.JCollegeAppProject.controllers;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fdmgroup.JCollegeAppProject.daos.AbsenceDAO;
import com.fdmgroup.JCollegeAppProject.daos.CourseDAO;
import com.fdmgroup.JCollegeAppProject.daos.DepartmentDAO;
import com.fdmgroup.JCollegeAppProject.daos.GradeDAO;
import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAO;
import com.fdmgroup.JCollegeAppProject.daos.RegistrarDAO;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.daos.UserDAO;
import com.fdmgroup.JCollegeAppProject.entities.Absence;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Department;
import com.fdmgroup.JCollegeAppProject.entities.Grade;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Registrar;
import com.fdmgroup.JCollegeAppProject.entities.Student;
import com.fdmgroup.JCollegeAppProject.entities.User;

@Controller
public class RegistrarController {

	private Logger logger=Logger.getLogger(getClass());

	@Autowired
	private CourseDAO courseDao;
	@Autowired
	private ProfessorDAO professorDao;
	@Autowired
	private StudentDAO studentDao;
	@Autowired
	private RegistrarDAO registrarDao;
	@Autowired
	private DepartmentDAO departmentDao;
	@Autowired
	private GradeDAO gradeDao;
	@Autowired
	private UserDAO userDao;
	@Autowired
	private AbsenceDAO absenceDao;


	public RegistrarController() {
		super();
	}

	public RegistrarController(CourseDAO courseDao, ProfessorDAO professorDao, StudentDAO studentDao,
			RegistrarDAO registrarDao, DepartmentDAO departmentDao, GradeDAO gradeDao, UserDAO userDao,
			AbsenceDAO absenceDao) {
		super();
		this.courseDao = courseDao;
		this.professorDao = professorDao;
		this.studentDao = studentDao;
		this.registrarDao = registrarDao;
		this.departmentDao = departmentDao;
		this.gradeDao = gradeDao;
		this.userDao = userDao;
		this.absenceDao = absenceDao;
	}

	@RequestMapping("/registrar/MyProfile")
	public String GoToMyProfile(Principal principal, Model model) {
		logger.info("Client request to url : MyProfile");
		Registrar registrar = registrarDao.getRegistrar(principal.getName());
		model.addAttribute("registrar", registrar);
		return "registrar/MyProfile";
	}

	@RequestMapping("/registrar/SystemUsers")
	public String GoToSystemUsers(Model model){
		logger.info("Client request to url : SystemUsers");

		List<User> userList = userDao.getAllUsers();
		model.addAttribute("userList", userList);

		return "registrar/SystemUsers";
	}

	@RequestMapping("/registrar/ViewAndUpdate")
	public String doChooseUserP(Model model, HttpSession session, Principal principal, @RequestParam String username, HttpServletRequest request){
		
		User user = userDao.getUser(username);

		if (user instanceof Student) {
			Student student = (Student) user;
			List<Course> courseList = courseDao.getAllCoursesByStudent(student);
			model.addAttribute("courseList", courseList);
			model.addAttribute("student", student);
			List<Absence> absenceList = absenceDao.getAbsencesByStudent(student);
			model.addAttribute("absenceList", absenceList);
			return "registrar/ViewAndUpdateStud";
		} else if (user instanceof Professor) {
			Professor professor = (Professor) user;
			model.addAttribute("professor", professor);
			return "registrar/ViewAndUpdateProf";
		}
		return "redirect:SystemUsers";
	}

	@RequestMapping("/registrar/RemoveUser")
	public String doRemoveUser(Model model, @RequestParam String username, RedirectAttributes ra){
		User user = userDao.getUser(username);
		if(user instanceof Student){
			Student student = (Student) user;
			List<Course> courseList = courseDao.getAllCoursesByStudent(student);
			for(Course course : courseList){
				course.removeStudent(student);
			}
			studentDao.updateStudent(student);
		}
		else if(user instanceof Professor){
			
			Professor professor = (Professor) user;
			professor.setCourse(null);
			
			List<Course> courseList = courseDao.getAllCoursesByProfessor(professor);
			for(Course course : courseList){
				course.removeProfessor();
				courseDao.updateCourse(course);
			}
			
			List<Grade> gradeList = gradeDao.getAllGradesByProfessor(professor);
			for(Grade grade : gradeList){
				grade.setProfessor(null);
				gradeDao.updateGrade(grade);
			}
			Department department = professor.getDepartment();
			if(department != null){
			department.removeProfessor(professor);
			}
			
			professorDao.updateProfessor(professor);
		}
		
		userDao.removeUser(username);
		
		List<User> userList = userDao.getAllUsers();
		model.addAttribute("user", user);
		model.addAttribute("userList", userList);
		ra.addFlashAttribute("message", "User is removed!");
		logger.info("User is removed :"+username);
		return "redirect:SystemUsers";
	}

	@RequestMapping("/registrar/EditInformationStud")
	public String EditInformationStud(@RequestParam String username, Model model, HttpSession session){
		Student student = studentDao.getStudent(username);
		List<String> genders = new ArrayList<String>();
		genders.add("MALE");
		genders.add("FEMALE");
		genders.add("UNDISCLOSED");
		
		model.addAttribute("student", student);
		model.addAttribute("genders", genders);
		return "registrar/EditInformationStud";
	}
	
	@RequestMapping("/registrar/processEditStud")
	public String processEditStudent(@RequestParam String dob, @RequestParam String gender, Student student, Model model, HttpSession session){
		Student oldStudent = studentDao.getStudent(student.getUsername());
		
		student.setAbsenseList(oldStudent.getAbsenseList());
		student.setCourseList(oldStudent.getCourseList());
		student.setGradeList(oldStudent.getGradeList());
		System.out.println("********** dob in controller " + dob);
		student.setDobString(dob);
		student.setGenderString(gender);
		
		studentDao.updateStudent(student);
		
		String username = (String) session.getAttribute("username");
		model.addAttribute("student", student);
		List<Absence> absenceList = absenceDao.getAbsencesByStudent(student);
		model.addAttribute("absenceList", absenceList);
		
		logger.info("Information are edited for"+username);
		return "registrar/ViewAndUpdateStud";
	}
	
	@RequestMapping("/registrar/EditInformationProf")
	public String EditInformationProf(@RequestParam String username, Model model, HttpSession session){
		List<Department> departmentList = departmentDao.getAllDepartments();
		
		Professor professor = professorDao.getProfessor(username);
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("professor", professor);
		
		return "registrar/EditInformationProf";
	}
	
	@RequestMapping("/registrar/processEditProf")
	public String processEditProf(Professor professor, @RequestParam int departmentId, Model model){
		String username = professor.getUsername();
		Professor oldProfessor = professorDao.getProfessor(username);
		professor.setCourse(oldProfessor.getCourse());
		
		Department department = departmentDao.getDepartment(departmentId);
		if (department == null){
			professor.setDepartment(null);
		}else{
			professor.setDepartment(department);
		}
		professorDao.updateProfessor(professor);
		model.addAttribute("professor", professor);
		
		logger.info("Information are edited for " + professor.getUsername());
		return "registrar/ViewAndUpdateProf";
	}

	@RequestMapping("/registrar/RemoveFromCourse")
	public String DoRemoveFromCourse(@RequestParam String username, @RequestParam int courseCode, Model model, String courseName){
		Student student = studentDao.getStudent(username);
		Course course = courseDao.getCourse(courseCode);
		student.removeCourse(course);
		course.removeStudent(student);
		
		studentDao.updateStudent(student);
		courseDao.updateCourse(course);
		
		model.addAttribute("username", username);
		logger.info("Client request to url : Grades");
		List<Course> courseList = courseDao.getAllCoursesByStudent(student);
		model.addAttribute("student", student);
		model.addAttribute("courseList", courseList);
		List<Absence> absenceList = absenceDao.getAbsencesByStudent(student);
		model.addAttribute("absenceList", absenceList);
		
		logger.info("User is removed from course :"+courseName);
		
		return "registrar/ViewAndUpdateStud";
	}

	@RequestMapping("/registrar/Courses")
	public String goToCourses(Model model, @ModelAttribute("message") String message) {
		logger.info("Client request to url : Courses");

		List<Course> courseList = courseDao.getAllCourses();
		List<Professor> professorList = professorDao.getAllProfessors();

		Course course = courseList.get(0);
		List<Student> studentList = studentDao.getAllStudentsByCourse(course);
		model.addAttribute("studentList", studentList);
		model.addAttribute("courseList", courseList);
		model.addAttribute("course", course);
		model.addAttribute("professorList", professorList);
		model.addAttribute("message",message);
		return "registrar/Courses";
	}

	@RequestMapping("/registrar/cancelCourse")
	public String courseCancellation(@RequestParam int code, Model model, RedirectAttributes ra) {
		Course course = courseDao.getCourse(code);
		List<Grade> gradeList = gradeDao.getAllGradesByCourse(course);

		for (int i=0;i<gradeList.size();i++){
			Grade grade = gradeList.get(i);
			gradeDao.removeGrade(grade.getGradeId());
		}

		courseDao.removeCourse(code);
		ra.addFlashAttribute("message", "Course is cancelled!");
		logger.info("Course is cancelled :" + code);
		return "redirect:Courses";
	}

	@RequestMapping("/registrar/updateProfessor")
	public String courseUpdate(@RequestParam String professorUsername, @RequestParam int code, Model model){

		List<Course> courseList = courseDao.getAllCourses();
		List<Professor> professorList = professorDao.getAllProfessors();
		Course course = courseDao.getCourse(code);
		if (professorUsername.equals("empty")){
			course.setProfessor(null);
		}else{
			Professor professor = professorDao.getProfessor(professorUsername);
			course.setProfessor(professor);
		}
		courseDao.updateCourse(course);

		model.addAttribute("courseList", courseList);
		model.addAttribute("professorList", professorList);
		model.addAttribute("course", course);
		model.addAttribute("message", "Professer has been updated!");

		logger.info("Course is updated :" + code);
		return "registrar/Courses";
	}

	@RequestMapping("/registrar/processChooseCourse")
	public String doChooseCourse(Model model, int courseId){
		Course course = courseDao.getCourse(courseId);
		List<Course> courseList = courseDao.getAllCourses();
		List<Professor> professorList = professorDao.getAllProfessors();

		List<Student> studentList = studentDao.getAllStudentsByCourse(course);
		model.addAttribute("studentList", studentList);
		model.addAttribute("course",course);
		model.addAttribute("courseList", courseList);
		logger.info("Course is chosen :"+courseId);
		model.addAttribute("professorList", professorList);
		return "registrar/Courses";
	}

	@RequestMapping("/registrar/AddCourse")
	public String GoToAddCourse(Model model){
		List<Professor> professorList = professorDao.getAllProfessors();
		List<Department> departmentList = departmentDao.getAllDepartments();
		model.addAttribute("professorList", professorList);
		model.addAttribute("departmentList", departmentList);
		Course course = new Course();
		model.addAttribute("course",course);
		logger.info("Client request to url : AddCourse");
		return "registrar/AddCourse";
	}

	@RequestMapping("/registrar/doAddCourse")
	public String DoAddCourse(Model model, Course course,@RequestParam int departmentId){
		Department department = departmentDao.getDepartment(departmentId);
		course.setDepartment(department);
		courseDao.addCourse(course);
		model.addAttribute("message", "Course added successfully!");
		model.addAttribute("course",course);

		List<Course> courseList = courseDao.getAllCourses();
		model.addAttribute("courseList", courseList);
		List<Professor> professorList = professorDao.getAllProfessors();
		model.addAttribute("professorList", professorList);
		//logger.info("Course is added : " +courseCode);
		return "registrar/Courses";
	}
	
	@RequestMapping("/registrar/AddAbsence")
	public String GoToAddAbsence(@RequestParam String username, Model model){

		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		String date = cal.get(Calendar.DATE) + "/" + month + "/" + cal.get(Calendar.YEAR);
		
		model.addAttribute("username", username);
		logger.info("Client request to url : Grades");
		model.addAttribute("date", date);
		return "registrar/AddAbsence";
	}
	
	@RequestMapping("/registrar/doAddAbsence")
	public String doAddAbsence(@RequestParam String username, @RequestParam String reason,@RequestParam String dateOfAbsence, HttpServletRequest request, Model model){
		Student student = studentDao.getStudent(username);
		System.out.println("Username is: "+ username);
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		
		Absence absence = new Absence();
		
		String approved = request.getParameter("approved");
		
		if (approved != null){
			if (approved.equals("true")){
				absence.setAbsenceApproved(true);
			}
		}
		
		try {
			calendar.setTime(sf.parse(dateOfAbsence));
			absence.setDateOfAbsence(calendar);
			System.out.println("Date is : " + calendar.get(Calendar.DATE));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		absence.setReasonForAbsence(reason);
		absence.setStudent(student);
		absenceDao.addAbsence(absence);

		model.addAttribute("username", username);
		logger.info("Client request to url : Grades");
		List<Course> courseList = courseDao.getAllCoursesByStudent(student);
		model.addAttribute("student", student);
		model.addAttribute("courseList", courseList);
		List<Absence> absenceList = absenceDao.getAbsencesByStudent(student);
		model.addAttribute("absenceList", absenceList);
		return "registrar/ViewAndUpdateStud";
	}

	@RequestMapping("/registrar/Timetable")
	public String GoToTimetable(){
		logger.info("Client request to url : Timetable");
		return "registrar/Timetable";
	}

	@RequestMapping("/registrar/Grades")
	public String GoToGrades(){

		logger.info("Client request to url : Grades");
		return "registrar/Grades";
	}
	
}

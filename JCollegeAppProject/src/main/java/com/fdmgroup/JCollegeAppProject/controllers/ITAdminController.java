package com.fdmgroup.JCollegeAppProject.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.JCollegeAppProject.daos.ITAdminDAO;
import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAO;
import com.fdmgroup.JCollegeAppProject.daos.RegistrarDAO;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.daos.UserDAO;
import com.fdmgroup.JCollegeAppProject.entities.ITAdmin;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Registrar;
import com.fdmgroup.JCollegeAppProject.entities.Student;
import com.fdmgroup.JCollegeAppProject.entities.User;

@Controller
public class ITAdminController {

	private Logger logger = Logger.getLogger(getClass());

	 @Autowired
	 private UserDAO userDao;
	@Autowired
	private StudentDAO studentDao;
	@Autowired
	private ProfessorDAO professorDao;
	@Autowired
	private RegistrarDAO registrarDao;
	@Autowired
	private ITAdminDAO itadminDao;

	public ITAdminController() {
		super();
	}

	public ITAdminController(StudentDAO studentDao, ProfessorDAO professorDao, RegistrarDAO registrarDao,
			ITAdminDAO itadminDao) {
		super();
		this.studentDao = studentDao;
		this.professorDao = professorDao;
		this.registrarDao = registrarDao;
		this.itadminDao = itadminDao;
	}

	@RequestMapping("/itAdmin/HomePage")
	public String ITAdminHomePage(HttpSession session, Model model) {
		return "itAdmin/HomePage";
	}

	@RequestMapping("/itAdmin/addStudent")
	public String goToAddStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "itAdmin/AddStudent";
	}

	@RequestMapping("/itAdmin/processAddStudent")
	public String processAddStudent(Model model, Student student) {
		studentDao.addStudent(student);
		model.addAttribute("message", "Student added successfully");
		return "itAdmin/HomePage";
	}

	@RequestMapping("/itAdmin/removeStudent")
	public String goToRemoveStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "itAdmin/RemoveStudent";
	}

	@RequestMapping("/itAdmin/processRemoveStudent")
	public String processRemoveStudent(Student student, Model model) {
		studentDao.removeStudent(student.getUsername());
		model.addAttribute("message2", "Student removed successfully");
		return "itAdmin/HomePage";

	}

	@RequestMapping("/itAdmin/addProfessor")
	public String goToAddProfessor(Model model) {
		Professor professor = new Professor();
		model.addAttribute("professor", professor);
		return "itAdmin/AddProfessor";
	}

	@RequestMapping("/itAdmin/processAddProfessor")
	public String processAddProfessor(Model model, Professor professor) {
		professorDao.addProfessor(professor);
		model.addAttribute("message", "Professor added successfully");
		return "itAdmin/HomePage";
	}
	
	@RequestMapping("/itAdmin/viewProfessors")
	public String goToViewProfessors(HttpSession session, Model model, Principal principal) {
		Professor professor = professorDao.getProfessor(principal.getName());
		List<User> professorList = userDao.getAllUsersByProfessor(professor);
		
		model.addAttribute("professorList", professorList);
		
		return "itAdmin/ViewProfessors";
	}
	

	@RequestMapping("/itAdmin/removeProfessor")
	public String goToRemoveProfessor(Model model) {
		Professor professor = new Professor();
		model.addAttribute("professor", professor);
		return "itAdmin/RemoveProfessor";
	}

	@RequestMapping("/itAdmin/processRemoveProfessor")
	public String processRemoveProfessor(Professor professor, Model model) {
		professorDao.removeProfessor(professor.getUsername());
		model.addAttribute("message2", "Professor removed successfully");
		return "itAdmin/HomePage";

	}
	@RequestMapping("/itAdmin/addRegistrar")
	public String goToAddRegistrar(Model model) {
		Registrar registrar = new Registrar();
		model.addAttribute("registrar", registrar);
		return "itAdmin/AddRegistrar";
	}

	@RequestMapping("/itAdmin/processAddRegistar")
	public String processAddRegistar(Model model, Registrar registrar) {
		registrarDao.addRegistrar(registrar);
		model.addAttribute("message", "Registrar added successfully");
		return "itAdmin/HomePage";
	}

	@RequestMapping("/itAdmin/removeRegistrar")
	public String goToRemoveRegistrar(Model model) {
		Registrar registrar = new Registrar();
		model.addAttribute("registrar", registrar);
		return "itAdmin/RemoveProfessor";
	}

	@RequestMapping("/itAdmin/processRemoveRegistrar")
	public String processRemoveRegistrar(Registrar registrar, Model model) {
		registrarDao.removeRegistrar(registrar);
		model.addAttribute("message2", "Registrar removed successfully");
		return "itAdmin/HomePage";

	}
	@RequestMapping("/itAdmin/addITAdmin")
	public String goToAddITAdmin(Model model) {
		ITAdmin itadmin = new ITAdmin();
		model.addAttribute("itadmin", itadmin);
		return "itAdmin/AddITAdmin";
	}

	@RequestMapping("/itAdmin/processAddITAdmin")
	public String processAddITadmin(Model model, ITAdmin itadmin) {
		itadminDao.addITAdmin(itadmin);
		model.addAttribute("message", "IT Admin added successfully");
		return "itAdmin/HomePage";
	}

	@RequestMapping("/itAdmin/removeITAdmin")
	public String goToRemoveITAdmin(Model model) {
		ITAdmin itadmin = new ITAdmin();
		model.addAttribute("itadmin", itadmin);
		return "itAdmin/RemoveItAdmin";
	}

	@RequestMapping("/itAdmin/processRemoveITAdmin")
	public String processRemoveITAdmin(ITAdmin itadmin, Model model) {
		itadminDao.removeITAdmin(itadmin);
		model.addAttribute("message2", "IT Admin removed successfully");
		return "itAdmin/HomePage";

	}
}

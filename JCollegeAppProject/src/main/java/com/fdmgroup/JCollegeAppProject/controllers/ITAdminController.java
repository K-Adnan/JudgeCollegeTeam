package com.fdmgroup.JCollegeAppProject.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

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
	private ITAdminDAO itAdminDao;

	public ITAdminController() {
		super();
	}

	public ITAdminController(StudentDAO studentDao, ProfessorDAO professorDao, RegistrarDAO registrarDao,
			ITAdminDAO itAdminDao) {
		super();
		this.studentDao = studentDao;
		this.professorDao = professorDao;
		this.registrarDao = registrarDao;
		this.itAdminDao = itAdminDao;
	}

	@RequestMapping("/itAdmin/HomePage")
	public String ITAdminHomePage(HttpSession session, Model model) {
		return "itAdmin/itAdminHome";
	}

	@RequestMapping("/itAdmin/addStudent")
	public String goToAddStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "itAdmin/addStudent";
	}

	@RequestMapping("/itAdmin/processAddStudent")
	public String processAddStudent(Model model, Student student) {
		studentDao.addStudent(student);
		model.addAttribute("message", "Student added successfully");
		return "itAdmin/itAdminHome";
	}

	@RequestMapping("/itAdmin/viewStudents")
	public String goToViewStudents(HttpSession session, Model model, Principal principal) {
		Student student = studentDao.getStudent(principal.getName());
		List<User> studentList = userDao.getAllStudents();
		model.addAttribute("studentList", studentList);
		return "itAdmin/viewStudents";
	}

	@RequestMapping("/itAdmin/processRemoveStudent")
	public String processRemoveStudent(@RequestParam String username, Model model) {
		studentDao.removeStudent(username);
		List<User> studentList = userDao.getAllStudents();
		model.addAttribute("studentList", studentList);

		model.addAttribute("message", "Student removed successfully");
		return "itAdmin/viewStudents";

	}
	

	@RequestMapping("/itAdmin/addProfessor")
	public String goToAddProfessor(Model model) {
		Professor professor = new Professor();
		model.addAttribute("professor", professor);
		return "itAdmin/addProfessor";
	}

	@RequestMapping("/itAdmin/processAddProfessor")
	public String processAddProfessor(Model model, Professor professor) {
		professorDao.addProfessor(professor);
		model.addAttribute("message", "Professor added successfully");
		return "itAdmin/itAdminHome";
	}

	@RequestMapping("/itAdmin/viewProfessors")
	public String goToViewProfessors(HttpSession session, Model model, Principal principal) {
		Professor professor = professorDao.getProfessor(principal.getName());
		List<User> professorList = userDao.getAllProfessors();
		model.addAttribute("professorList", professorList);
		return "itAdmin/viewProfessors";
	}

	@RequestMapping("/itAdmin/processRemoveProfessor")
	public String processRemoveProfessor(@RequestParam String username, Model model) {
		professorDao.removeProfessor(username);
		List<User> professorList = userDao.getAllProfessors();
		model.addAttribute("professorList", professorList);
		model.addAttribute("message2", "Professor removed successfully");
		return "itAdmin/viewProfessors";

	}

	@RequestMapping("/itAdmin/addRegistrar")
	public String goToAddRegistrar(Model model) {
		Registrar registrar = new Registrar();
		model.addAttribute("registrar", registrar);
		return "itAdmin/addRegistrar";
	}

	@RequestMapping("/itAdmin/processAddRegistrar")
	public String processAddRegistar(Model model, Registrar registrar) {
		registrarDao.addRegistrar(registrar);
		model.addAttribute("message", "Registrar added successfully");
		return "itAdmin/itAdminHome";
	}

	@RequestMapping("/itAdmin/viewRegistrars")
	public String goToViewRegistrar(HttpSession session, Model model, Principal principal) {
		Registrar registrar = registrarDao.getRegistrar(principal.getName());
		List<User> registrarList = userDao.getAllRegistrars();
		model.addAttribute("registrarList", registrarList);
		return "itAdmin/viewRegistrars";
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

	@RequestMapping("/itAdmin/addItAdmin")
	public String goToAddITAdmin(Model model) {
		ITAdmin itAdmin = new ITAdmin();
		model.addAttribute("itAdmin", itAdmin);
		return "itAdmin/addItAdmin";
	}

	@RequestMapping("/itAdmin/processAddITAdmin")
	public String processAddITadmin(Model model, ITAdmin itAdmin) {
		itAdminDao.addITAdmin(itAdmin);
		model.addAttribute("message", "IT Admin added successfully");
		return "itAdmin/itAdminHome";
	}

	@RequestMapping("/itAdmin/viewItAdmins")
	public String goToViewITAdmin(HttpSession session, Model model, Principal principal) {
		ITAdmin itAdmin = itAdminDao.getITAdmin(principal.getName());
		List<User> itAdminList = userDao.getAllITAdmins();
		model.addAttribute("itAdminList", itAdminList);
		return "itAdmin/viewItAdmins";
	}

	@RequestMapping("/itAdmin/removeItAdmin")
	public String goToRemoveITAdmin(Model model) {
		ITAdmin itadmin = new ITAdmin();
		model.addAttribute("itadmin", itadmin);
		return "itAdmin/RemoveItAdmin";
	}

	@RequestMapping("/itAdmin/processRemoveItAdmin")
	public String processRemoveITAdmin(ITAdmin itAdmin, Model model) {
		itAdminDao.removeITAdmin(itAdmin);
		model.addAttribute("message", "IT Admin removed successfully");
		return "itAdmin/viewITAdmins";

	}
}

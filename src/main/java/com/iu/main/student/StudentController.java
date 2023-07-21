package com.iu.main.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.bankBook.BankBookDTO;
import com.iu.main.bankBook.BankBookService;

@Controller
@RequestMapping("/student/*")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList(Model model) throws Exception{
		System.out.println("학생리스트");
		List<StudentDTO> ar = studentService.getList();
		model.addAttribute("list", ar);
		return "student/list";
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView getDetail(StudentDTO studentDTO, ModelAndView mv) throws Exception{
		studentDTO = studentService.getDetail(studentDTO);
		System.out.println(studentDTO.getName());
		mv.addObject("dto", studentDTO);
		mv.setViewName("student/detail");
		System.out.println("detail");
		return mv;
	}
}

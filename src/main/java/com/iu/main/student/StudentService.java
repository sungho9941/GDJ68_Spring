package com.iu.main.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.bankBook.BankBookDAO;
import com.iu.main.bankBook.BankBookDTO;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	public List<StudentDTO> getList() throws Exception{
		System.out.println("service");
		
		return studentDAO.getList();
	}
	
	public StudentDTO getDetail(StudentDTO studentDTO) throws Exception{
		return studentDAO.getDetail(studentDTO);
	}
	
}

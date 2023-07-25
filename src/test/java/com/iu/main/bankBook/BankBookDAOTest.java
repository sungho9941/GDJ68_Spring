package com.iu.main.bankBook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.main.Mytest;

public class BankBookDAOTest extends Mytest{

	
	@Autowired
	private BankBookController bankBookController;
	
	@Test
	public void list() throws Exception{
		
//		bankBookController.getList();
	}
	
	
	
	
}

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
	private BankBookDAO bankBookDAO;
	
	@Test
	public void addTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		
		for(int i=0; i<30; i++) {
			bankBookDTO.setBookName("asd입출금" + i);
			bankBookDTO.setBookContents("asd입출금 내용"+i);
			bankBookDTO.setBookRate(2.3);
			bankBookDTO.setBookSale(1);
			bankBookDAO.setAdd(bankBookDTO);
		}
		System.out.println("finish");
	}
	
	
	
	
}

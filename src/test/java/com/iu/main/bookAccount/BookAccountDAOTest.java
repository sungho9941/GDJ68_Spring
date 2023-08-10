package com.iu.main.bookAccount;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.Mytest;
import com.iu.main.member.MemberDTO;

public class BookAccountDAOTest extends Mytest {

	@Autowired
	private BookAccountDAO bookAccountDAO;
	

	@Test
	public void setAddTest() throws Exception{
		BookAccountDTO dto = new BookAccountDTO();
		dto.setId("12312");
		dto.setBookNum(1L);
		dto.setAccount(123456L);
		dto.setAccountBalance(0L);
		dto.setAccountPW("0000");
		
		int result = bookAccountDAO.setAdd(dto);
		
		assertEquals(1, result);
	}
	@Test
	public void getListTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("1234");
		List<BookAccountDTO> ar = bookAccountDAO.getList(memberDTO);
		
		assertEquals(0, ar.size());
	}

}

package com.iu.main.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {
	@Autowired
	private BankBookDAO bankBookDAO;
	
	public List<BankBookDTO> getList() throws Exception{
		System.out.println("service");
		List<BankBookDTO> ar = bankBookDAO.getList();
		System.out.println("service-=--");
		return ar;
	}
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	public int setAdd(BankBookDTO bankBookDTO) throws Exception{
		
		return bankBookDAO.setAdd(bankBookDTO);
	}
	
	public int setDelete(Long num) throws Exception{
		
		return bankBookDAO.setDelete(num);
	}
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		
		return bankBookDAO.setUpdate(bankBookDTO);
	}
}

package com.iu.main.bankBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.member.MemberFileDTO;
import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

@Service
public class BankBookService {
	@Autowired
	private BankBookDAO bankBookDAO;
	@Autowired
	private FileManager fileManager;
	
	public List<BankBookDTO> getList(Pager pager) throws Exception{
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		//page		startRow		lastRow
//		//1			1				10
//		//2			11				20
//		//3			21				30
//		int count=5;
//		int startRow = (page-1)*count+1;
//		int lastRow = page*count;
		
		pager.makeRowNum();
		Long total = bankBookDAO.getTotal(pager);
		pager.makePageNum(total);
		
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
		return bankBookDAO.getList(pager);
		
	}
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	public int setAdd(BankBookDTO bankBookDTO, MultipartFile [] files, HttpSession session) throws Exception{

		
		String path="/resources/upload/bankbook/";
		
//		long num = bankBookDAO.getSequence();
		
//		bankBookDTO.setBookNum(num);
		int result = bankBookDAO.setAdd(bankBookDTO);
		
		for(MultipartFile multipartFile : files) {
			
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(path, session, multipartFile);
			BankBookFileDTO bankBookFileDTO = new BankBookFileDTO();
			bankBookFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			bankBookFileDTO.setFileName(fileName);
			bankBookFileDTO.setBookNum(bankBookDTO.getBookNum());
			result = bankBookDAO.setFileAdd(bankBookFileDTO);
		}

		
		
		 
		
		return bankBookDAO.setAdd(bankBookDTO);
	}
	
	public int setDelete(Long num) throws Exception{
		
		return bankBookDAO.setDelete(num);
	}
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		
		return bankBookDAO.setUpdate(bankBookDTO);
	}
}

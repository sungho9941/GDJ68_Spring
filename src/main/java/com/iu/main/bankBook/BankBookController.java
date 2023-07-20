package com.iu.main.bankBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value="list.do", method = RequestMethod.GET)
	public String getList() throws Exception{
		System.out.println("list");
		bankBookService.service();
		return "bankbook/list";
	}
	
	@RequestMapping(value="detail.do", method = RequestMethod.GET)
	public String getDetail() throws Exception{
		System.out.println("detail");
		return "bankbook/detail";
	}
}

package com.iu.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FrontController {
//	home
//	/ 주소 왔을 때 실행, index.jsp
	
	@RequestMapping(value="/")
	public String home() throws Exception{
		
		return "index";
	}
	
	@RequestMapping(value="/index")
	public String home2() throws Exception{
		
		return "index";
	}
	
	@RequestMapping(value="bankbook/list")
	public String list() throws Exception{
		
		return "bankbook/list";
	}
	
	@RequestMapping(value="bankbook/detail")
	public String detail() throws Exception{
		
		return "bankbook/detail";
	}
	
	@RequestMapping(value = "bankbook/add")
	public String add() throws Exception{
		
		return "bankbook/add";
	}
	
	@RequestMapping(value = "member/join")
	public String join() throws Exception{
		
		return "member/join";
	}

	@RequestMapping(value = "member/login")
	public String login() throws Exception{
		
		return "member/login";
	}
	
//	@RequestMapping(value = "member/logout")
//	public String logout() throws Exception{
//		
//		return "member/logout";
//	}
	
	@RequestMapping(value = "member/mypage")
	public String mypage() throws Exception{

		return "member/mypage";
	}
}

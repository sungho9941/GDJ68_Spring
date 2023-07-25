package com.iu.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FrontController {
	//add_board
//	home
//	/ 주소 왔을 때 실행, index.jsp
	
	@RequestMapping(value="/")
	public String home() throws Exception{
		
		return "index";
	}

}

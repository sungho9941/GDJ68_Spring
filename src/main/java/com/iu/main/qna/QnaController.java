package com.iu.main.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.iu.main.util.Pager;




@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;

	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList(Model model, Pager pager) throws Exception{
		
		List<QnaDTO> ar = qnaService.getList(pager);

		System.out.println(ar.get(0).getWriter());
		
		model.addAttribute("list", ar);
		model.addAttribute("pager",pager);
		return "qna/list";
	}
	
}

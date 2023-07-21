package com.iu.main.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList(Model model) throws Exception{
		System.out.println("----------");
		List<BankBookDTO> ar = bankBookService.getList();
		System.out.println("list");
		model.addAttribute("list", ar);
		return "bankbook/list";
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView getDetail(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception{
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		System.out.println(bankBookDTO.getBookName());
		mv.addObject("dto", bankBookDTO);
		mv.setViewName("bankbook/detail");
		System.out.println("detail");
		return mv;
	}
	
	//form
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void setAdd() throws Exception{
		
		
	}
	
	//db insert
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String setAdd(BankBookDTO bankBookDTO) throws Exception{
		int result = bankBookService.setAdd(bankBookDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String setDelete(Long bookNum) throws Exception{
		int result = bankBookService.setDelete(bookNum);
		return "redirect:./list";
	}
	
	//수정 form
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void setUpdate(BankBookDTO bankBookDTO, Model model) throws Exception{
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		model.addAttribute("dto",bankBookDTO);
		
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String setUpdate(BankBookDTO bankBookDTO) throws Exception{
		int result = bankBookService.setUpdate(bankBookDTO);
		return "redirect:./detail?bookNum="+bankBookDTO.getBookNum();
	}
}

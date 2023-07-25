package com.iu.main.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.bankBook.BankBookDTO;


@Controller
@RequestMapping("/notice/*")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Model model) throws Exception{
		
		List<BoardDTO> ar = boardService.getList();
		model.addAttribute("list", ar);
		
		return "board/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception{
		boardDTO = boardService.getDetail(boardDTO);
		model.addAttribute("dto", boardDTO);
		
		return "board/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String getAdd() throws Exception{
		
		return "board/add";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String getUpdate(BoardDTO boardDTO, Model model) throws Exception{
		boardDTO = boardService.getDetail(boardDTO);
		model.addAttribute("dto",boardDTO);
		
		return "board/update";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String getAdd(BoardDTO boardDTO) throws Exception{
		int result = boardService.getAdd(boardDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String getUpdate(BoardDTO boardDTO) throws Exception{
		int result = boardService.getUpdate(boardDTO);
		return "redirect:./detail?boardNum="+boardDTO.getBoardNum();
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String getDelete(BoardDTO boardDTO) throws Exception{
		System.out.println(boardDTO.getBoardNum() + "=-=-=-=-=-");
		
		int result = boardService.getDelete(boardDTO);
		return "redirect:./list";
	}
	

}

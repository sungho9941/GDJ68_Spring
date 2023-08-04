package com.iu.main.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.bankBook.BankBookDTO;
import com.iu.main.board.BoardDTO;
import com.iu.main.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoardName() {
		return "notice";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Pager pager, Model model) throws Exception{
		
		List<BoardDTO> ar = noticeService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(NoticeDTO noticeDTO, Model model) throws Exception{
		BoardDTO boardDTO = noticeService.getDetail(noticeDTO);
		
		if(boardDTO!=null) {
		model.addAttribute("dto", boardDTO);
		return "board/detail";
		} else {
			model.addAttribute("message", "글없음");
			model.addAttribute("url", "list");
			return "commons/result";
		}
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String setUpdate(NoticeDTO noticeDTO, Model model) throws Exception{
		noticeDTO = (NoticeDTO)noticeService.getDetail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
		
		return "board/update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO) throws Exception{
		int result = noticeService.setUpdate(noticeDTO);
		
		return "redirect:./detail?num="+noticeDTO.getNum();
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String setAdd() throws Exception{
		
		return "board/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String setAdd(NoticeDTO noticeDTO, MultipartFile [] photos, HttpSession session, Model model) throws Exception{
		int result = noticeService.setAdd(noticeDTO, photos, session);
		
		String message="등록 실패";
		if(result>0) {
			message="등록 성공";
		}
		model.addAttribute("message", message);
		model.addAttribute("url", "list");		
		return "commons/result";
	}
}

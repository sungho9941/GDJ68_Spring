package com.iu.main.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.board.BoardDTO;
import com.iu.main.board.BoardService;
import com.iu.main.util.Pager;

@Service
public class NoticeService implements BoardService{

	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRowNum();
		pager.makePageNum(noticeDAO.getTotal(pager));
		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		
		return noticeDAO.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		
		return 0;
	}
	
	
}

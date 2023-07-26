package com.iu.main.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.util.Pager;

@Service
public class BoardService {

	@Autowired
	BoardDAO boardDAO;
	
	public List<BoardDTO> getList(Pager pager) throws Exception{
		
		pager.makeRowNum();
		Long total = boardDAO.getTotal();
		pager.makePageNum(total);
		
		return boardDAO.getList(pager);
	}
	
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception{
		
		return boardDAO.getDetail(boardDTO);
	}
	
	public int getAdd(BoardDTO boardDTO) throws Exception{
		
		return boardDAO.getAdd(boardDTO);
	}
	
	public int getUpdate(BoardDTO boardDTO) throws Exception{
		return boardDAO.getUpdate(boardDTO);
	}

	public int getDelete(BoardDTO boardDTO) throws Exception{
		return boardDAO.getDelete(boardDTO);
	}
}

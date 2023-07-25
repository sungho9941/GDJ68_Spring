package com.iu.main.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	BoardDAO boardDAO;
	
	public List<BoardDTO> getList() throws Exception{
		
		return boardDAO.getList();
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

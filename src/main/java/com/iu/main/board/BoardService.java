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
	
	
	
}

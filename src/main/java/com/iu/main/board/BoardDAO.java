package com.iu.main.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.board.BoardDAO.";
	
	
	
	public List<BoardDTO> getList() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", boardDTO);			
	}
	
	public int getAdd(BoardDTO boardDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"getAdd", boardDTO);
	}

	public int getUpdate(BoardDTO boardDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"getUpdate", boardDTO);
	}

	public int getDelete(BoardDTO boardDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"getDelete", boardDTO);
	}
}

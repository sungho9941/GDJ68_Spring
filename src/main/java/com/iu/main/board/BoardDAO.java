package com.iu.main.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.util.Pager;


@Repository
public class BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.board.BoardDAO.";
	
	//total
	public Long getTotal(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotal", pager);
	}
		
	//list
	public List<BoardDTO> getList(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", pager);
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

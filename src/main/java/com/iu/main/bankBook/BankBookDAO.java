package com.iu.main.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // 해당 클래스의 객체 생성
public class BankBookDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.bankBook.BankBookDAO.";
	
	//list
	public List<BankBookDTO> getList() throws Exception{

		
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	//detail
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"getDetail", bankBookDTO);
	}

	//add
	public int setAdd(BankBookDTO bankBookDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"setAdd", bankBookDTO);
	}
	
	//update
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", bankBookDTO);
	}
	
	
	//delete
	public int setDelete(Long num) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", num);
	}
}

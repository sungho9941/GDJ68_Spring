package com.iu.main.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.board.BoardDAO;
import com.iu.main.board.BoardDTO;
import com.iu.main.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO{
	@Autowired
	private SqlSession session;
	private final String NAMESPACE="com.iu.main.board.notice.NoticeDAO.";
	
	public NoticeFileDTO getFileDetail(NoticeFileDTO noticeFileDTO) throws Exception{
		return session.selectOne(NAMESPACE+"getFileDetail", noticeFileDTO);
	}
	
	public int setFileDelete(NoticeFileDTO noticeFileDTO) throws Exception{
		return session.delete(NAMESPACE+"setFileDelete", noticeFileDTO);
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {

		return session.selectList(NAMESPACE+"getList", pager);
	}
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		
		return session.selectOne(NAMESPACE+"getDetail", boardDTO);
	}
	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		
		return session.insert(NAMESPACE+"setAdd", boardDTO);
	}
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		
		return session.update(NAMESPACE+"setUpdate", boardDTO);
	}
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		
		return session.delete(NAMESPACE+"setDelete", boardDTO);
	}
	@Override
	public Long getTotal(Pager pager) throws Exception {
		
		return session.selectOne(NAMESPACE+"getTotal", pager);
	}
	@Override
	public int setHitUpdate(BoardDTO boardDTO) throws Exception {
		
		return 0;
	}
	
	public int setFileAdd(NoticeFileDTO noticeFileDTO)throws Exception{
		return session.insert(NAMESPACE+"setFileAdd", noticeFileDTO);
	}
	
}

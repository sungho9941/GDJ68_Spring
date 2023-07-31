package com.iu.main.member;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.util.FileManager;

@Service
public class MemberService {

		@Autowired
		private MemberDAO memberDAO;
		@Autowired
		private FileManager fileManager;
		
		public int setJoin(MemberDTO memberDTO, MultipartFile multipartFile, HttpSession session) throws Exception{
			//파일의 정보를 이용해서 HDD에 파일을 저장
			
			/*
			//1. 어디에 저장??
			String path="/resources/upload/member/";
			
			//2. 실제 경로 알아오기
			//jsp : application
			//java : ServletContext
			String realPath = session.getServletContext().getRealPath(path);
			System.out.println(realPath);
			
			File file = new File(realPath);
			
			if(!file.exists()) {
				file.mkdirs();
			}
			//3. 어떤 이름으로 저장?
			//1. 시간을 이용
//			Calendar ca = Calendar.getInstance();
//			long result = ca.getTimeInMillis();
//			file = new File(file, result+"_"+multipartFile.getOriginalFilename());
			
			//2. API 사용
			String uId = UUID.randomUUID().toString();
			System.out.println(uId);
			file = new File(file, uId+"_"+multipartFile.getOriginalFilename());
			
			//4. 파일을 저장
			//A. Spring에서 제공하는 API FileCopyUtils copy메서드
			//FileCopyUtils.copy(multipartFile.getBytes(), file);
			
			//B. MultipartFile의 transferTo메서드
			multipartFile.transferTo(file);
			*/
			String path="/resources/upload/member/";

			int result = memberDAO.setJoin(memberDTO);
			
			if(!multipartFile.isEmpty()) {
			String fileName = fileManager.fileSave(path, session, multipartFile);
			
			MemberFileDTO memberFileDTO = new MemberFileDTO();
			memberFileDTO.setId(memberDTO.getId());
			memberFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			memberFileDTO.setFileName(fileName);
			result = memberDAO.setFileJoin(memberFileDTO);
			
			}
			return result;//memberDAO.setJoin(memberDTO);
		}
		
		public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
			return memberDAO.getLogin(memberDTO);
		}
		
		public int setMemberUpdate(MemberDTO memberDTO) throws Exception{
			return memberDAO.setMemberUpdate(memberDTO);
		}
}

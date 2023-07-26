package com.iu.main.util;


public class Pager {

	private Long startRow;
	private Long lastRow;
	private Long page;
	private Long perPage; //한 페이지에 보여질 data(row) 개수
	
	private Long totalPage; //총 페이지 개수

	private Long startNum; // 시작번호
	
	private Long lastNum; // 끝번호
	
	
	public void makePageNum(Long total) {
		//130 -> 13
		//131-139 -> 14
		//90 ->9
		//91-99 -> 10
		
		//1. 전체 개수로 전체 페이지 수 구하기 ------------------- total : 총 데이터 개수, getPerPage : 페이지당 게시글 수 
		this.totalPage = total/this.getPerPage();
		if(total%this.getPerPage() !=0) {
			this.totalPage++;
		}
		
		
		//2. 전체 페이지수로 전체 block 수 구하기 ---------------- perBlock : 페이지에 출력할 번호 수
		//한 페이지에 출력할 번호의 개수
		long perBlock=5;
		
		long totalBlock = this.totalPage/perBlock;
		if(this.totalPage%perBlock !=0) {
			totalBlock++;
		}
		
		//3. 현재 page번호로 블럭번호 구하기
		//현재 블럭 번호
		long curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock !=0) {
			curBlock++;
		}
		
		//4. 현재 블럭번호의 시작번호와 끝번호 구하기
		// curBlock			startNum			lastNum
		// 1				1					5
		// 2				6					10
		// 3				11					15
		this.startNum=(curBlock-1)*perBlock+1;
		this.lastNum=curBlock*perBlock;
		

	}
	
	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	
	public void makeRowNum() {
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
		
	}

	
	
	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public Long getPage() {
		if(this.page==null) {
			this.page=1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

}

package com.iu.main.util;

/*
 * 1. 총 개수
 * 2. 총 페이지 수 계산
 * 3. 총 블럭수 계산
 * 4. page번호로 현재 블럭번호 계산
 * 5. 현재 블럭번호로 시작번호와 끝번호 계산
 * 6. 이전 블럭여부, 다음 블럭여부
 * 7. 현재 블럭이 마지막 블럭일 때 끝번호를 총페이지 숫자로 대입
 */
public class Pager {
	
	//검색관련 변수
	private String kind;
	private String search;

	private Long startRow;
	private Long lastRow;
	private Long page;
	private Long perPage; //한 페이지에 보여질 data(row) 개수
	
	private Long totalPage; //총 페이지 개수

	private Long startNum; // 시작번호
	
	private Long lastNum; // 끝번호
	
	//이전 블럭 활성화
	private boolean pre; // false면 1번블럭
	
	//다음 블럭 활성화
	private boolean next; // false면 마지막블럭
	
	
	public void makePageNum(Long total) { //total : 130 -> dao 통해서 받은 총 데이터수
		//130 -> 13
		//131-139 -> 14
		//90 ->9
		//91-99 -> 10
		
		//1. 전체 개수로 전체 페이지 수 구하기 ------------------- total : 총 데이터 개수, getPerPage : 페이지당 게시글 수 
		this.totalPage = total/this.getPerPage(); //13
		if(total%this.getPerPage() !=0) {
			this.totalPage++;
		}
		
		
		//2. 전체 페이지수로 전체 block 수 구하기 ---------------- perBlock : 페이지에 출력할 번호 수
		//한 페이지에 출력할 번호의 개수
		long perBlock=5;
		
		long totalBlock = this.totalPage/perBlock; //13/5
		if(this.totalPage%perBlock !=0) {
			totalBlock++;
		}
		
		//3. 현재 page번호로 블럭번호 구하기
		//현재 블럭 번호
		long curBlock = this.getPage()/perBlock; // 1/5
		if(this.getPage()%perBlock !=0) {
			curBlock++;
		}
		
		//4. 현재 블럭번호의 시작번호와 끝번호 구하기
		// curBlock			startNum			lastNum
		// 1				1					5
		// 2				6					10
		// 3				11					15
		this.startNum=(curBlock-1)*perBlock+1;  // startNum = (1-1)*5+1 = 1
		this.lastNum=curBlock*perBlock;
		
		//이전 블럭 활성화 여부
		if(curBlock>1) {
			this.pre=true;
		}

		//다음 블럭 활성화 여부
		if(curBlock<totalBlock) {
			this.next=true;
		}
		
		//현재 블럭이 마지막 블럭일 때 lastNum을 totalPage숫자로 대입
//		if(curBlock==totalBlock) {
			if(!this.next) {
				this.lastNum=totalPage;
			}

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

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(this.search == null) {
			this.search = "";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	
	
}

package co.kr.cmmn;

public class PageMaker {
	private int totalCount; // 실제 게시물 수
	private int startPage; // 현재 페이지 기준 시작 페이지 번호
	private int endPage; // 현재 페이지 기준 끝 페이지 번호
	private boolean prev; // 이전 버튼 활성화 여부
	private boolean next; // 다음 버튼 활성화 여부
	private int displayPageNum = 10; // 화면에 보여질 페이지 번호 수
	private Criteria cri; // page(현재 페이지), perPageNum(페이지 당 보여질 게시물의 수)

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	
	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	private void calcData() {
		int page = this.cri.getPage();
		int perPageNum = this.cri.getPerPageNum();
		
		this.endPage = (int)(Math.ceil(page/(double)displayPageNum)*displayPageNum);
		
		this.startPage = (this.endPage-displayPageNum) + 1;
		
		int tempEndPage = (int)(Math.ceil(totalCount/(double)perPageNum));
		
		if(this.endPage > tempEndPage) {
			this.endPage = tempEndPage;
		}
		this.setPrev((startPage != 1));
		this.setNext((endPage * perPageNum < totalCount));
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}
}
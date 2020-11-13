package co.kr.cmmn;

public class PageMaker {
	private int totalCount; // ���� �Խù� ��
	private int startPage; // ���� ������ ���� ���� ������ ��ȣ
	private int endPage; // ���� ������ ���� �� ������ ��ȣ
	private boolean prev; // ���� ��ư Ȱ��ȭ ����
	private boolean next; // ���� ��ư Ȱ��ȭ ����
	private int displayPageNum = 10; // ȭ�鿡 ������ ������ ��ȣ ��
	private Criteria cri; // page(���� ������), perPageNum(������ �� ������ �Խù��� ��)

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
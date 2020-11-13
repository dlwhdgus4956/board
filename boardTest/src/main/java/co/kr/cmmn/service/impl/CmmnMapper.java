package co.kr.cmmn.service.impl;

import java.util.List;

import co.kr.cmmn.BoardVo;
import co.kr.cmmn.Criteria;

public interface CmmnMapper {
	public List<BoardVo> getList(); // ���
	public BoardVo info(int id); // �Խù� ����
	public void write(BoardVo boardVo); // �Խù� ����
	public int edit(BoardVo boardVo); //�Խù� ����
	public int delete(BoardVo boardVo); //�Խù� ����
//	public int countBoard();
//	public List<BoardVo> selectBoard(PagingVo pvo);
	public int count(Criteria cri); //�Խ��� �۰��� ī��Ʈ
	public List<BoardVo> page(Criteria cri);
}

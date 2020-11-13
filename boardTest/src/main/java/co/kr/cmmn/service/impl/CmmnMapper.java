package co.kr.cmmn.service.impl;

import java.util.List;

import co.kr.cmmn.BoardVo;
import co.kr.cmmn.Criteria;

public interface CmmnMapper {
	public List<BoardVo> getList(); // 목록
	public BoardVo info(int id); // 게시물 정보
	public void write(BoardVo boardVo); // 게시물 생성
	public int edit(BoardVo boardVo); //게시물 수정
	public int delete(BoardVo boardVo); //게시물 삭제
//	public int countBoard();
//	public List<BoardVo> selectBoard(PagingVo pvo);
	public int count(Criteria cri); //게시판 글개수 카운트
	public List<BoardVo> page(Criteria cri);
}

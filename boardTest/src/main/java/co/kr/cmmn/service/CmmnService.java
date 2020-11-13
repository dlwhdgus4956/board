package co.kr.cmmn.service;

import java.util.List;

import co.kr.cmmn.BoardVo;
import co.kr.cmmn.Criteria;

public interface CmmnService {
	public List<BoardVo> getList();
	public BoardVo info(int id);
	public void write(BoardVo boardVo);
	public int edit(BoardVo boardVo);
	public int delete(BoardVo boardVo);
//	public int countBoard();
//	public List<BoardVo> selectBoard(PagingVo pvo);
	public int count(Criteria cri);
	public List<BoardVo> page(Criteria cri);	
}

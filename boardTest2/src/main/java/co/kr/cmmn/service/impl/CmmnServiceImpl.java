package co.kr.cmmn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.cmmn.BoardVo;
import co.kr.cmmn.Criteria;
import co.kr.cmmn.service.CmmnService;

@Service
public class CmmnServiceImpl implements CmmnService {
	@Autowired
	private CmmnMapper mapper;
	
	@Override
	public List<BoardVo> getList() {
		List<BoardVo> list = mapper.getList();
		return list;
	}
	@Override
	public BoardVo info(int id) {
		return mapper.info(id);
	}
	@Override
	public void write(BoardVo boardVo) {
		mapper.write(boardVo);
	}
	@Override
	public int edit(BoardVo boardVo) {
		return mapper.edit(boardVo);
	}
	@Override
	public int delete(BoardVo boardVo) {
		return mapper.delete(boardVo);
	}
	@Override
	public int count(Criteria cri) {
		return mapper.count(cri);
	}
	@Override
	public List<BoardVo> page(Criteria cri) {
		return mapper.page(cri);
	}
}

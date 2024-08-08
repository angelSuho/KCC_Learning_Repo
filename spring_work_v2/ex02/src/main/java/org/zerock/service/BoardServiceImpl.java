package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {
	private final BoardMapper boardMapper;

	@Override
	public void register(BoardVO board) {
		log.info("register.................");
		boardMapper.insertSelectKey(board);
	}

	@Override
	public List<BoardVO> getList() {
		log.info("getList.................");
		return boardMapper.getList();
	}

	@Override
	public BoardVO get(long bno) {
		log.info("get.................");
		return boardMapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify.................");
		return boardMapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove.................");
		return boardMapper.delete(bno) == 1;
	}
}

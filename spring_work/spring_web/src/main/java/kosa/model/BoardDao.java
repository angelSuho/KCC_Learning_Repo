package kosa.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosa.mapper.BoardMapper;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate sqlTemplate;
	
	public void insertBoard(Board board) {
		BoardMapper mapper = sqlTemplate.getMapper(BoardMapper.class);
		mapper.insertBoard(board);
	}
	
	public List<Board> listBoard() {
		BoardMapper mapper = sqlTemplate.getMapper(BoardMapper.class);
		return mapper.listBoard();
	}
	
	public Board detailBoard(int seq) {
		BoardMapper mapper = sqlTemplate.getMapper(BoardMapper.class);
		return mapper.detailBoard(seq);
	}
}

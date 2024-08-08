package org.zerock.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class BoardMapperTestCases {
	
	@Autowired
	private BoardMapper mapper;

//	@Test
//	public void getList() {
//		List<BoardVO> list = mapper.getList();
//		list.forEach(board -> log.info("board: {}", board));
//	}
//
//	@Test
//	public void insert() {
//		BoardVO boardVO = new BoardVO();
//		boardVO.setTitle("이수호입니다.");
//		boardVO.setContent("반갑습니다.");
//		boardVO.setWriter("이수호");
//		
//		mapper.insert(boardVO);
//	}
//
//	@Test
//	public void insertSelectKey() {
//		BoardVO boardVO = new BoardVO();
//		boardVO.setTitle("이수호입니다. selectKey 입니다.");
//		boardVO.setContent("반갑습니다. selectKey 입니다.");
//		boardVO.setWriter("이수호");
//		
//		mapper.insertSelectKey(boardVO);
//		log.info("board: {}", boardVO);
//		assertThat(boardVO.getBno()).isNotNull();
//	}
//	
//	@Test
//	public void testRead() {
//		BoardVO board = mapper.read(4L);
//		log.info("board: {}", board);
//		assertThat(board.getBno()).isEqualTo(4L);
//		assertThat(board.getTitle()).isEqualTo("이수호입니다. selectKey 입니다.");
//		assertThat(board.getContent()).isEqualTo("반갑습니다. selectKey 입니다.");
//		assertThat(board.getWriter()).isEqualTo("이수호");
//	}
//	
//	@Test
//	public void delete() {
//		int deleteCount = mapper.delete(4L);
//		log.info("delete: {}", deleteCount);
//		assertThat(deleteCount).isEqualTo(2);
//	}
	
	@Test
	public void update() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(3L);
		boardVO.setTitle("수정사항 제목");
		boardVO.setContent("수정사항 내용");
		boardVO.setWriter("이수호");
		
		int updteCnt = mapper.update(boardVO);
		log.info("update count: {}", updteCnt);
		List<BoardVO> list = mapper.getList();
		log.info("?: {}", list.get(2).getTitle());
		assertThat(list.get(2).getTitle()).isEqualTo("수정사항 ㄴㄴ제목");
	}
}

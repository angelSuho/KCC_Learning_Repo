package org.zerock.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

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
public class BoardServiceTests {

	@Autowired
	private BoardService boardService;
	
//	@Test
//	public void register() {
//		BoardVO boardVO = new BoardVO();
//		boardVO.setTitle("ㅎㅇtitle");
//		boardVO.setContent("ㅎㅇcontent");
//		boardVO.setWriter("ㅎㅇwriter");
//		
//		boardService.register(boardVO);
//		List<BoardVO> boards = boardService.getList();
//		log.info("`: {} {}", boards.get(boards.size()-1).getTitle(), boardVO.getTitle());
//		assertThat(boards.get(boards.size()-1).getTitle()).isEqualTo(boardVO.getTitle());
//	}
//	
//	@Test
//	public void GetList() {
//		boardService.getList().forEach(board -> log.info("board: {}", board));
//	}
	
	@Test
	public void get() {
		BoardVO boardVO = boardService.get(3L);
		log.info("board: {}", boardVO);
	}
	
	@Test
	public void modify() {
		BoardVO boardVO = boardService.get(1L);
		boardVO.setTitle("updateTitle");
		boardVO.setContent("updateContent");
		boardVO.setWriter("updateWriter");
		
		boolean modifyBoard = boardService.modify(boardVO);
		assertEquals(modifyBoard, true);
	}
	
//	@Test
//	public void delete() {
//		boolean deleteBoard = boardService.remove((long) (boardService.getList().size()-1));
//		assertEquals(deleteBoard, true);
//	}
	
	
}

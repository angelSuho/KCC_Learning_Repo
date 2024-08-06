package kosa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kosa.model.Board;
import kosa.model.BoardDao;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDao dao;

	// board_insert -> insert_form.jsp Ãâ·Â
	@GetMapping("/board_insert")
	public String insertBoard() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("insert_form");

		return "insert_form";
	}
	
	@PostMapping("/board_insert")
	public String boardInsert(Board board) {
		System.out.println(board);
		dao.insertBoard(board);
		return "redirect:board_list";
	}
	
	@GetMapping("/board_list")
	public String board_list(Model model) {
		List<Board> list = dao.listBoard();
		model.addAttribute("list", list);
		return "list";
	}
	
//	@GetMapping("board_detail")
//	public String board_detail(@RequestParam(value = "seq") int seq,  Model model) {
//		Board detailBoard = dao.detailBoard(seq);
//		model.addAttribute(detailBoard);
//		return "detail";
//	}
	
	@GetMapping("board_detail/{seq}")
	public String board_detail(@PathVariable(value = "seq") int seq,  Model model) {
		Board detailBoard = dao.detailBoard(seq);
		model.addAttribute(detailBoard);
		return "detail";
	}
}

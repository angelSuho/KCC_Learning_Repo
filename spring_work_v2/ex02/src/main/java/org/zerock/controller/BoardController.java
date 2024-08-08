package org.zerock.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/board")
@Slf4j
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(BoardVO boardVO, RedirectAttributes rttr) {
		boardService.register(boardVO);
		rttr.addFlashAttribute("result", boardVO.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	public void getlist(HttpServletRequest request, Model model) {
		log.info("/get or /modify .....{}", request.getRequestURL());
		model.addAttribute("list", boardService.getList());
	}
	
	@GetMapping({"/get", "/modify"})
	public String get(@RequestParam(value="bno") Long bno, Model model, RedirectAttributes redirectAttributes) {
	    model.addAttribute("board", boardService.get(bno));
	    redirectAttributes.addAttribute("status", "itemViewed");
	    return "redirect:/board/list"; // 사용자를 리스트 페이지로 리다이렉트
	}

	
	@PostMapping("/modify")
	public String modify(BoardVO boardVO, RedirectAttributes rttr) {
		if (boardService.modify(boardVO)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam(value = "bno") Long bno, RedirectAttributes rttr) {
		if (boardService.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
}

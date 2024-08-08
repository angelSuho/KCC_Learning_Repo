package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/sample")
@Slf4j
public class SampleController {
	
	@GetMapping("/basic")
	public void basicGet() {
		log.info("sample");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDto dto) {
		log.info("ex01......");
		log.info("dto: {}", dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam(value = "name") String name,
			@RequestParam(value = "age") int age) {
		log.info("이름: {}", name);
		log.info("나이: {}", age);
		return "ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(RedirectAttributes rttr) {
		rttr.addAttribute("name", "suho");
		rttr.addAttribute("age", 30);
		rttr.addAttribute("page", 100);

		return "redirect:/sample/ex04";
	}
	
	// Model 버전
//		@GetMapping("/ex04")
//		public String ex04(SampleDto dto, Model model) {
//			log.info("ex04......");
//			log.info("dto: {}", dto);
//			model.addAttribute("dto", dto);
//			return "ex04";
//		}
	
	// View -> Controller -> View
	@GetMapping("/ex04")
	public String ex04(SampleDto dto, @ModelAttribute(value = "page") int page) {
		log.info("ex04......");
		log.info("dto: {}", dto);
		log.info("page: {}", page);

		return "ex04";
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("ex05......");
	}
	
	@GetMapping("/ex06")
	@ResponseBody
	public SampleDto ex06() {
		SampleDto dto = new SampleDto();
		dto.setName("수호");
		dto.setAge(26);
		
		return dto;
	}

	// 내 방식
//	@GetMapping("/ex07")
//	@ResponseBody
//	public ResponseEntity<SampleDto> ex07() {
//		SampleDto dto = new SampleDto();
//		dto.setName("수호");
//		dto.setAge(26);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(dto);
//	}
	
	// 교수님 방식
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("ex07......");
		// {"name":이수호}
		String message = "{\"name\":\"이수호\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");

		return new ResponseEntity<String>(message, header, HttpStatus.OK);
	}
	
	// return 타입을 void -> exUpload.jsp 출력
	@GetMapping("/exUpload")
	public void upload() {
		log.info("upload method run");
	}
	
	@PostMapping("/exUploadPost")
	public void upload(List<MultipartFile> files) {
		files.forEach(file -> {
			log.info("---------");
			log.info("file original name: {}", file.getOriginalFilename()); // 파일의 이름
			log.info("file name: {}", file.getName()); // 파일 객체의 변수 이름
			log.info("file size: {}", file.getSize()); // 파일 사이즈
		});
	}
}

package com.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.web.model.BoardVO;
import com.spring.web.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private IBoardService service;
	
	//글 작성 화면 요청
	@GetMapping("/write")
	public void write() {
		System.out.println("/board/write:GET");
	}
	
	//작성된 글 등록 처리 요청
	//작성된 글을 리스트에 등록한 후 /board/list.jsp파일로 응답할 수 있도록 처리
	@PostMapping("/write")
	public String write(BoardVO article) {
		service.insertArticle(article);
		return "redirect:/board/list";
	}
	
	//글 목록 화면 요청
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("/board/list:GET");
		//DB대용 리스트에서 가지고 온 글 목록을 list.jsp파일로 전달해서
		//브라우저에 글 목록을 띄워 주기
		model.addAttribute("articles",service.getArticles());
		
	}
	
	//글 내용보기 요청
	@GetMapping("/content")
	public void content(@ModelAttribute("boardNo") int boardNo, Model model) {
		//DB역할을 하는 리스트에서 글번호에 해당하는 글 객체를 content.jsp로 보내주기
		System.out.println("/board/content?boardNo="+boardNo+":GET");
		model.addAttribute("article",service.getArticle(boardNo));
	}
	
	//글 수정하기 요청
	@GetMapping("/modify")
	public void modify(@ModelAttribute("boardNo") int boardNo, Model model) {
		System.out.println("/board/modify?boardNo="+boardNo+":GET");
		model.addAttribute("article",service.getArticle(boardNo));
	}
	
	//글 수정을 처리하는 요청
	@PostMapping("/modify")
	public String modify(@ModelAttribute("boardNo") int boardNo, BoardVO article) {
		service.updateArticle(article, boardNo);
		return "redirect:/board/content?boardNo="+boardNo;
	}
	
	//글 삭제를 처리하는 요청
	@GetMapping("/delete")
	public String delete(int boardNo) {
		service.deleteArticle(boardNo);
		return "redirect:/board/list";
	}
	
	
	
}

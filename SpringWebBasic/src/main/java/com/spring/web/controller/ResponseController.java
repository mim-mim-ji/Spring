package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.web.model.UserVO;

@Controller
@RequestMapping("/response")
public class ResponseController {

	@GetMapping("/res-ex01")
	public void resEx01() {
		
	}
	
	//1.model객체를 사용하여 화면에 데이터 전송하기
//	@GetMapping("/test")
//	public void test(@RequestParam("age") int age, Model model) {
//		
//		model.addAttribute("age",age);
//		model.addAttribute("nick","멍멍이");
//		
//	}
	
	//2. modelAtrribute를 사용한 화면에 데이터 전송 처리
	//@RequestParam + model.addAttribute
//	@GetMapping("/test")
//	public void test(@ModelAttribute("age") int age,Model model) {
//		model.addAttribute("nick","멍멍이");
////	model.addAttribute("age",age); -> 적을 필요없음
//	}
	
	
	//3. modelAndView 객체를 활용한 처리
	@GetMapping("/test2")
	public ModelAndView test2() {
		
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("userName","김철수");
//		mv.setViewName("/response/test2");
		
		//위의 세줄 + return mv;와 아래 한줄은 같은 의미
		return new ModelAndView("/response/test2","userName","홍길동");
	}
	
	
	///////////////////////////////////////////////
	
	//res-ex02.jsp파일을 열람하는 요청메서드 작성
	@GetMapping("/res-ex02")
	public void resEx02() {
		
	}
	
	
	@PostMapping("/join")
	public String join(@ModelAttribute("user") UserVO user) {
		
//		또는 Model model 객체 선언 후 
//		model.addAttribute("user",user);
		
		return "/response/test3";
	}
	
	
	
	/////////////////  quiz   ///////////////////////
	
	@GetMapping("/res-quiz")
	public void resQuiz() {
		
	}
	
	@PostMapping("/res-login")
	public String resLogin(@ModelAttribute("userID") String id,
							@RequestParam("userPW") String pw) {
		if(id.equals("kim123") && pw.equals("kkk1234")) {
			return "/response/res-quiz-success";
		}else {
			return "/response/res-quiz-fail";
		}
								
	}
	
	
	
//	@PostMapping("/res-login")
//	public String resLogin(UserVO vo, Model model) {
//		
//		String id = vo.getUserID();
//		String pw = vo.getUserPW();
//		
//		model.addAttribute("userID",id);
//		
//		if(id.equals("kim123") && pw.equals("kkk1234")) {
//			return "/response/res-quiz-success";
//		} else {
//			return "/response/res-quiz-fail";
//		}
//	}
//	
//	
	
	//////////////////////////////////////////////
	
	//Redirect 처리
	//로그인 화면 요청 처리
	@GetMapping("/login")
	public String login() {
		System.out.println("/login: GET요청 발생");
		return "response/res-redirect-form";
	
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("userID") String id,
						@RequestParam("userPW") String pw,
						@RequestParam("userPwChk") String pwk,
						RedirectAttributes ra) {
		
		System.out.println("/login : POST요청");
		System.out.println("id: "+id);
		System.out.println("pw: "+pw);
		System.out.println("pw: "+pwk);
		
		if(id.equals("")) {
			ra.addFlashAttribute("msg", "아이디는 필수값입니다");
			return "redirect:/response/login";
		}
		return "";
	}
	
	
}








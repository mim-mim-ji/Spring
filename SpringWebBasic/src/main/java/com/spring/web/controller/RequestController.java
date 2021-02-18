package com.spring.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.web.model.UserVO;

//자동으로 스프링컨테이너에 해당 클래스의 빈을 등록하는 아노테이션.
@Controller
@RequestMapping("/request")
public class RequestController {
	
	public RequestController() {
		System.out.println("RequestController 작동!");
	}
	
	// @RequestMapping 은 어떤 URI로 이 메서드를 동작시킬 것인가에 대한 설정
	// /request/test라는 요청이 들어오면 메서드 실행
	@RequestMapping("/test")
	public String testCall() {
		System.out.println("/request/test 요청이 들어옴!");
		return "test";
	}
	// /WEB-INF/views/test.jsp를 찾아줌
	
	
//	만약 /request/req요청이 들어왔을 때 views폴더 아래에 있는
//	request폴더 아래에 req-ex01.jsp파일을 열도록 메서드 구성

	@RequestMapping("/req")
	public String req() {
		System.out.println("/request/req 요청이 들어옴");
		return "request/req-ex01";
	}
	
	//@RequestMapping(value="/request/basic01",method=RequestMethod.GET)
	@GetMapping("/basic01")
	public String basicGet() {
		System.out.println("/request/basic01 요청이 들어옴! : GET");
		return "/request/req-ex01";
	}
	
	//@RequestMapping(value="/request/basic01",method=RequestMethod.POST)
	@PostMapping("/basic01")
	public String basicPost() {
		System.out.println("/request/basic01 요청이 들어옴! : POST");
		return "/request/req-ex01";
	}
	
	
	//컨트롤러의 요청메서드를 void리턴타입으로 지정
	@GetMapping("/req-ex02")
	public void reqEX02() {
		System.out.println("/request/req-ex02 요청이 들어옴!");
	}
	//요청url 경로에 맞는 파일을 찾아줌
	
	
	/////////////////////////////////////////////////////////
	
	@GetMapping("/join")
	public void register() {
		System.out.println("/request/join : GET");
	}
	
	/* 1. 전통적인 jsp/servlet 방식의 파라미터 읽기 처리 방법
	 * - HttpServletRequest 객체를 사용
	 */
	
//	@PostMapping("/join")
//	public String register(HttpServletRequest request) {
//		System.out.println("/request/join : POST");
//		
//		System.out.println("ID :"+request.getParameter("userID"));
//		System.out.println("PW :"+request.getParameter("userPW"));
//		System.out.println("Hobby :"+Arrays.toString(request.getParameterValues("hobby")));
//		System.out.println("NAME :"+request.getParameter("userNAME"));
//	
//		return "/request/join";
//	}
	
	
	//2. @RequestParam 아노테이션을 이용한 요청 파라미터 처리
	
//	@PostMapping("/join")
//	public void register(@RequestParam("userID") String id,
//						@RequestParam("userPW") String pw,
//						@RequestParam("userNAME") String name,
//						@RequestParam(value="hobby",required=false,defaultValue = "no hobby") List<String> hobbys) {
//		                //userID라는 이름의 파라미터를 가져와서 id에 넣음
//		System.out.println("ID :"+id);
//		System.out.println("PW :"+pw);
//		System.out.println("NAME :"+name);
//		System.out.println("HOBBY :"+hobbys);
//	}
	
	//3. 커맨드 객체를 활용한 파라미터 처리
	@PostMapping("/join")
	public void register(UserVO user) {
		System.out.println("커맨드 객체");
		System.out.println("ID :"+user.getUserID());
		System.out.println("PW :"+user.getUserPW());
		System.out.println("NAME :"+user.getUserNAME());
		System.out.println("Hobby :"+user.getHobby());

	}
	
	///////////////////         QUIZ       //////////////////////////
	
	@GetMapping("/quiz")
	public String quiz() {
		System.out.println("/request/quiz : GET");
		return "/request/req-quiz";
	}
	
//	@RequestMapping(value="/quiz", method=RequestMethod.POST)
//	public String quiz(@RequestParam("userID")String id,
//						@RequestParam("userPW")String pw) {
//		if(id.equals("abc1234") && pw.equals("aaa1111")) {
//			return "/request/login-success";
//		}else 
//			return "/request/login-fail";
//		
//	}
	
	@PostMapping("/quiz")
	public String quiz(UserVO vo) {
		if(vo.getUserID().equals("abc1234") && vo.getUserPW().equals("aaa1111")) {
			System.out.println("로그인 성공");
			return "/request/login-success";
		}else {
			System.out.println("로그인 실패");
			return "/request/login-fail";
			
		}
	}
}











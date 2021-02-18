package com.spring.basic.quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 1. quiz-config.xml에 모니터 마우스 키보드 컴퓨터 빈을 생성
		 2. Computer클래스에서 자동 주입을 설정
		 3. xml에서 빈을 얻은 후, computerinfo()메서드를 실행  
		 */
		
		GenericXmlApplicationContext ct = 
				new GenericXmlApplicationContext("classpath:quiz-config.xml");
		
		Computer computer = ct.getBean("computer",Computer.class);
		computer.computerInfo();

	}

}

package com.example.aoptest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("config/applicationContext.xml");
	
		
		ProductService ps = ac.getBean(ProductService.class);
		ProductVo vo = ps.findProduct("노트북");
		
		vo=ps.findProduct("bomb");
		System.out.println("검색된 제품: "+vo);
		
	}

}

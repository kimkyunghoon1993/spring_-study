package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Hello {
	int iv = 10; //
	static int cv = 20; //
	
	// 2. URL
	@RequestMapping("/hello")
	private void main() { //
		System.out.println("Hello - private ");
		System.out.println(cv); // OK
//		System.out.println(iv); // OK		
	}
	
	public static void main2() { //
		System.out.println(cv); // OK
//		System.out.println(iv); //
	}
}

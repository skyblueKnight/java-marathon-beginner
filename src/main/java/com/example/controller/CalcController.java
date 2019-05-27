package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calc")
public class CalcController {
	
	@Autowired
	private HttpSession session;

	/**
	 * 値入力画面に遷移する.
	 * 
	 * @return 値入力画面
	 */
	@RequestMapping("")
	public String index() {
		return "input-value";
	}
	
	/**
	 * 値出力画面１に遷移する.
	 * 
	 * @return 値出力画面１
	 */
	@RequestMapping("/to-output-value")
	public String toOutputValue() {
		return "output-value";
	}
	
	/**
	 * 値入力画面に遷移する.
	 * 
	 * @return 値入力画面
	 */
	@RequestMapping("/to-output-value2")
	public String toOutputValue2() {
		return "output-value2";
	}
	
	
	@RequestMapping("/calc-mult")
	public String CalcMult(int num1, int num2) {
		
		session.setAttribute("num1", num1);
		session.setAttribute("num2", num2);
		session.setAttribute("result", (num1*num2));
		
		return "output-value";
	}

}

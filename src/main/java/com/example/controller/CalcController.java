package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 入力された二つの値を計算するコントローラ.
 * 
 * @author momoyo kanie
 *
 */
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
	 * 結果出力画面２に遷移する.
	 * 
	 * @return 結果出力画面２
	 */
	@RequestMapping("/to-output-value2")
	public String toOutputValue2() {
		return "output-value2";
	}
	
	
	/**
	 * 入力された二つの値の掛け算を行う.
	 * 計算を行った後、sessionスコープに入れる。
	 * 
	 * @param num1 入力された値１つめ
	 * @param num2 入力された値２つめ
	 * @return　結果出力画面１
	 */
	@RequestMapping("/calc-mult")
	public String CalcMult(int num1, int num2) {
		
		session.setAttribute("num1", num1);
		session.setAttribute("num2", num2);
		session.setAttribute("result", (num1*num2));
		
		return "output-value";
	}

}

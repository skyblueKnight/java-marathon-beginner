package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user-info")
public class UserInfoController {
	
	@Autowired
	private HttpSession session;
	

	/**
	 * ユーザ情報登録画面に遷移する.
	 * 
	 * @return ユーザ情報登録画面
	 */
	@RequestMapping("")
	public String index() {
		return "input-user-info";
	}
	
	/**
	 * ユーザ情報出力画面に遷移する.
	 * 
	 * @return ユーザ情報出力画面
	 */
	@RequestMapping("/to-output-user-info")
	public String toOutputUserInfo() {
		return "output-user-info";
	}
	
	
	/**
	 * ユーザ情報を受け取ってセッションスコープに入れる.
	 * 
	 * @param name　入力されたユーザの名前
	 * @param age　入力されたユーザの年齢
	 * @param address　入力されたユーザの住所
	 * @return　出力画面遷移のメソッド（リダイレクト）
	 */
	@RequestMapping("/receive-info")
	public String receiveInfo(String name, Integer age, String address) {
		
		session.setAttribute("name", name);
		session.setAttribute("age",age);
		session.setAttribute("address",address);
		
		return "redirect:/user-info/to-output-user-info";
	}
	
}

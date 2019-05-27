package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user-info")
public class UserInfoController {

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
		System.out.println("to-outoput");
		return "output-user-info";
	}
	
	
	/**
	 * ユーザ情報を受け取ってリクエストスコープに入れる.
	 * 
	 * @param name　入力されたユーザの名前
	 * @param age　入力されたユーザの年齢
	 * @param address　入力されたユーザの住所
	 * @param model　モデル
	 * @return　出力画面遷移のメソッド（リダイレクト）
	 */
	@RequestMapping("/receive-info")
	public String receiveInfo(String name, Integer age, String address,Model model) {
		
		System.out.println("receive");
		return "redirect:/user-info/to-output-user-info";
	}
	
}

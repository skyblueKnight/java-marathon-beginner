package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.UserForm;

@Controller
@RequestMapping("/user-info")
public class UserInfoController {
	
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}

		

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
	 * ユーザ情報を受け取ってドメインに入れる.
	 * ドメインに入れた後、リクエストスコープに入れる。
	 * 
	 * @param name　入力されたユーザの名前
	 * @param age　入力されたユーザの年齢
	 * @param address　入力されたユーザの住所
	 * @return　出力画面遷移のメソッド（リダイレクト）
	 */
	@RequestMapping("/receive-info")
	public String receiveInfo(UserForm userForm, Model model) {
		
		User user = new User();
		user.setName(userForm.getName());
		user.setAge(userForm.getIntAge());
		user.setAddress(userForm.getAddress());
		
		model.addAttribute("user",user);
	
		return "output-user-info";
	}
	
}

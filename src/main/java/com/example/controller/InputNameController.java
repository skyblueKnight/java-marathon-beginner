package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/name")
public class InputNameController {
	
	@RequestMapping("")
	public String index() {
		return "input-name";
	}

	/**
	 * 名前を受け取ってリクエストスコープに入れる.
	 * 
	 * @param name　入力された名前
	 * @param model モデル
	 * @return アウトプット画面
	 */
	@RequestMapping("/input-name")
	public String inputName(String name,Model model) {
		model.addAttribute("name",name);
		
		return "output-name";		
	}
}

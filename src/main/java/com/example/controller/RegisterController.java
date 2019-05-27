package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 購入したグッズの合計金額（税抜き・税込み）を計算するコントローラ.
 * 
 * @author momoyo kanie
 *
 */
@Controller
@RequestMapping("/rezister")
public class RegisterController {

	@Autowired
	private ServletContext application;
	
	/**
	 * 商品購入画面に遷移する.
	 * 
	 * @return 商品購入画面
	 */
	@RequestMapping("")
	public String index() {
		return "buy-goods";
	}
	
	
	@RequestMapping("/calc-total")
	public String calcTotal(Integer goods1, Integer goods2, Integer goods3) {
		application.setAttribute("goods1", goods1);
		application.setAttribute("goods2", goods2);
		application.setAttribute("goods3", goods3);
		application.setAttribute("BeforeTaxPrice", (goods1 + goods2 + goods3));
		application.setAttribute("taxInclusivePrice", ((goods1 + goods2 + goods3)*1.08));
		
		
		return "total-goods";
	}
	
	
}

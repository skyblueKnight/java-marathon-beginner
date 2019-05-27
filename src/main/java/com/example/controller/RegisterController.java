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
	
	
	/**
	 * 合計金額出力画面に遷移する.
	 * 
	 * @return 合計金額出力画面
	 */
	@RequestMapping("/to-total-price")
	public String toTotalPrice() {
		return "total-price";
	}
	
	
	/**
	 * 購入されたグッズの税抜き・税込み価格の合計を求める.
	 * 
	 * @param goods1　購入されたグッズ１の価格
	 * @param goods2　購入されたグッズ２の価格
	 * @param goods3　購入されたグッズ３の価格
	 * @return 合計金額出力画面（リダイレクト）
	 */
	@RequestMapping("/calc-total")
	public String calcTotal(Integer goods1, Integer goods2, Integer goods3) {
		application.setAttribute("beforeTaxPrice", (goods1 + goods2 + goods3));
		application.setAttribute("taxInclusivePrice", (int)((goods1 + goods2 + goods3)*1.08));
		
		
		return "redirect:/rezister/to-total-price";
	}
	
	
}

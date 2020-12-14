package com.tj.test04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.test04.dto.Memo;
import com.tj.test04.service.MemoService;

@Controller
public class MemoController {
	@Autowired
	private MemoService memoService;
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(String pageNum, Model model) {
		model.addAttribute("list",memoService.memoList(pageNum, model));
		return "list";
	}
	@RequestMapping(value="insert100", method=RequestMethod.GET)
	public String insert100() {
		memoService.insert100();
		return "redirect:list.do";
	}
	@RequestMapping(value="append", method=RequestMethod.GET)
	public String append(String pageNum, Model model) {
		model.addAttribute("appendList",memoService.memoList(pageNum, model));
		return "append";
	}
	@RequestMapping(value="memoInsert", method=RequestMethod.GET)
	public String memoInsert(Memo memo, Model model, HttpServletRequest request) {
		memoService.memoInsert(memo, model, request);
		return "insertMemo";
	}
}

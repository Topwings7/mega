package com.tj.test04.service;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tj.test04.dao.MemoDao;
import com.tj.test04.dto.Memo;
@Service
public class MemoServiceImpl implements MemoService {
	@Autowired
	private MemoDao memoDao;
	@Override
	public int memoInsert(Memo memo, Model model, HttpServletRequest request) {
		memo.setIp(request.getRemoteAddr());
		memo.setRdate(new Timestamp(System.currentTimeMillis()));
		int result = 0;
		try {
			result = memoDao.memoInsert(memo);
			model.addAttribute("memo", memo);
			model.addAttribute("insertResult", "글 작성이 완료되었습니다");
		}catch (Exception e) {
			model.addAttribute("insertResult", "글 작성에 실패했습니다");
		}
		return result;
	}
	@Override
	public List<Memo> memoList(String pageNum, Model model) {
		Paging paging = new Paging(memoDao.getCnt(), pageNum);
		model.addAttribute("paging", paging); // model에 paging넣는거 서비스에서 넣음
		Memo memo = new Memo();
		memo.setStartRow(paging.getStartRow());
		memo.setEndRow(paging.getEndRow());
		if(paging.getCurrentPage()>paging.getPageCnt()) {
			model.addAttribute("noMore", "더 이상 없는 페이지 입니다");
		}
		return memoDao.memoList(memo);
	}
	@Override
	public int getCnt() {
		return memoDao.getCnt();
	}
	@Override
	public void insert100() {
		Memo memo = new Memo();
		for(int i=0 ; i<30 ; i++) {
			memo.setId("z"+i);
			memo.setContent(i+"만큼 좋아요");
			memo.setIp("192.168.20."+i);
			int result = memoDao.memoInsert(memo);
			System.out.println(result==1? i+"번재 insert성공":i+"번째 실패");
		}
	}
}

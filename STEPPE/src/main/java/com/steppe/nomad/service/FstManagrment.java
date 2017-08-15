package com.steppe.nomad.service;

import java.util.List; 
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Answer;
import com.steppe.nomad.bean.Test;
import com.steppe.nomad.dao.TestDao;

@Component
public class FstManagrment implements Action{
	@Autowired
	private TestDao tDao;
	@Autowired
	private HttpSession ss;
	@Autowired
	private HttpServletRequest req;


	private ModelAndView mav;


	public ModelAndView userExecute(int cmd) {
		switch(cmd){
		case 1 :
			selectTest();
			break;
		case 2 :
			doTest();
			break;
		case 3 :
			checkTest();
			break;
		}
		return mav;
	}

	@Override
	public ModelAndView execute(int cmd) {
		switch(cmd){
		case 1 :
			showFstDetail();
			break;
		case 2 :
			insertFst();
			break;
		case 3 :
			goUpdateFst();
			break;
		case 4 :
			updateFst();
			break;
		case 5 :
			deleteFst();
			break;
		case 6 :
			showFstList();
			break;
		}
		return mav;
	}

	private void checkTest() {
		System.out.println("이응?");
		String view = null;
		mav = new ModelAndView();
		Answer ans = new Answer();
		int a_insertnum = Integer.parseInt(req.getParameter("answer"));
		int a_tnum = Integer.parseInt(req.getParameter("a_tnum"));
		String a_tname = req.getParameter("a_tname");
		Test test = new Test();
			test.setT_name(a_tname);
			test.setT_num(a_tnum);
		int t_answer = tDao.getT_answer(test);
		String a_mid = (String) ss.getAttribute("id");
		System.out.println(a_insertnum);
		System.out.println(a_tnum);
			ans.setA_num(tDao.getAnswerMaxNum()+1);
			ans.setA_mid(a_mid);
			ans.setA_tnum(a_tnum);
			ans.setA_insertnum(a_insertnum);
			ans.setA_tname(a_tname);
		if(a_insertnum == t_answer){
			int a_check = 1;
			ans.setA_check(a_check);
		}else{
			int a_check = 0;
			ans.setA_check(a_check);
		}
		if(tDao.insertAnswer(ans)!=0){
			view = "/doTest";
		}
		mav.setViewName(view);
	}

	private void doTest() { //문제 풀기 시작
		String view = null;
		mav = new ModelAndView();
		System.out.println(req.getParameter("t_name"));
		String t_name = req.getParameter("t_name");
		String a_mid = (String) ss.getAttribute("id");
		Answer ans = new Answer();
			ans.setA_tname(t_name);
			ans.setA_mid(a_mid);
		System.out.println(t_name);
		System.out.println(a_mid);
		int tCnt = tDao.getTestCnt(ans);
		List<Test> tlist = null;
		int a[] = new int[10];
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		if(ss!=null && ss.getAttribute("id")!=null){
			tlist = tDao.getTestList(t_name);
			for(int i=0; i<10; i++){
				a[i] = r.nextInt(tlist.size());
				for(int j=0;j<i;j++){
					if(a[i] == a[j]){
						System.out.println("중복 제거");
						i--;
					}
				}
			}
		}
			if(tCnt>=0){
				Test t = tlist.get(a[tCnt]);
				System.out.println("번호 : "+t.getT_num());
				if(tCnt<10){
					sb.append("<tr><td><input type = 'text' id = 'a_tname' name = 'a_tname' value="+t.getT_name()+" readonly='readonly'/> 문제"+(tCnt+1)+"</td><td colspan = '2'>"+t.getT_content()+"</td></tr>");
					sb.append("<tr><td>1번 : </td><td colspan = '2'>"+t.getT_no1()+"<input type='radio' name='answer' id='answer1' value='1'/></td></tr>");
					sb.append("<tr><td>2번 : </td><td colspan = '2'>"+t.getT_no2()+"<input type='radio' name='answer' id='answer2' value='2'/></td></tr>");
					sb.append("<tr><td>3번 : </td><td colspan = '2'>"+t.getT_no3()+"<input type='radio' name='answer' id='answer3' value='3'/></td></tr>");
					sb.append("<tr><td>4번 : </td><td colspan = '2'>"+t.getT_no4()+"<input type='radio' name='answer' id='answer4' value='4'/></td></tr>");
					sb.append("<tr><td colspan = '3'><input id = 'a_tnum' 'type='hidden' name='a_tnum' value="+t.getT_num()+" readonly='readonly' /><input type = 'button' value = '입력' id='check'/></td></tr>");
					System.out.println(tCnt);
				}
				mav.addObject("tlist", sb.toString());
			}
			view = "fstTestContent";
			mav.setViewName(view);
	}

	private void selectTest() { //문제 풀기 공지
		System.out.println(req.getParameter("t_name"));
		String view = null;
		mav = new ModelAndView();
		mav.addObject("test",req.getParameter("t_name"));
		view = "fstTest";
		mav.setViewName(view);
	}

	private void deleteFst() { //관리자 시험 문제 삭제
		String view = null;
		mav = new ModelAndView();
		System.out.println("계정명:"+ss.getAttribute("id"));
		if(ss.equals("admin") || ss.getAttribute("id").equals("admin")){
			int t_num = Integer.parseInt(req.getParameter("t_num"));
			if(tDao.deleteFst(t_num)!=0){
				System.out.println("문제 삭제 성공");
			}else{
				System.out.println("문제 삭제 실패");
			}
			view = "fstMm";
		}else{
			view = "fstMm";
			System.out.println("관리자가 아닙니다.");
		}
		mav.setViewName(view);
	}

	private void updateFst() { //관리자 시험 문제 수정
		String view = null;
		mav = new ModelAndView();
		Test test = new Test();
		if(ss.equals("admin") || ss.getAttribute("id").equals("admin")){
			int t_answer = Integer.parseInt(req.getParameter("t_answer"));
			int t_num = Integer.parseInt(req.getParameter("t_num"));
			test.setT_num(t_num);
			test.setT_name(req.getParameter("t_name"));
			test.setT_content(req.getParameter("t_content"));
			test.setT_answer(t_answer);
			test.setT_no1(req.getParameter("t_no1"));
			test.setT_no2(req.getParameter("t_no2"));
			test.setT_no3(req.getParameter("t_no3"));
			test.setT_no4(req.getParameter("t_no4"));
			if(tDao.updateFst(test)!=0){
				System.out.println("문제수정성공");
			}else{
				System.out.println("문제수정실패");
			}
		}else{
			System.out.println("관리자가 아닙니다.");
		}
		view = "fstMm";
		mav.setViewName(view);
	}

	private void goUpdateFst() { //관리자 시험 문제 페이지이동
		String view = null;
		mav= new ModelAndView();
		int t_num = Integer.parseInt(req.getParameter("t_num"));
		mav.addObject("test",tDao.showFstDetail(t_num));
		view = "fstUpdate";
		mav.setViewName(view);
	}

	private void insertFst() { //관리자 시험 문제 추가
		String view = null;
		mav = new ModelAndView();
		Test test = new Test();
		if(ss.equals("admin") || ss.getAttribute("id").equals("admin")){
			int t_answer = Integer.parseInt(req.getParameter("t_answer"));
			test.setT_num(tDao.getTestMaxNum()+1);
			test.setT_name(req.getParameter("t_name"));
			test.setT_content(req.getParameter("t_content"));
			test.setT_answer(t_answer);
			test.setT_no1(req.getParameter("t_no1"));
			test.setT_no2(req.getParameter("t_no2"));
			test.setT_no3(req.getParameter("t_no3"));
			test.setT_no4(req.getParameter("t_no4"));
			System.out.println(test);
			if(tDao.insertFst(test)!=0){
				System.out.println("문제추가성공");
			}else{
				System.out.println("문제추가실패");
			}
		}else{
			System.out.println("관리자가 아닙니다.");
		}
		view = "fstMm";
		mav.setViewName(view);
	}

	private void showFstDetail() { //관리자 시험 문제 상세보기
		String view = null;
		mav= new ModelAndView();
		int t_num = Integer.parseInt(req.getParameter("t_num"));
		mav.addObject("test",tDao.showFstDetail(t_num));
		view = "fstDetail";
		mav.setViewName(view);
	}

	private void showFstList() { //관리자 시험 문제 리스트 보기
		mav=new ModelAndView();
		String view = null;
		List<Test> tlist = null;
		String t_name = req.getParameter("FstList");
		System.out.println(t_name);
		tlist = tDao.getTestList(t_name);
		System.out.println(tlist);
		if(tlist!=null){
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<tlist.size(); i++){
				Test t=tlist.get(i);
				sb.append("<tr><td>"+t.getT_num()+"</td>");
				sb.append("<td><a href='showFstDetail?t_num="+t.getT_num()+"'>"+t.getT_content()+"</a></td>");
				sb.append("<td>"+t.getT_answer()+"</td>");
				sb.append("<td><a href='goUpdateFst?t_num="+t.getT_num()+"'>수정</a></td></tr>");
			}
			mav.addObject("tlist", sb.toString());
		}
		view="fstMm";
		mav.setViewName(view);
	}

	@Override
	public ModelAndView execute(Test test, int cmd) {
		// TODO Auto-generated method stub
		return null;
	}

}

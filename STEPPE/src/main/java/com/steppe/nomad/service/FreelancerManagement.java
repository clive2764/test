package com.steppe.nomad.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.steppe.nomad.bean.Career;
import com.steppe.nomad.bean.Member;
import com.steppe.nomad.bean.Portfolio;
import com.steppe.nomad.bean.Profile;
import com.steppe.nomad.bean.Skill;
import com.steppe.nomad.dao.FreelancerDao;
import com.steppe.nomad.userClass.UploadFile;

@Service
public class FreelancerManagement {
	@Autowired	
	private FreelancerDao fDao;
	@Autowired
	private HttpSession ss; //request.getSession();
	@Autowired
	private HttpServletRequest req; //request.getSession();
	@Autowired
	private SqlSessionTemplate sqlSession;

	private ModelAndView mav;
	private String jsonStr;

	public String executeAjax(Career career, int cmd) {
		switch(cmd){
		case 1 :
			insertCareer(career);
			break;
		case 2 :
			showCareer(career);
			break;
		case 3 :
			deleteCareer(career);
			break;
		}
		return jsonStr;	
	}

	public String executeAjax(Profile profile, int cmd) {
		switch(cmd){
		case 1 :
			insertProfile(profile);
			break;
		case 2 :
			showProfile(profile);
			break;
		case 3 :
			deleteProfile(profile);
			break;
		}
		return jsonStr;	
	}

	public String executeAjax(Skill skill, int cmd) {
		switch(cmd){
		case 1 :
			addSkill(skill);
			break;
		case 2 :
			showSkill(skill);
			break;
		case 3 :
			deleteSkill(skill);
		}
		return jsonStr;
	}

	public String executeAjax(Portfolio portfolio, int cmd) {
		switch(cmd){
		case 1 :
			showPortfolioList(portfolio);
			break;
		case 2 :
			showPortfolioDetail(portfolio);
			break;
		}
		return jsonStr;
	}

	public ModelAndView execute(int cmd, MultipartHttpServletRequest multi, MultipartFile[] files) {
		switch(cmd){
		case 1: insertPortfolio(multi, files);
		break;
		}
		return mav;
	}

	public ModelAndView execute(Portfolio portfolio, int cmd) {
		switch(cmd){
		case 1: 
			updatePortfolio(portfolio);
			break;
		case 2: 
			deletePortfolio(portfolio);
			break;
		}
		return mav;
	}

	private void showPortfolioList(Portfolio portfolio) {
		
	}

	private void showPortfolioDetail(Portfolio portfolio) {

	}

	private void updatePortfolio(Portfolio portfolio) {

	}

	private void deletePortfolio(Portfolio portfolio) {

	}

	private void addSkill(Skill skill) {
		String view = null;
		mav =new ModelAndView();
		if(ss!=null && ss.getAttribute("id")!=null){
			String id = (String) ss.getAttribute("id");
			skill.setSk_num(fDao.getSkillMaxNum()+1);
			skill.setM_id(id);
			skill.setSk_name(req.getParameter("sk_name"));
			System.out.println(req.getParameter("sk_name"));
			skill.setSk_grade(req.getParameter("sk_grade"));
			System.out.println(req.getParameter("sk_grade"));
			skill.setSk_career(req.getParameter("sk_career"));
			System.out.println(req.getParameter("sk_career"));
			if(fDao.insertSkill(skill)!=0){
				List<Skill> sklist = fDao.getSkillList(id);
				System.out.println(sklist);
				Gson jsonObj=new Gson();
				jsonStr = jsonObj.toJson(sklist);
				System.out.println("jsonStr : "+jsonStr);
				//jsonObj=new HashMap<String,List<Reply>>();
				//jsonObj.put("rlist", rlist); //hashMap에 저장
			}

		}else{
			System.out.println("실패");
			view="skillInfo";
		}
	}

	private void showSkill(Skill skill) {
		mav=new ModelAndView();
		String view = null;
		List<Skill> sklist = null;
		System.out.println("기술정보 들어옴");
		if(ss!=null && ss.getAttribute("id")!=null){
			String m_id = (String) ss.getAttribute("id");
			System.out.println(m_id);
			sklist = fDao.getSkillList(m_id);
			System.out.println(sklist);
			if(sklist!=null){
				Gson jsonObj=new Gson();
				jsonStr = jsonObj.toJson(sklist);
				System.out.println("jsonStr : "+jsonStr);
				mav.addObject("slist",jsonStr);
				view = "skillInfo";
			}
		}
		view="skillInfo";
		mav.setViewName(view);
	}

	private void deleteSkill(Skill skill) {
		System.out.println("기술정보 삭제 들어옴");
		String view=null;
		mav=new ModelAndView();
		if(ss!=null && ss.getAttribute("id")!=null){
			int sk_num=Integer.parseInt(req.getParameter("num"));
			if(fDao.deleteSKill(sk_num)!=0){
				System.out.println("기술정보 삭제 성공");
			}else{
				System.out.println("기술정보 삭제 실패");
			}
			view="skillInfo";
			mav.setViewName(view);
		}
	}

	private void insertProfile(Profile profile) {
		String view = null;
		mav =new ModelAndView();
		if(ss!=null && ss.getAttribute("id")!=null){
			String id = (String) ss.getAttribute("id");
			profile.setPro_num(fDao.getProfileMaxNum()+1);
			profile.setM_id(id);
			System.out.println(id);
			profile.setPro_content(req.getParameter("pro_content"));
			System.out.println(req.getParameter("pro_content"));
			if(fDao.insertProfile(profile)!=0){
				List<Profile> prlist = fDao.getProfileList(id);
				System.out.println(prlist);
				Gson jsonObj=new Gson();
				jsonStr = jsonObj.toJson(prlist);
				System.out.println("jsonStr : "+jsonStr);
				//jsonObj=new HashMap<String,List<Reply>>();
				//jsonObj.put("rlist", rlist); //hashMap에 저장
			}

		}else{
			System.out.println("실패");
			view="profile";
		}
	}

	private void showProfile(Profile profile) {
		mav=new ModelAndView();
		String view = null;
		List<Profile> prlist = null;
		System.out.println("프로필들어옴");
		if(ss!=null && ss.getAttribute("id")!=null){
			String m_id = (String) ss.getAttribute("id");
			System.out.println(m_id);
			prlist = fDao.getProfileList(m_id);
			System.out.println(prlist);
			if(prlist!=null){
				Gson jsonObj=new Gson();
				jsonStr = jsonObj.toJson(prlist);
				System.out.println("jsonStr : "+jsonStr);
				mav.addObject("prlist",jsonStr);
				view = "profile";
				/*StringBuilder sb = new StringBuilder();
				for(int i=0; i<prlist.size(); i++){
					Profile pr=prlist.get(i);
					sb.append("<tr><td>"+c.getCa_num()+"</td>");
					sb.append("<tr><td>"+pr.getM_name()+"</td>");
					sb.append("<td>"+pr.getM_image()+"</td>");
					sb.append("<td>"+pr.getPro_content()+"</td></tr>");
				}
				mav.addObject("prlist", sb.toString());*/
			}
			view="profile";
			mav.setViewName(view);
		}
	}

	private void deleteProfile(Profile profile) {
		System.out.println("프로필 삭제 들어옴");
		String view=null;
		mav=new ModelAndView();
		if(ss!=null && ss.getAttribute("id")!=null){
			int pro_num=Integer.parseInt(req.getParameter("num"));
			if(fDao.deleteProfile(pro_num)!=0){
				System.out.println("프로필 삭제 성공");
			}else{
				System.out.println("프로필 삭제 실패");
			}
			view="profile";
			mav.setViewName(view);
		}
	}

	private void insertCareer(Career career) {
		System.out.println("경력인서트들어옴");
		String view = null;
		mav =new ModelAndView();
		if(ss!=null && ss.getAttribute("id")!=null){
			String id = (String) ss.getAttribute("id");
			career.setCa_num(fDao.getCareerMaxNum()+1);
			/*career.setCa_num(String.valueOf(fDao.getCareerMaxNum()+1));*/
			career.setM_id(id.toString());
			career.setCa_term(req.getParameter("ca_term"));
			career.setCa_company(req.getParameter("ca_company"));
			career.setCa_rank(req.getParameter("ca_rank"));
			System.out.println("ca_rank="+req.getParameter("ca_rank"));
			if(fDao.insertCareer(career)!=0){
				List<Career> clist = fDao.getCareerList(id);
				Gson jsonObj=new Gson();
				jsonStr = jsonObj.toJson(clist);
				System.out.println("jsonStr : "+jsonStr);
				//jsonObj=new HashMap<String,List<Reply>>();
				//jsonObj.put("rlist", rlist); //hashMap에 저장
				mav.addObject("clist",jsonStr);
				view = "careerInfo";
			}

		}else{
			System.out.println("실패");
			view="careerInfo";
		}
	}

	private void showCareer(Career career) {
		mav=new ModelAndView();
		String view = null;
		List<Career> clist = null;
		System.out.println("경력 출력 들어옴");
		if(ss!=null && ss.getAttribute("id")!=null){
			String m_id = (String) ss.getAttribute("id");
			System.out.println(m_id);
			clist = fDao.getCareerList(m_id);
			System.out.println(clist);
			if(clist!=null){
				Gson jsonObj=new Gson();
				jsonStr = jsonObj.toJson(clist);
				System.out.println("jsonStr : "+jsonStr);
				//jsonObj=new HashMap<String,List<Reply>>();
				//jsonObj.put("rlist", rlist); //hashMap에 저장
				mav.addObject("clist",jsonStr);
				view = "careerInfo";
				/*StringBuilder sb = new StringBuilder();
				for(int i=0; i<clist.size(); i++){
					Career c=clist.get(i);
					sb.append("<tr><td>"+c.getCa_num()+"</td>");
					sb.append("<tr><td>"+c.getCa_term()+"</td>");
					sb.append("<td>"+c.getCa_company()+"</td>");
					sb.append("<td>"+c.getCa_rank()+"</td>");
					sb.append("<td><a href='deleteCareerInfo?Ca_num="+c.getCa_num()+"'>"+"삭제"+"</a></td></tr>");
				}
				mav.addObject("clist", sb.toString());*/
			}
			view="careerInfo";
			mav.setViewName(view);
		}
	}

	private void deleteCareer(Career career) {
		System.out.println("경력 삭제 들어옴");
		String view=null;
		mav=new ModelAndView();
		if(ss!=null && ss.getAttribute("id")!=null){
			int ca_num=Integer.parseInt(req.getParameter("num"));
			if(fDao.deleteCareer(ca_num)!=0){
				System.out.println("경력 삭제 성공");
			}else{
				System.out.println("경력 삭제 실패");
			}
			view="careerInfo";
			mav.setViewName(view);
		}
	}

	private void insertPortfolio(MultipartHttpServletRequest multi, MultipartFile[] files) {
		mav = new ModelAndView();
		//MultipartFile[] files = request.getParameter("pf_image[]");
		if(ss!=null && ss.getAttribute("id")!=null){
		String m_id = (String) ss.getAttribute("id");
		String pf_title = multi.getParameter("pf_title");
		String pf_term = multi.getParameter("pf_term");
		String pf_contribute = multi.getParameter("pf_contribute");
		String pf_content = multi.getParameter("pf_content");
		//int check = Integer.parseInt(multi.getParameter(""))
		//Map<String, Object> pfMap = null;
		UploadFile upload = new UploadFile();
		//pfMap = upload.fileUp(multi);
		//List<Map<String, Object>> mapList = upload.fileUp(multi, files);
		List<String> mapList = upload.fileUp(multi, files);
		Portfolio portfolio = new Portfolio();
		portfolio.setM_id(m_id);
		if(fDao.getPortfolioCount()!=0){
			portfolio.setPf_num(fDao.getPortfolioCount()+1);
		}else{
			portfolio.setPf_num(1);
		}
		portfolio.setPf_title(pf_title);
		portfolio.setPf_term(pf_term);
		portfolio.setPf_contribute(pf_contribute);
		portfolio.setPf_content(pf_content);
		//insert 값 부족
		System.out.println("portfolio num:"+ portfolio.getPf_num());
		fDao.insertPortfolio(portfolio);
		//pfDao.portFolioInsert(portfolio);
		int pfNum = fDao.getPortfolioMaxNum();
		fDao.portfolioFileInsert(mapList,pfNum);
		mav.setViewName("portfolio");
		}
	}
}



package com.steppe.nomad.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.steppe.nomad.bean.Volunteer;

@Repository
public class AccountingDao {

	@Autowired
	private SqlSessionTemplate sqlSession;


	public int Countpunum(int v_pnum) {
		return sqlSession.selectOne("accounting.Countpunum",v_pnum);
	}


	public int getPrice(int v_pnum) {
		return sqlSession.selectOne("accounting.getPrice",v_pnum);
	}
}
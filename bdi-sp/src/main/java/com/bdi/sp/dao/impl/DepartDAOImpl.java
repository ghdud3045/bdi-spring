package com.bdi.sp.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bdi.sp.dao.DepartDAO;
import com.bdi.sp.vo.Depart;

@Repository
public class DepartDAOImpl implements DepartDAO {

	@Autowired
	private SqlSession ss;
	
	@Override
	public List<Depart> getDepartList(Depart di) {
		return ss.selectList("com.bdi.sp.Depart.selectDepartList",di);
	}

	@Override
	public Depart getDepart(int dinum) {
		return ss.selectOne("com.bdi.sp.Depart.selectDepart",dinum);
	}

	@Override
	public int insertDepart(Depart di) {
		return ss.insert("com.bdi.sp.Depart.insertDepart",di);
	}

	@Override
	public int updateDepart(Depart di) {
		return ss.update("com.bdi.sp.Depart.updateDepart",di);
	}

	@Override
	public int deleteDepart(int di) {
		return ss.delete("com.bdi.sp.Depart.deleteDepart",di);
	}

}

package com.bdi.sp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdi.sp.dao.DepartDAO;
import com.bdi.sp.service.DepartService;
import com.bdi.sp.vo.Depart;

@Service
public class DepartServiceImpl implements DepartService{

	@Autowired
	private DepartDAO ddao;
	@Override
	public List<Depart> getDepartList(Depart di) {
		return ddao.getDepartList(di);
	}

	@Override
	public Depart getDepart(int dinum) {
			return ddao.getDepart(dinum);
	}

	@Override
	public int insertDepart(Depart di) {
		return ddao.insertDepart(di);
	}

	@Override
	public int deleteDepart(int di) {
		return ddao.deleteDepart(di);
	}

	@Override
	public int updateDepart(Depart di) {
		return ddao.updateDepart(di);
	}

}

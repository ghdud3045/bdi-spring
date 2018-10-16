package com.bdi.sp.dao;

import java.util.List;

import com.bdi.sp.vo.Depart;

public interface DepartDAO {

	public List<Depart> getDepartList(Depart di);
	
	public Depart getDepart(int dinum);
	
	public int insertDepart(Depart di);
	
	public int updateDepart(Depart di);
	
	public int deleteDepart(int di);
}

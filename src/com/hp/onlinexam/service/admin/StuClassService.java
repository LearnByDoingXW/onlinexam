package com.hp.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.admin.IStuClassDao;
import com.hp.onlinexam.dao.admin.StuClassDao;
import com.hp.onlinexam.po.Stuclass;

public class StuClassService implements IStuClassService {
	
	private IStuClassDao scd=new StuClassDao();

	@Override
	public List findAll() {
		
		return scd.findAllStuClassInfo();
	}

	@Override
	public void addStuClass(Stuclass sc) {
		
	    scd.addStuClass(sc);
	}

	@Override
	public void updateStuClass(Stuclass sc) {
		scd.updateStuClassById(sc);
		
	}
	

	@Override
	public void deleteStuClass(int classId) {
		scd.deleteStuClassById(classId);
		
	}

	@Override
	public Map<String, Object> findStuClassById(int id) {
		
		return scd.findStuClassById(id);
	}

	@Override
	public String findClassNamesByIds(String ids) {
		
		return  scd.findClassNamesByIds(ids);
	}

	@Override
	public List<Stuclass> findStuClassesByTeacherId(int teaId) {
		
		return scd.findStuClassesByTeacherId(teaId);
	}

}

package com.hp.onlinexam.dao.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Stuclass;

public interface IStuClassDao {

	public List findAllStuClassInfo();

	public Map<String, Object> findStuClassById(int classId) ;

	public void addStuClass(Stuclass sc) ;

	public void updateStuClassById(Stuclass sc) ;
	
	public void deleteStuClassById(int classId);
	
	public String findClassNamesByIds(String ids);

	/**
	 * 根据当前的教师id查询属于这个教师的班级
	 * @param teaId
	 * @return
	 */
	public List<Stuclass> findStuClassesByTeacherId(int teaId);

}

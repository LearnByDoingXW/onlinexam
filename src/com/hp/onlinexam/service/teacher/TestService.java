package com.hp.onlinexam.service.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.teacher.ITestDao;
import com.hp.onlinexam.dao.teacher.TestDao;
import com.hp.onlinexam.po.Test;

public class TestService implements ITestService {
    
	private ITestDao td=new TestDao();
	@Override
	public void createTest(Test t) {
		td.createTest(t);
		
	}
    
	
	@Override
	public void deleteTest( int id) {
		
		td.deleteTest(id);
	}


	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		
		return td.findTestsByTeaId(teaId);
	}

	@Override
	public Map<String, Object> findTestById(int id, int teaId) {
		
		return td.findTestById(id, teaId);
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		// TODO Auto-generated method stub
		return td.findStudentTestsById(studentid, testid);
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id, String currData) {
		// TODO Auto-generated method stub
		return td.getTestByStudent(id, currData);
	}


	@Override
	public Map<String, Object> findTestBytId(int id) {
		// TODO Auto-generated method stub
		return td.findTestBytId(id);
	}

}

package com.hp.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.util.DBUtil;
import com.hp.onlinexam.util.ToolUtil;

public class TestDao implements ITestDao {

	private DBUtil db = new DBUtil();

	@Override
	public void createTest(Test t) {
		String sql = "insert into test(testName,courseId,endDate,testTime,questions,teacherId,classIds,scores) values(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] { t.getTestName(), t.getCourseId(), t.getEndDate(), t.getTestTime(),
					t.getQuestions(), t.getTeacherId(), t.getClassIds(), t.getScores() });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTest(int id) {
		String sql = "delete from test where id=?";
		try {
			db.execute(sql, new Object[] { id });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		/*
		 * GROUP_CONCAT(stu.className)可以把查询出来的stu.className多条记录字段的值转换成一个字段
		 * FIND_IN_SET(stu.id,te.classIds) 第一个是一个字段值 第二个是一个集合
		 * 只要第一个字段在第二个集合中就能查出来 要查的是试卷的信息，根据试卷的id进行分组 GROUP BY te.id
		 * 
		 * ToolUtil.getCurrentTime()获取系统当前时间
		 */
		String currentTime = ToolUtil.getCurrentTime();
		String sql = "SELECT te.*,c.cName,GROUP_CONCAT(stu.className) AS classNames FROM test te,course c,stuclass stu WHERE te.courseId=c.cId and FIND_IN_SET(stu.id,te.classIds)  and teacherId=? and te.endDate>? GROUP BY te.id";
		List<Map<String, Object>> testList = new ArrayList();
		try {
			testList = db.getQueryList(sql, new Object[] { teaId, currentTime });
		} catch (Exception e) {
			testList = new ArrayList();
			e.printStackTrace();
		}
		return testList;
	}

	@Override
	public Map<String, Object> findTestById(int id, int teaId) {
		String sql = "SELECT te.*,c.cName,GROUP_CONCAT(stu.className) AS classNames FROM test te,course c,stuclass stu WHERE te.courseId=c.cId and FIND_IN_SET(stu.id,te.classIds)  and te.id=? GROUP BY te.id";
		Map<String, Object> testMap = new HashMap();
		try {
			testMap = db.getObject(sql, new Object[] { id });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testMap;
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
        String sql="SELECT t.id,t.testName,c.cName, t.endDate,t.questions,t.testTime,t.scores, sc.className ,c.cId from test t,student s , course c, stuclass as sc where t.id = ? and FIND_IN_SET(s.classId,t.classIds) and s.stuId=? and t.courseId = c.cId and s.classId = sc.id ";
		Map sTestMap=new HashMap();
		try {
			sTestMap=db.getObject(sql, new Object[]{testid,studentid});
		} catch (Exception e) {
			sTestMap=new HashMap();
			e.printStackTrace();
		}
        return sTestMap;
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id, String currData) {
		String sql = "SELECT t.*,c.cName FROM student s,test t ,course c  where FIND_IN_SET(s.classId,t.classIds) and c.cId=t.courseId and s.stuId =? and t.endDate > ? and t.id not in(select testId from papers)";
		List stuList = new ArrayList();
		try {
			stuList = db.getQueryList(sql, new Object[] {id,currData});
		} catch (Exception e) {
			stuList = new ArrayList();
			e.printStackTrace();
		}
		return stuList;
	}

	@Override
	public Map<String, Object> findTestBytId(int id) {
		String sql="select t.* ,p.wrongAns ,c.cName,s.className from papers p ,test t ,course c ,stuclass s where t.id =p.testId and c.cId=t.courseId and FIND_IN_SET(s.id,t.classIds) and t.id=?";
		Map sTestMap1=new HashMap();
		try {
			sTestMap1=db.getObject(sql, new Object[]{id});
		} catch (Exception e) {
			sTestMap1=new HashMap();
			e.printStackTrace();
		}
        return sTestMap1;
	}

}

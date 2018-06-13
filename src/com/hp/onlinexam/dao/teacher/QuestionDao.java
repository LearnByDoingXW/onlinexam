package com.hp.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Questions;
import com.hp.onlinexam.util.DBUtil;

public class QuestionDao implements IQuestionDao {

	private DBUtil db = new DBUtil();

	@Override
	public List<Map<String, Object>> findAllQuestionInfo(String key, String value) {
		String sql = "SELECT q.id,q.courseId,q.queTitle,q.queType,q.choiceA,q.choiceB,q.choiceC,q.choiceD,c.cName,q.ans FROM questions q,course c WHERE q.courseId=c.cId";
		if(null!=key && !"".equals(key)){
			sql+=" and "+ key+ " like '%"+ value +"%'";
			
//			if("cName".equals(key)){
//				sql+=" and c.cName like '%" + value + "'";
//			}
//			else if("queTitle".equals(key)){
//				sql+=" and q.queTitle like '%" + value + "'";
//			}
		}
		List<Map<String, Object>> queList = new ArrayList<Map<String, Object>>();
		try {
			queList = db.getQueryList(sql, new Object[] {});
		} catch (Exception e) {
			queList = new ArrayList<Map<String, Object>>();
			e.printStackTrace();
		}
		return queList;
	}

	@Override
	public void addQuestion(Questions q) {
	   String sql="insert into questions(courseId,queType,queTitle,choiceA,choiceB,choiceC,choiceD,ans,queExist) values(?,?,?,?,?,?,?,?,?)";
       try {
		db.execute(sql, new Object[]{q.getCourseId(),q.getQueType(),q.getQueTitle(),q.getChoiceA(),q.getChoiceB(),q.getChoiceC(),q.getChoiceD(),q.getAns(),1});
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		String sql="Select * from questions where id=?";
		Map qsMap=new HashMap();
		try {
			qsMap=db.getObject(sql, new Object[]{id});
		} catch (Exception e) {
			qsMap=new HashMap();
			e.printStackTrace();
		}
		return qsMap;
	}

	@Override
	public List<Questions> findQuestionByIds(String ids) {
		String sql="select * from questions where FIND_IN_SET(id,?)";
		List qList =new ArrayList();
		try {
			qList=db.getQueryList(Questions.class, sql, new Object[]{ids});
		} catch (Exception e) {
			qList =new ArrayList();
			e.printStackTrace();
		}
		return qList;
	}

	@Override
	public void updateQuestionInfo(Questions q) {
		String sql="update questions set courseId=?,queType=?,queTitle=?,choiceA=?,choiceB=?,choiceC=?,choiceD=?,ans=?,queExist=1 where id=?";
		try {
			db.execute(sql, new Object[]{q.getCourseId(),q.getQueType(),q.getQueTitle(),q.getChoiceA(),q.getChoiceB(),q.getChoiceC(),q.getChoiceD(),q.getAns(),q.getId()});
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId) {
		String sql="SELECT * FROM questions where courseId=?";
		List<Map<String, Object>> qList=new ArrayList();
		try {
			qList=db.getQueryList(sql, new Object[]{courseId});
		} catch (Exception e) {
			qList=new ArrayList();
			e.printStackTrace();
		}
		return qList;
	}

	@Override
	public void deleteQuestion(int id) {
		String sql="delete from questions where id=?";
		try {
			db.execute(sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}

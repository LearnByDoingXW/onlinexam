package com.hp.onlinexam.service.teacher;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.teacher.IQuestionDao;
import com.hp.onlinexam.dao.teacher.QuestionDao;
import com.hp.onlinexam.po.Questions;

public class QuestionService implements IQuestionService {

	IQuestionDao qd = new QuestionDao();

	@Override
	public List<Map<String, Object>> findAll(String key, String value) {
		// TODO Auto-generated method stub
		return qd.findAllQuestionInfo(key, value);
	}

	@Override
	public void addQuestion(Questions q) {
		qd.addQuestion(q);

	}

	@Override
	public Map<String, Object> findQuestionById(int id) {

		return qd.findQuestionById(id);
	}

	@Override
	public void updateQuestionInfo(Questions q) {
		qd.updateQuestionInfo(q);

	}

	@Override
	public void deleteQuestion(int id) {
		qd.deleteQuestion(id);

	}

	@Override
	public List<Map<String, Object>> collectQuestions(int courseId, int num) {
		List<Map<String, Object>> queList = qd.findQuestionsByCourseId(courseId);
		/*
		 * 通过shuffle方法随机
		 * 根据数量截取queList里面值用subList
		 */
		Collections.shuffle(queList);
		if (num >= queList.size()) {
			return queList;
		} else {
			return queList.subList(0, num);
		}
	}

	
	@Override
	public String testQuestionIds(List<Map<String, Object>> list) {
		if(null==list){
			return "";
		}
		/*
		 * 字符串的拼接尽量用StringBuffer
		 * String是不可变的，例如String s="a"+"b";s+="c"
		 */
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<list.size();i++){
			Map<String,Object> questionMap=list.get(i);
			sb.append(questionMap.get("id")+",");
		}
		String ids=sb.toString();
		if(list.size()>0){
			ids=ids.substring(0, ids.length()-1);
		}
		return ids;
	}

	
	@Override
	public List<Questions> findQuestionByIds(String ids) {
		
		return qd.findQuestionByIds(ids) ;
	}

}

package com.hp.onlinexam.dao.student;

import java.util.ArrayList;
import java.util.List;

import com.hp.onlinexam.po.Papers;
import com.hp.onlinexam.util.DBUtil;
import com.hp.onlinexam.util.ToolUtil;

public class PapersDao implements IPapersDao {
    
	private DBUtil db=new DBUtil();
	
	@Override
	public int save(Papers p) {
		String sql="insert into papers(testId,courseId,time,score,wrongQueId,wrongAns,studentId,createDate) values(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[]{p.getTestId(),p.getCourseId(),p.getTime(),p.getScore(),p.getWrongQueId(),p.getWrongAns(),p.getStudentId(),p.getCreatDate()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List getPaperByStudentId(int studentId, int testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPaperByStudentId(int studentId,String cName) {
		String sql1="select c.cName,t.testName,p.createDate,p.score,p.testId,p.time from course c,papers p,test t,student s where c.cId=p.courseId and t.id=p.testId and s.stuId=p.studentId AND s.stuId=?";
		String sql2="select t.testName,t.id testId,c.cName from test t,course c,student s where c.cId=t.courseId and FIND_IN_SET(s.classId,t.classIds) and t.id NOT in (SELECT testId  from papers) and t.endDate < ? and s.stuId=?";
		String currDate=ToolUtil.getCurrentTime();
		if(!"".equals(cName)){
			sql1+= " and  c.cName like '%"+ cName +"%'";
			sql2+= " and  c.cName like '%"+ cName +"%'";
		}
		List list1=new ArrayList();
		List list2=new ArrayList();
		List pList=new ArrayList();
		try {
			list1=db.getQueryList(sql1, new Object[]{studentId});
			list2=db.getQueryList(sql2, new Object[]{currDate,studentId});
			pList=list1;
			pList.addAll(list2);
		} catch (Exception e) {
			list1=new ArrayList();
			list2=new ArrayList();
			e.printStackTrace();
		}
		return pList;
	}

	@Override
	public List getPaperCompare(int teaId) {
		String sql = "select stuclass.deptName,test.testName,course.cName courseName,stuclass.className,test.endDate,ROUND(AVG(papers.score),2) as avgScore from course,stuclass,papers,teacher,teachercourse,test where teachercourse.classId=stuclass.id and papers.testId=test.id and teachercourse.tId=teacher.tId and teacher.tId =? && teachercourse.tId=teacher.tId  && teachercourse.courseId=papers.courseId && course.cId =papers.courseId GROUP BY papers.courseId";
		List paperList = new ArrayList();
		try {
				paperList = db.getQueryList(sql,new Object[]{teaId});
			} catch (Exception e) {
							// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return paperList;
	}

}

package com.hp.onlinexam.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hp.onlinexam.po.Questions;
import com.hp.onlinexam.po.Test;

public class DBUtilQueryTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		String sql = "select * from test";
		List<Map<String, Object>> testList = db.getQueryList(sql);
		for (int i = 0; i < testList.size(); i++) {
			Map<String, Object> testMap = testList.get(i);

			Iterator<Entry<String, Object>> it = testMap.entrySet().iterator();

			while (it.hasNext()) {
				Entry<String, Object> entry = it.next();
				System.out.print(entry.getKey() + "@@@" + entry.getValue() + "\t");
			}
			System.out.println(" ");
		}
		System.out.println("-----------------分割线---------------------");
		/*
		 * 
		 */
		String sql2 = "select * from test where courseId=? and teacherId=?";
		List<Map<String, Object>> testList2 = db.getQueryList(sql2, new Object[] { 1, 2 });
		for (int i = 0; i < testList2.size(); i++) {
			Map<String, Object> testMap2 = testList2.get(i);

			Iterator<Entry<String, Object>> it = testMap2.entrySet().iterator();

			while (it.hasNext()) {
				Entry<String, Object> entry = it.next();
				System.out.print(entry.getKey() + "@@@" + entry.getValue() + "\t");
			}
			System.out.println();
		}
		System.out.println("-----------------分割线---------------------");

		/*
		 * 数组是一类相同数据类型的集合 声明：仅仅是定义数据类型和变量名 定义：除了声明外，有赋值 数组声明时，[]可以放变量前也可以放变量后
		 */

		String[] strArray;
		String strArray2[];
		String[] strArray3 = new String[] { "pgthree", "lixiaolu" };
		String[] strArray4 = { "134", "659" };
		String[] strArray5 = new String[3];

		List testList3 = db.getQueryList(Test.class, sql2, new Object[] { 1, 2 });
		for (Object o : testList3) {
			Test t = (Test) o;
			System.out.println(t);
		}
		System.out.println("-----------------分割线---------------------");

		/**
		 * 练习： 1.查询姓“张”的学生的学生成绩，查询结果过包括学生姓名。 2.查询李四老师的排课表 3.查询所有试题信息
		 */

		/*
		 * 1.查询姓“张”的学生的学生成绩，查询结果过包括学生姓名。
		 */
		String sql3 = "SELECT student.stuName,papers.score from student,papers WHERE student.stuId=papers.studentId and student.stuName LIKE '张%'";
		List<Map<String, Object>> testList4 = db.getQueryList(sql3);
		for (int i = 0; i < testList4.size(); i++) {
			Map<String, Object> testMap3 = testList4.get(i);

			Iterator<Entry<String, Object>> it = testMap3.entrySet().iterator();

			while (it.hasNext()) {
				Entry<String, Object> entry = it.next();
				System.out.print(entry.getKey() + "@@@" + entry.getValue() + "\t");
			}
			System.out.println(" ");
		}
		System.out.println("-----------------分割线---------------------");

		/*
		 * 2.查询李四老师的排课表
		 */
		String sql4 = "SELECT teacher.tName as teaname ,course.cName as cname from teacher,teachercourse,course where teacher.tName='李四' and teacher.tId=teachercourse.tId and course.cId=teachercourse.courseId ";
		List<Map<String, Object>> testList5 = db.getQueryList(sql4);
		for (int i = 0; i < testList5.size(); i++) {
			Map<String, Object> testMap4 = testList5.get(i);

			Iterator<Entry<String, Object>> it = testMap4.entrySet().iterator();

			while (it.hasNext()) {
				Entry<String, Object> entry = it.next();
				System.out.print(entry.getKey() + "@@@" + entry.getValue() + "\t");
			}
			System.out.println(" ");
		}
		System.out.println("-----------------分割线---------------------");

		/*
		 * 3.查询所有试题信息
		 */
		String sql5 = "select * from questions";
		List testList6 = db.getQueryList(Questions.class, sql5, new Object[] {});
		for (Object o : testList6) {
			Questions q = (Questions) o;
			System.out.println(q.getId() + "\t" + q.getCourseId() + "\t" + q.getQueType() + "\t" + q.getQueTitle()
					+ "\t" + q.getChoiceA() + "\t" + q.getChoiceB() + "\t" + q.getChoiceC() + "\t" + q.getChoiceD()
					+ "\t" + q.getAns() + "\t" + q.getQueExist());
		}
		System.out.println("-----------------分割线---------------------");

	}
}

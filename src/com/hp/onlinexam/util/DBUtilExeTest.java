package com.hp.onlinexam.util;

public class DBUtilExeTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * insert语句 insert into + 表名 如果是插入所有的列，则在values（值1，值2，值3）
		 * 如果输入部分字段，在表名后，（字段1，字段2，字段3）
		 */
		DBUtil db = new DBUtil();
		/*
		 * 向表course添加cId为4，cName为c#的记录
		 */
		String sql = "insert into course values(4,'c#')";
		db.execute(sql);

		/*
		 * 向表course添加cName为Phyon的记录
		 */
		String sql2 = "insert into course(cName) values(?)";
		db.execute(sql2, new Object[] { "Phyon" });

		/*
		 * 练习： 1.删除表中cName为Phyon的记录
		 * 
		 * delete from 表名 where。。。。
		 */
		String sql3 = "DELETE from course WHERE cName='Phyon'";
		db.execute(sql3);

		String sql4 = "DELETE from course WHERE cName=?";
		db.execute(sql4, new Object[] { "Phyon" });

	}

}

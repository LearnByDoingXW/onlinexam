package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hp.onlinexam.po.Questions;
import com.hp.onlinexam.po.Stuclass;
import com.hp.onlinexam.util.DBUtil;

public class StuClassDao implements IStuClassDao {

	private DBUtil db = new DBUtil();

	@Override
	public List findAllStuClassInfo() {
		String sql = "select * from stuclass";
        List stuClassList=new ArrayList();
		try {
			stuClassList=db.getQueryList(Stuclass.class, sql, new Object[] {});
		} catch (Exception e) {
			stuClassList=new ArrayList();
			e.printStackTrace();
		}

		return stuClassList;
	}

	@Override
	public Map<String, Object> findStuClassById(int classId) {
		String sql="select * from stuclass where id=?";
		Map<String,Object> stuMap=new HashMap<String,Object>();
		try {
			stuMap=db.getObject(sql, new Object[]{classId});
		} catch (Exception e) {
			stuMap=new HashMap<String,Object>();
			e.printStackTrace();
		}
		return stuMap;
	}

	@Override
	public void addStuClass(Stuclass sc) {
		
		String sql="insert into stuclass(className,deptName) values(?,?)";
		try {
			db.execute(sql, new Object[]{sc.getClassName(),sc.getDeptName()});
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void updateStuClassById(Stuclass sc) {
		String sql="update stuclass set className=?,deptName=? WHERE id=?";
		try {
			db.execute(sql, new Object[]{sc.getClassName(),sc.getDeptName(),sc.getId()});
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
	

	@Override
	public void deleteStuClassById(int classId) {
		String sql="delete from stuclass where id=?";
		try {
			db.execute(sql, new Object[]{classId});
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public String findClassNamesByIds(String ids) {
		String sql="select className from stuclass where id in ("+ ids+ ")";
		List<Map<String,Object>> nameList=new ArrayList();
		
		try {
			nameList=db.getQueryList(sql);
		} catch (Exception e) {
			
			nameList=new ArrayList();
			e.printStackTrace();
		}
		
		StringBuffer sb= new StringBuffer();
		for(int i=0;i<nameList.size();i++){
			sb.append(nameList.get(i).get("className")+" ");
		}
		return sb.toString();
	}

	@Override
	public List<Stuclass> findStuClassesByTeacherId(int teaId) {
		String sql="SELECT * from stuclass where id in (select classId from teachercourse where tId = ?)";
		List stuList=new ArrayList();
		try {
			stuList=db.getQueryList(Stuclass.class, sql, new Object[]{teaId});
		} catch (Exception e) {
			stuList=new ArrayList();
			e.printStackTrace();
		}
		return stuList;
	}
	
	
	public static void main(String []args){
		/*声明的时候一般会向上转型
		 * 有父类与子类之间的关系
		 * 有接口和实现类之间的关系
		 *  优点之一：如果IStuClassDao有多个实现，再次声明只需要该实现类的名即只需要该new StuClassDao()
		 */
		IStuClassDao scd= new StuClassDao();
		List sclist = scd.findAllStuClassInfo();
		for (Object o : sclist) {
			Stuclass q = (Stuclass) o;
			System.out.println(q.getId() + "\t" + q.getClassName() + "\t" + q.getDeptName() );
		   
		}
		String scList=scd.findClassNamesByIds("1,2,3");
		System.out.println(scList);
	}

}

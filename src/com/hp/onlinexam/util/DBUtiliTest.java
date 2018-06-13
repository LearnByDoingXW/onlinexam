package com.hp.onlinexam.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.Test;

public class DBUtiliTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
     String sql="select * from course where cName='Java'";
     DBUtil db=new DBUtil();
     /*
      * 如果一个方法是静态方法，可以使用类名、方法调用
      * 如果一个方法是普通方法，则需要使用构造方法创建对象调用
      * 
      * 
      * 数组：一旦创建了数组，大小不变
      * 集合框架：List Set Map
      * Map 的优势在于使用键值对，键是唯一的 可以通过键直接获取值
      * 
      * 如果要调用的方法体上有抛异常 throws **Exception
      * 在调用方法是有两种解决方式：
      * 1.try-catch 包裹起来 异常处理
      * 2.继续在调用本方法体上继续抛异常
      * 
      * java  通过包名来区分类名相同的情况-java.util
      * 
      * <>表示泛型  使用泛型的好处在于：对键值做类型描述
      * 
      *  Map<String,Object>  getObject(sql)
      *  使用场景：
      *  1.SQL已经提前知道
      *  2.参数较少，写到SQL语句里
      *  3.可以用来获取对象，获取对象的形式是键值对
      *  4.尤其是用于多表无法封装成一个对象的场景
      *  5. 适用于查询一条记录    
      */
     
     /*方法一：
      * try {
		db.getObject(sql);
	} catch (Exception e) {
		
		e.printStackTrace();
	}*/
     Map<String,Object> courseMap=db.getObject(sql);
     /*
      * debug模式和run模式
      * 开发的时候用debug 可以看到中间的过程 能狗在自己关注的代码暂停
      * 能够一行行执行代码
      * 在自己关注的代码左侧双击 可以打断点
      * 如果debug模式没有任何断电 和run模式一致
      * 
      */
     System.out.println(courseMap);
     /*
      * map  遍历使用iterator
      * map的存储方式使用键值对 entry可以理解为键值对
      */
     
     Iterator<Entry<String,Object>> it =courseMap.entrySet().iterator();
     while(it.hasNext()){
    	 Entry<String,Object> entry =it.next();
    	 System.out.println(entry.getKey()+"@@@"+entry.getValue());
     }
     
     /*
      * 同一方法  变量不能定义两次
      */
     String sql2="select *from course where cName=?";
     Map<String,Object> courseMap2=db.getObject(sql2, new Object[]{"java"});
     System.out.println(courseMap2);
     
     /*
      * Object getObject(Class<?> type,String sql,Boject[]{} pramList)
      * 第一个参数是要封装成的类类型
      * type是我们提供的po层或vo层  String 不行
      * 返回结果说是封装好的类  并且强制转换
      */
     Course c=(Course)db.getObject(Course.class, sql2, new Object[]{"java"});
     System.out.println("第三个输出为："+c.getcName());
     
     /*
 	 * 练习：test表 查询课程ID是1，教师ID是2的试卷 并 将结果封装成  Test  类
 	 */
     String sql3="select * from test where courseId=1 and teacherId=2";
     Test t=(Test)db.getObject(Test.class,sql3,new Object[]{});
 
    	  System.out.println("Test类的结果："+t.getId());
     
    
     
	} 
} 

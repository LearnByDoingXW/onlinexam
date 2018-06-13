package com.hp.onlinexam.service.login;

import com.hp.onlinexam.dao.login.ILoginDao;
import com.hp.onlinexam.dao.login.LoginDao;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Teacher;

public class LoginService implements ILoginService {
    
	private ILoginDao lod=new LoginDao();
	@Override
	public Teacher canLogin(Teacher t) {
		
		return lod.canLogin(t);
	}

	@Override
	public Student canLogin(Student s) {
		
		return lod.canLogin(s);
	}

}

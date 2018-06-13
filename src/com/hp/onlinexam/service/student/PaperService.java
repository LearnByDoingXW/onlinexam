package com.hp.onlinexam.service.student;

import java.util.ArrayList;
import java.util.List;

import com.hp.onlinexam.dao.student.IPapersDao;
import com.hp.onlinexam.dao.student.PapersDao;
import com.hp.onlinexam.po.Papers;

public class PaperService implements IPaperService {
    
	private IPapersDao pd=new PapersDao();
	@Override
	public int save(Papers paper) {
		// TODO Auto-generated method stub
		return pd.save(paper);
	}

	@Override
	public List getPaperByStudentId(int studentId, int testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPaperByStudentId(int studentId,String cName) {
		// TODO Auto-generated method stub
		return pd.getPaperByStudentId(studentId,cName);
	}

	@Override
	public List getPaperCompare(int teaId) {
		return pd.getPaperCompare(teaId);

	}

}

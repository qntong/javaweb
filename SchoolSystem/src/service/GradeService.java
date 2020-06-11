package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GradeDao;
import entity.Grade;

public class GradeService {

	private GradeDao gradeDao = new GradeDao();

	/**
	 * 根据学号查询学生成绩
	 * 
	 * @param s_number
	 * @return
	 * @throws SQLException
	 */
	public List<Grade> getGradeByStuNo(String s_number) {

		List<Grade> grade = new ArrayList<Grade>();
		try {
			grade = gradeDao.getGreadByStuNo(s_number);
			System.out.println("GradeService");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return grade;
	}

}

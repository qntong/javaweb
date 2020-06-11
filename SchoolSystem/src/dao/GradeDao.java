package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Grade;
import utils.DBUtils;

public class GradeDao {

	/**
	 * 根据学号查询成绩
	 * 
	 * @param s_number
	 * @return List<Grade>
	 * @throws SQLException
	 */
	public List<Grade> getGreadByStuNo(String s_number) throws SQLException {
		Connection connection = DBUtils.getConnection();
		String sql = "SELECT * FROM grade WHERE s_number = " + s_number;
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<Grade> gradeList = new ArrayList<Grade>();
		while (resultSet.next()) {
			Grade grade = new Grade();
			grade.setS_class(resultSet.getString("s_class"));
			grade.setS_number(resultSet.getString("s_number"));
			grade.setS_name(resultSet.getString("s_name"));
			grade.setCourse_name(resultSet.getString("course_name"));
			grade.setScore(resultSet.getInt("score"));
			grade.setTeacher(resultSet.getString("teacher"));
			gradeList.add(grade);
			System.out.println("成绩查询完毕");
		}
		DBUtils.close(resultSet, statement, connection);
		return gradeList;
	}

}

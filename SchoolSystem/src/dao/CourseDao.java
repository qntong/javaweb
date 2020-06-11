package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Course;
import utils.DBUtils;

public class CourseDao {

	/**
	 * 查询学生所选课程
	 * 
	 * @param s_number
	 * @return
	 * @throws SQLException
	 */
	public List<Course> getCourseByStuNo(String s_number) throws SQLException {
		Connection connection = DBUtils.getConnection();
		String sql = "SELECT * FROM choose_course WHERE s_number = " + s_number;
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<Course> courseList = new ArrayList<Course>();
		while (resultSet.next()) {
			Course course = new Course();
			course.setCourse_id(resultSet.getInt("course_id"));
			course.setCourse_name(resultSet.getString("course_name"));
			course.setCourse_type(resultSet.getString("course_type"));
			course.setTeacher(resultSet.getString("teacher"));
			courseList.add(course);
			System.out.println("课表查询完毕");
		}
		DBUtils.close(resultSet, statement, connection);
		return courseList;
	}

}

package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CourseDao;
import entity.Course;

/**
 * 课程服务
 * 
 * @author qin
 *
 */
public class CourseService {

	private CourseDao courseDao = new CourseDao();

	/**
	 * 根据学号查询所选课程
	 * 
	 * @param s_number
	 * @return
	 */
	public List<Course> getCourseByStuNo(String s_number) {
		List<Course> courses = new ArrayList<Course>();

		try {
			courses = courseDao.getCourseByStuNo(s_number);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return courses;
	}

}

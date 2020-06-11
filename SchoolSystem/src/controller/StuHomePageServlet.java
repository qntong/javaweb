package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Course;
import entity.Grade;
import entity.UserStu;
import service.CourseService;
import service.GradeService;

/**
 * 学生端主页
 */
@WebServlet("/StuHomePageServlet")
public class StuHomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GradeService gradeService = new GradeService();
	private CourseService courseService = new CourseService();

	public StuHomePageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取数据
		UserStu user = (UserStu) request.getSession().getAttribute("userStu");
		List<Grade> gradeList = gradeService.getGradeByStuNo(user.getS_number());
		List<Course> chooseCoursesList = courseService.getCourseByStuNo(user.getS_number());

		// 返回学生主页
		request.setAttribute("grade", gradeList);
		request.setAttribute("chooseCourse", chooseCoursesList);
		request.getRequestDispatcher("page/stuHomePage.jsp").forward(request, response);

	}

}

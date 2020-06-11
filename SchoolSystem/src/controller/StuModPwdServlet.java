package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.UserStu;
import service.UserService;

/**
 * 学生修改密码
 */
@WebServlet("/StuModPwdServlet")
public class StuModPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();

	public StuModPwdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取参数
		String username = request.getParameter("userName");
		String pwd = request.getParameter("password1");
		// 获取前端发出请求的界面
		String url = request.getHeader("Referer");
		// 截取jsp界面名
		String urlString = url.substring(40, url.length());
		System.out.println(urlString);
		UserStu user = (UserStu) request.getSession().getAttribute("userStu");
		// 修改数据
		int row = 0;
		if ("stuFindPwd.jsp".equals(urlString)) {
			System.out.println("stuFindPwd.jsp请求的");
			row = userService.updateStuPwd(username, pwd);
			if (row > 0) {
				// 跳转登录界面
				response.sendRedirect("page/index.jsp");
				System.out.println("学生密码修改成功");
			} else {
				// 跳转注册界面并提示错误信息
				request.setAttribute("errorMsg", "密码修改失败，请稍后再试!");
				request.getRequestDispatcher("page/stuFindPwd.jsp").forward(request, response);
			}
		} else {
			// TODO 教师修改密码
//			System.out.println("teaModPwd.jsp请求的");
//			System.out.println("session中取到账号为：" + user.getS_number());
//			row = userService.updateStuPwd(user.getS_number(), pwd);
//			if (row > 0) {
//				// 跳转登录界面
//				response.sendRedirect("page/stuHomePage.jsp");
//				System.out.println("教师密码修改成功");
//			} else {
//				// 跳转注册界面并提示错误信息
//				request.setAttribute("errorMsg", "密码修改失败，请稍后再试!");
//				request.getRequestDispatcher("page/stuModPwd.jsp").forward(request, response);
//			}
		}

	}

}

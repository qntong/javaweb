package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

/**
 * 教师修改密码
 */
@WebServlet("/TeaModPwdServlet")
public class TeaModPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();

	public TeaModPwdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取参数
		String username = request.getParameter("userName");
		String pwd = request.getParameter("password1");
		// 修改数据
		int row = 0;
		row = userService.updateStuPwd(username, pwd);
		if (row > 0) {
			// 跳转登录界面
			response.sendRedirect("page/index.jsp");
			System.out.println("教师密码修改成功");
		} else {
			// 跳转注册界面并提示错误信息
			request.setAttribute("errorMsg", "密码修改失败，请稍后再试!");
			request.getRequestDispatcher("page/stuFindPwd.jsp").forward(request, response);
		}

	}

}

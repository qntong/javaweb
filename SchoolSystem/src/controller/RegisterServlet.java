package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.UserStu;
import entity.UserTea;
import service.UserService;

/**
 * 用户注册
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();

	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取参数
		String select = request.getParameter("reg_select");
		int row = -1;

		if ("student".equals(select)) {
			// 学生注册
			UserStu user = new UserStu();
			user.setS_name(request.getParameter("name"));
			user.setS_number(request.getParameter("username"));
			user.setS_password(request.getParameter("password1"));

			// 保存数据，返回数据改变行数
			row = userService.saveUserStu(user);
			// 返回结果
			if (row > 0) {
				// 跳转登录界面
				HttpSession session = request.getSession();
				session.setAttribute("username", user.getS_name());
				response.sendRedirect("page/index.jsp");
				System.out.println("学生注册成功");
			} else {
				// 跳转注册界面并提示错误信息
				request.setAttribute("errorMsg", "注册失败，请稍后再试!");
				request.getRequestDispatcher("page/register.jsp").forward(request, response);
			}
		} else {
			// 教师注册
			UserTea user = new UserTea();
			user.setT_name(request.getParameter("name"));
			user.setT_number(request.getParameter("username"));
			user.setT_password(request.getParameter("password1"));

			// 保存数据，返回数据改变行数
			row = userService.saveUserTea(user);

			// 返回结果
			if (row > 0) {
				// 跳转登录界面
				HttpSession session = request.getSession();
				session.setAttribute("username", user.getT_name());
				request.getRequestDispatcher("page/index.jsp").forward(request, response);
				System.out.println("教师注册成功");
			} else {
				// 跳转注册界面并提示错误信息
				request.setAttribute("errorMsg", "注册失败，请稍后再试!");
				request.getRequestDispatcher("page/register.jsp").forward(request, response);
			}
		}

		System.out.println("改变的行数：" + row);

	}

}

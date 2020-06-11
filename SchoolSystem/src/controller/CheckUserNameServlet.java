package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

/**
 * 检测注册时用户名是否存在
 */
@WebServlet("/CheckUserNameServlet")
public class CheckUserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();

	public CheckUserNameServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.获取参数
		String username = request.getParameter("username");
		String select = request.getParameter("select");
		// 2.验证email是否存在
		boolean isRight = userService.checkUserName(username, select);

		// 3.返回数据
		PrintWriter writer = response.getWriter();
		if (isRight) {
			writer.write("1");// 用户名可用
		} else {
			writer.write("2");// 用户名不可用
		}
	}

}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.UserTea;
import service.UserService;

/**
 * Servlet implementation class StuLoginServlet
 */
@WebServlet("/TeaLoginServlet")
public class TeaLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();

	public TeaLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1. 获取参数 2. 验证用户 3. 返回结果
		 */

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + "," + password);

		// 进行登录
		UserTea user = userService.teaLogin(username, password);
		boolean isRight = (user == null);
		System.out.println("TeaLoginServlet中user为真还是假：" + isRight);
		// 返回结果
		if (user != null) {
			// 成功登录
			HttpSession session = request.getSession();
			session.setAttribute("userStu", user);
			response.sendRedirect("TeaHomeServlet"); // 重定向发起一个请求，请求teaHomeServlet
		} else {
			request.setAttribute("errorMsg", "用户名或密码错误");
			request.getRequestDispatcher("page/index.jsp").forward(request, response);// 转发

			// response.sendRedirect("page/login.jsp");
		}
	}

}

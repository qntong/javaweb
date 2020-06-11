package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.UserStu;
import service.UserService;

/**
 * Servlet implementation class StuLoginServlet
 */
@WebServlet("/StuLoginServlet")
public class StuLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();

	public StuLoginServlet() {
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

		// 进行登录
		UserStu user = userService.stuLogin(username, password);
		boolean isRight = (user == null);
		// 返回结果
		if (user != null) {
			// 成功登录
			HttpSession session = request.getSession();
			session.setAttribute("userStu", user);
//			// 创建cookie并将成功登陆的用户保存在里面
//			Cookie cookie = new Cookie("stuName", user.getS_name());
//			cookie.setMaxAge(60 * 10); // 设置十分钟有效
//			response.addCookie(cookie); // 服务器返回给浏览器cookie以便下次判断
			response.sendRedirect("StuHomePageServlet"); // 重定向发起一个请求，请求stuHomePage
		} else {
			request.setAttribute("errorMsg", "用户名或密码错误");
			request.getRequestDispatcher("page/index.jsp").forward(request, response);// 转发

			// response.sendRedirect("page/login.jsp");
		}
	}

}

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
 * 校验密保是否正确
 */
@WebServlet("/CheckPwdSafeServlet")
public class CheckPwdSafeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();

	public CheckPwdSafeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取参数
		String flag = request.getParameter("flag");
		String userName = request.getParameter("userName");
		String pwdSafe = request.getParameter("pwdSafe");

		System.out.println("CheckPwdSafeServlet:" + userName + "," + pwdSafe + "," + flag);
		// 验证userName的密保是否正确
		boolean isRight = userService.checkPwdSafe(userName, pwdSafe, flag);

		System.out.println("CheckPwdSafeServlet中isRight为：" + isRight);
		// 返回数据
		PrintWriter writer = response.getWriter();
		if (isRight) {
			writer.write("1");// 密保存在
		} else {
			writer.write("2");// 密保不存在
		}
	}

}

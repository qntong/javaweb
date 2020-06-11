package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.UserStu;

/**
 * 检测原密码输入是否正确
 */
@WebServlet("/CheckOldPwdServlet")
public class CheckOldPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckOldPwdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取出登录时存入session中的用户信息
		HttpSession session = request.getSession();
		UserStu user = (UserStu) session.getAttribute("userStu");
		System.out.println("session中取到密码：" + user.getS_password());
		// 获取输入的原密码
		String oldPassword = request.getParameter("oldPassword");
		System.out.println("输入的OldPwd" + oldPassword);
		// 先比对密码，在返回数据
		PrintWriter writer = response.getWriter();
		if (user.getS_password().equals(oldPassword)) {
			writer.write("1");// 原密码输入正确
		} else {
			writer.write("2");// 原密码输入错误
		}
	}

}

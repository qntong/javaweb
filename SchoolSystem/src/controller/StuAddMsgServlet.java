package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.UserStu;
import service.UserService;

/**
 * 修改个人信息
 */
@WebServlet("/StuAddMsgServlet")
public class StuAddMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();

	public StuAddMsgServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");

		// 获取参数
		UserStu user = new UserStu();
		user.setS_name(request.getParameter("name"));
		// getParameter获取值返回类型为string，转换为int
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setS_telephone(request.getParameter("phone"));
		// 获取单选框中的性别
		if ("man".equals(request.getParameter("sex"))) {
			user.setS_sex("男");
		} else {
			user.setS_sex("女");
		}
		user.setS_home_address(request.getParameter("address"));
		user.setS_birthday(request.getParameter("birthday"));
		user.setInternship(request.getParameter("into"));

		UserStu userStu = (UserStu) request.getSession().getAttribute("userStu");
		String stuNo = userStu.getS_number();

		int row = userService.updateStuMsg(user, stuNo);

		System.out.println("row=" + row);
		PrintWriter out = response.getWriter();

		// 返回数据
		if (row > 0) {
			// 修改信息成功
			response.sendRedirect("StuHomePageServlet");
		} else {
			// 修改信息失败
			out.print("<script type='text/javascript'>alert('个人信息修改失败！');</script>");
			request.getRequestDispatcher("page/stuAddMsg.jsp").forward(request, response);
		}
	}

}

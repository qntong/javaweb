package service;

import java.sql.SQLException;

import dao.UserDao;
import entity.UserStu;
import entity.UserTea;

public class UserService {

	private UserDao userDao = new UserDao();

	/**
	 * 登录方法
	 * 
	 * @param username
	 * @param password
	 * @return user实体类
	 */
	public UserStu stuLogin(String username, String password) {

		UserStu user = null;
		try {
			user = userDao.getUserStuByNo(username);
			if (user != null && !user.getS_password().equals(password)) {
				user = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;

	}

	public UserTea teaLogin(String username, String password) {

		UserTea user = null;
		try {
			user = userDao.getUserTeaByNo(username);
			if (user != null && !user.getT_password().equals(password)) {
				user = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;

	}

	/**
	 * 查找用户是否存在
	 */
	public boolean checkUserName(String username, String select) {
		if ("student".equals(select)) {
			UserStu user = null;
			try {
				user = userDao.getUserStuByNo(username);
				return user == null ? true : false;

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			UserTea user = null;
			try {
				user = userDao.getUserTeaByNo(username);
				return user == null ? true : false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 保存学生注册数据
	 */
	public int saveUserStu(UserStu user) {

		int row = 0;
		try {
			row = userDao.saveUserStu(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	/**
	 * 保存教师注册数据
	 */
	public int saveUserTea(UserTea user) {
		int row = 0;
		try {
			row = userDao.saveUserTea(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	/**
	 * 查询密保
	 */
	public boolean checkPwdSafe(String userName, String pwdSafe, String flag) {
		boolean checkPwdSafe = false;
		try {
			checkPwdSafe = userDao.getPwdSafe(userName, pwdSafe, flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("userService中checkPwdSafe为" + checkPwdSafe);
		return checkPwdSafe;
	}

	/**
	 * student修改密码
	 */
	public int updateStuPwd(String username, String pwd) {
		int row = 0;

		try {
			row = userDao.updateStuPwd(username, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return row;
	}

	/**
	 * teacher修改密码
	 */
	public int updateTeaPwd(String username, String pwd) {
		int row = 0;

		try {
			row = userDao.updateTeaPwd(username, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return row;
	}

	/**
	 * 学生修改个人信息
	 */
	public int updateStuMsg(UserStu user, String stuNo) {
		int row = 0;
		try {
			row = userDao.updateStuMsg(user, stuNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}

}

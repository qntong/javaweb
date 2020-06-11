package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.UserStu;
import entity.UserTea;
import utils.DBUtils;

public class UserDao {

	/**
	 * 根据username获取信息(username即为学号s_number)
	 * 
	 * @param username
	 * @return UserStu
	 * @throws Exception
	 */
	public UserStu getUserStuByNo(String username) throws Exception {
		// 2.获取链接
		Connection connection = DBUtils.getConnection();

		// 3.创建statement并执行sql
		String sql = "SELECT * FROM s_user WHERE s_number = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		ResultSet resultSet = statement.executeQuery();

		UserStu user = null;

		// 4.处理结果集
		while (resultSet.next()) {

			user = new UserStu();
			user.setS_number(resultSet.getString("s_number"));
			user.setS_password(resultSet.getString("s_password"));
			user.setS_name(resultSet.getString("s_name"));
			user.setAge(resultSet.getInt("age"));
			user.setS_class(resultSet.getString("s_class"));
			user.setS_sex(resultSet.getString("s_sex"));
			user.setS_birthday(resultSet.getString("s_birthday"));
			user.setS_enrol_time(resultSet.getString("s_enrol_time"));
			user.setS_telephone(resultSet.getString("s_telephone"));
			user.setS_home_address(resultSet.getString("s_home_address"));
			user.setS_ranking(resultSet.getInt("s_ranking"));
			user.setS_competition(resultSet.getString("s_competition"));
			user.setS_honor(resultSet.getString("s_honor"));
			user.setS_family_situation(resultSet.getString("s_family_situation"));
			user.setHead_teacher(resultSet.getString("head_teacher"));
			user.setInstructor(resultSet.getString("instructor"));
			user.setTutor(resultSet.getString("tutor"));
			user.setInternship(resultSet.getString("internship"));
		}

		// 5.关闭资源
		DBUtils.close(resultSet, statement, connection);

		return user;
	}

	// 教师注册时查询教职工号是否存在
	public UserTea getUserTeaByNo(String username) throws SQLException {

		// 2.获取链接
		Connection connection = DBUtils.getConnection();

		// 3.创建statement并执行sql
		String sql = "SELECT * FROM t_user WHERE t_number = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		ResultSet resultSet = statement.executeQuery();

		UserTea user = null;

		while (resultSet.next()) {
			user = new UserTea();
			user.setT_number(resultSet.getString("t_number"));
			user.setT_name(resultSet.getString("t_name"));
			user.setT_password(resultSet.getString("t_password"));
			user.setT_title(resultSet.getString("t_title"));
			user.setT_duty(resultSet.getString("t_duty"));
		}
		// 5.关闭资源
		DBUtils.close(resultSet, statement, connection);

		return user;
	}

	/**
	 * 保存学生信息
	 * 
	 * @throws SQLException
	 */
	public int saveUserStu(UserStu user) throws SQLException {
		// 获取链接
		Connection connection = DBUtils.getConnection();

		String sql = "INSERT INTO s_user (s_number,s_password,s_name) VALUES (?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getS_number());
		statement.setString(2, user.getS_password());
		statement.setString(3, user.getS_name());
		int row = statement.executeUpdate();

		// 关闭资源
		DBUtils.close(null, statement, connection);

		return row;
	}

	/**
	 * 保存教师信息
	 * 
	 * @throws SQLException
	 */
	public int saveUserTea(UserTea user) throws SQLException {
		// 获取链接
		Connection connection = DBUtils.getConnection();

		String sql = "INSERT INTO t_user (t_number,t_password,t_name) VALUES (?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getT_number());
		statement.setString(2, user.getT_password());
		statement.setString(3, user.getT_name());
		int row = statement.executeUpdate();

		// 关闭资源
		DBUtils.close(null, statement, connection);

		return row;
	}

	/*
	 * 根据flag,username查询该用户是否设置密保
	 */
	public boolean getPwdSafe(String userName, String pwdSafe, String flag) throws SQLException {
		// 获取链接
		Connection connection = DBUtils.getConnection();
		boolean returnPwd = false;
		String sql = null;
		if ("student".equals(flag)) {
			sql = "SELECT pwd_safe FROM s_user WHERE s_number = " + userName;
		} else {
			sql = "SELECT pwd_safe FROM t_user WHERE t_number = " + userName;
		}
		System.out.println(sql);
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		// 判断密保输入框中的值和结果集中查到的密保是否相等
		while (resultSet.next()) {
			String safe = resultSet.getString("pwd_safe");
			if (pwdSafe.equals(safe)) {
				returnPwd = true;// 密保存在
			}
		}

		// 关闭资源
		DBUtils.close(resultSet, statement, connection);

		return returnPwd;
	}

	public int updateStuPwd(String username, String pwd) throws SQLException {
		Connection connection = DBUtils.getConnection();
		String sql = "update s_user set s_password = " + pwd + " where s_number = " + username;
		PreparedStatement statement = connection.prepareStatement(sql);
		int row = statement.executeUpdate();

		// 关闭资源
		DBUtils.close(null, statement, connection);

		return row;
	}

	/**
	 * 教师更改密码
	 * 
	 * @param username
	 * @param pwd
	 * @return
	 * @throws SQLException
	 */
	public int updateTeaPwd(String username, String pwd) throws SQLException {
		Connection connection = DBUtils.getConnection();
		String sql = "update t_user set t_password = " + pwd + " where t_number = " + username;
		PreparedStatement statement = connection.prepareStatement(sql);
		int row = statement.executeUpdate();

		// 关闭资源
		DBUtils.close(null, statement, connection);
		return row;
	}

	/*
	 * 学生修改个人信息
	 */
	public int updateStuMsg(UserStu user, String stuNo) throws SQLException {

		// 获取连接
		Connection connection = DBUtils.getConnection();
		String sql = "UPDATE s_user SET s_name= ?, age=?, s_telephone=?, s_sex=?,"
				+ "s_home_address=?,s_birthday=?,internship=? WHERE s_number=" + stuNo;
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getS_name());
		statement.setInt(2, user.getAge());
		statement.setString(3, user.getS_telephone());
		statement.setString(4, user.getS_sex());
		statement.setString(5, user.getS_home_address());
		statement.setString(6, user.getS_birthday());
		statement.setString(7, user.getInternship());

		int row = statement.executeUpdate();

		DBUtils.close(null, statement, connection);

		return row;
	}

}

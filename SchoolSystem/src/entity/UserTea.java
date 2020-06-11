package entity;

public class UserTea {
	private String t_number;// 教职工号
	private String t_name;// 教师姓名
	private String t_password;// 密码
	private String t_title;// 教师职称
	private String t_duty;// 教师职务

	public String getT_number() {
		return t_number;
	}

	public void setT_number(String t_number) {
		this.t_number = t_number;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getT_password() {
		return t_password;
	}

	public void setT_password(String t_password) {
		this.t_password = t_password;
	}

	public String getT_title() {
		return t_title;
	}

	public void setT_title(String t_title) {
		this.t_title = t_title;
	}

	public String getT_duty() {
		return t_duty;
	}

	public void setT_duty(String t_duty) {
		this.t_duty = t_duty;
	}

	@Override
	public String toString() {
		return "UserTea [t_number=" + t_number + ", t_name=" + t_name + ", t_password=" + t_password + ", t_title="
				+ t_title + ", t_duty=" + t_duty + "]";
	}

}

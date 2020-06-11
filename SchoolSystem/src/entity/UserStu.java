package entity;

public class UserStu {
	private String s_number;// 学号
	private String s_password;// 密码
	private String s_name;
	private int age;
	private String s_class;// 班级
	private String s_sex;
	private String s_birthday;
	private String s_enrol_time;// 入学日期
	private String s_telephone;
	private String s_home_address;// 家庭地址
	private int s_ranking;// 排名
	private String s_competition;// 参加的竞赛
	private String s_honor;// 荣誉
	private String s_family_situation;// 家庭情况
	private String head_teacher;// 班主任
	private String instructor;// 辅导员
	private String tutor;// 指导员
	private String pwd_safe;// 密保
	private String internship;// 大四实习情况

	public String getS_number() {
		return s_number;
	}

	public void setS_number(String s_number) {
		this.s_number = s_number;
	}

	public String getS_password() {
		return s_password;
	}

	public void setS_password(String s_password) {
		this.s_password = s_password;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getS_class() {
		return s_class;
	}

	public void setS_class(String s_class) {
		this.s_class = s_class;
	}

	public String getS_sex() {
		return s_sex;
	}

	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}

	public String getS_birthday() {
		return s_birthday;
	}

	public void setS_birthday(String s_birthday) {
		this.s_birthday = s_birthday;
	}

	public String getS_enrol_time() {
		return s_enrol_time;
	}

	public void setS_enrol_time(String s_enrol_time) {
		this.s_enrol_time = s_enrol_time;
	}

	public String getS_telephone() {
		return s_telephone;
	}

	public void setS_telephone(String s_telephone) {
		this.s_telephone = s_telephone;
	}

	public String getS_home_address() {
		return s_home_address;
	}

	public void setS_home_address(String s_home_address) {
		this.s_home_address = s_home_address;
	}

	public int getS_ranking() {
		return s_ranking;
	}

	public void setS_ranking(int s_ranking) {
		this.s_ranking = s_ranking;
	}

	public String getS_competition() {
		return s_competition;
	}

	public void setS_competition(String s_competition) {
		this.s_competition = s_competition;
	}

	public String getS_honor() {
		return s_honor;
	}

	public void setS_honor(String s_honor) {
		this.s_honor = s_honor;
	}

	public String getS_family_situation() {
		return s_family_situation;
	}

	public void setS_family_situation(String s_family_situation) {
		this.s_family_situation = s_family_situation;
	}

	public String getHead_teacher() {
		return head_teacher;
	}

	public void setHead_teacher(String head_teacher) {
		this.head_teacher = head_teacher;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public String getPwd_safe() {
		return pwd_safe;
	}

	public void setPwd_safe(String pwd_safe) {
		this.pwd_safe = pwd_safe;
	}

	public String getInternship() {
		return internship;
	}

	public void setInternship(String internship) {
		this.internship = internship;
	}

	@Override
	public String toString() {
		return "UserStu [s_number=" + s_number + ", s_password=" + s_password + ", s_name=" + s_name + ", age=" + age
				+ ", s_class=" + s_class + ", s_sex=" + s_sex + ", s_birthday=" + s_birthday + ", s_enrol_time="
				+ s_enrol_time + ", s_telephone=" + s_telephone + ", s_home_address=" + s_home_address + ", s_ranking="
				+ s_ranking + ", s_competition=" + s_competition + ", s_honor=" + s_honor + ", s_family_situation="
				+ s_family_situation + ", head_teacher=" + head_teacher + ", instructor=" + instructor + ", tutor="
				+ tutor + ", pwd_safe=" + pwd_safe + ", internship=" + internship + "]";
	}

}

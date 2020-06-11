package entity;

public class Grade {
	private String s_class;// 班级
	private String s_number;// 学号
	private String s_name;// 姓名
	private String course_name;
	private int score;
	private String teacher;

	public String getS_class() {
		return s_class;
	}

	public void setS_class(String s_class) {
		this.s_class = s_class;
	}

	public String getS_number() {
		return s_number;
	}

	public void setS_number(String s_number) {
		this.s_number = s_number;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Grade [s_class=" + s_class + ", s_number=" + s_number + ", s_name=" + s_name + ", course_name="
				+ course_name + ", score=" + score + ", teacher=" + teacher + "]";
	}

}

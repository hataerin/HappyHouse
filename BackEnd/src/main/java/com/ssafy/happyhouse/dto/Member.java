package com.ssafy.happyhouse.dto;

public class Member {
	private String id;
	private int age;
	private String pwd;
	private String nickname;
	private int sex; // 1 남자 2 여자
	private int admin; // 0 관리자 1 일반
	private String mbti;
	private String job;
	private String email;
	private String joindate;

	public Member(String id, int age, String pwd, String nickname, int sex, int admin, String mbti, String job,
			String email, String joindate) {
		super();
		this.id = id;
		this.age = age;
		this.pwd = pwd;
		this.nickname = nickname;
		this.sex = sex;
		this.admin = admin;
		this.mbti = mbti;
		this.job = job;
		this.email = email;
		this.joindate = joindate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public String getMbti() {
		return mbti;
	}

	public void setMbti(String mbti) {
		this.mbti = mbti;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", age=" + age + ", pwd=" + pwd + ", nickname=" + nickname + ", sex=" + sex
				+ ", admin=" + admin + ", mbti=" + mbti + ", job=" + job + ", email=" + email + ", joindate=" + joindate
				+ "]";
	}

}

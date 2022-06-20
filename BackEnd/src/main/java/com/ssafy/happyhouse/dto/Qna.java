package com.ssafy.happyhouse.dto;

public class Qna {
	private int qnano;
	private String userid;
	private String subject;
	private String content;
	private String regtime;

	public Qna(int qnano, String userid, String subject, String content, String regtime) {
		super();
		this.qnano = qnano;
		this.userid = userid;
		this.subject = subject;
		this.content = content;
		this.regtime = regtime;
	}

	public int getQnano() {
		return qnano;
	}

	public void setQnano(int qnano) {
		this.qnano = qnano;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	@Override
	public String toString() {
		return "Qna [qnano=" + qnano + ", userid=" + userid + ", subject=" + subject + ", content=" + content
				+ ", regtime=" + regtime + "]";
	}

}

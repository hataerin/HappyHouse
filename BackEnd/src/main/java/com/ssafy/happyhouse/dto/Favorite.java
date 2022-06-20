package com.ssafy.happyhouse.dto;

public class Favorite {
	private int no;
	private String userid;
	private int housedealno;

	public Favorite(int no, String userid, int housedealno) {
		super();
		this.no = no;
		this.userid = userid;
		this.housedealno = housedealno;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getHousedealno() {
		return housedealno;
	}

	public void setHousedealno(int housedealno) {
		this.housedealno = housedealno;
	}

	@Override
	public String toString() {
		return "Favorite [no=" + no + ", userid=" + userid + ", housedealno=" + housedealno + "]";
	}

}

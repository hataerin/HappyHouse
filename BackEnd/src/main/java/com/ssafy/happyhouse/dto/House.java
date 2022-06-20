package com.ssafy.happyhouse.dto;

public class House {
	private int no;
	private String sidogun;
	private String aptname;
	private String area;
	private String dealyearmonth;
	private String dealday;
	private String dealamount;
	private String floor;
	private String buildyear;
	private String roadname;
	private int type;
	private String lat; // 위도
	private String lng; // 경도

	public House(int no, String sidogun, String aptname, String area, String dealyearmonth, String dealday,
			String dealamount, String floor, String buildyear, String roadname, int type, String lat, String lng) {
		super();
		this.no = no;
		this.sidogun = sidogun;
		this.aptname = aptname;
		this.area = area;
		this.dealyearmonth = dealyearmonth;
		this.dealday = dealday;
		this.dealamount = dealamount;
		this.floor = floor;
		this.buildyear = buildyear;
		this.roadname = roadname;
		this.type = type;
		this.lat = lat;
		this.lng = lng;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSidogun() {
		return sidogun;
	}

	public void setSidogun(String sidogun) {
		this.sidogun = sidogun;
	}

	public String getAptname() {
		return aptname;
	}

	public void setAptname(String aptname) {
		this.aptname = aptname;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDealyearmonth() {
		return dealyearmonth;
	}

	public void setDealyearmonth(String dealyearmonth) {
		this.dealyearmonth = dealyearmonth;
	}

	public String getDealday() {
		return dealday;
	}

	public void setDealday(String dealday) {
		this.dealday = dealday;
	}

	public String getDealamount() {
		return dealamount;
	}

	public void setDealamount(String dealamount) {
		this.dealamount = dealamount;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getBuildyear() {
		return buildyear;
	}

	public void setBuildyear(String buildyear) {
		this.buildyear = buildyear;
	}

	public String getRoadname() {
		return roadname;
	}

	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	@Override
	public String toString() {
		return "House [no=" + no + ", sidogun=" + sidogun + ", aptname=" + aptname + ", area=" + area
				+ ", dealyearmonth=" + dealyearmonth + ", dealday=" + dealday + ", dealamount=" + dealamount
				+ ", floor=" + floor + ", buildyear=" + buildyear + ", roadname=" + roadname + ", type=" + type
				+ ", lat=" + lat + ", lng=" + lng + "]";
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

}

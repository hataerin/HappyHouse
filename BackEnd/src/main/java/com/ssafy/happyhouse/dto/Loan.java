package com.ssafy.happyhouse.dto;

public class Loan {
	private int id;
	private String name;
	private String description;
	private int object_age;
	private int object_income;
	private int object_houseNum;
	private String object_asset;
	private String rate;
	private String limit;
	private String term;
	private String object_description;
	private String url;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getObject_age() {
		return object_age;
	}
	public void setObject_age(int object_age) {
		this.object_age = object_age;
	}
	public int getObject_income() {
		return object_income;
	}
	public void setObject_income(int object_income) {
		this.object_income = object_income;
	}
	public int getObject_houseNum() {
		return object_houseNum;
	}
	public void setObject_houseNum(int object_houseNum) {
		this.object_houseNum = object_houseNum;
	}
	public String getObject_asset() {
		return object_asset;
	}
	public void setObject_asset(String object_asset) {
		this.object_asset = object_asset;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getObject_description() {
		return object_description;
	}
	public void setObject_description(String object_description) {
		this.object_description = object_description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}

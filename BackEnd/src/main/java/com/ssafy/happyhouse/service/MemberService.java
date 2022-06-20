package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Member;

public interface MemberService {
	void insertMember(Member member) throws SQLException;

	void deleteMember(String id) throws SQLException;

	Member selectMember(Member member) throws SQLException;

	List<Member> selectAllMember() throws SQLException;
	
	void updateMember(Member member) throws SQLException;
	
	Member loginMember(Map<String,String> param) throws SQLException;
	public List<String> searchId() throws SQLException;
}

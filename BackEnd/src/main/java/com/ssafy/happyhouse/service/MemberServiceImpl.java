package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	@Transactional
	public void insertMember(Member member) throws SQLException {
		memberMapper.insertMember(member);	
	}

	@Override
	@Transactional
	public void deleteMember(String id) throws SQLException {
		memberMapper.deleteMember(id);
	}

	@Override
	@Transactional
	public Member selectMember(Member member) throws SQLException {
		return memberMapper.selectMember(member);
	}

	@Override
	@Transactional
	public List<Member> selectAllMember() throws SQLException {
		return memberMapper.selectAllMember();
	}

	@Override
	@Transactional
	public void updateMember(Member member) throws SQLException {
		memberMapper.updateMember(member);		
	}

	@Override
	@Transactional
	public Member loginMember(Map<String,String> param) throws SQLException {
		return memberMapper.loginMember(param);
	}

	@Override
	public List<String> searchId() throws SQLException {
		return memberMapper.searchId();
	}
	

	
}

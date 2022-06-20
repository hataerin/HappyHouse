package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.Loan;
import com.ssafy.happyhouse.dto.Notice;
import com.ssafy.happyhouse.mapper.LoanMapper;
import com.ssafy.happyhouse.mapper.NoticeMapper;

@Service
public class LoanServiceImpl implements LoanService{
	
	@Autowired
	private LoanMapper loanMapper;

	@Override
	@Transactional
	public List<Loan> getLoan(int age, int income, int houseNum, String asset) throws SQLException {
		return loanMapper.getLoan(age, income, houseNum, asset);
	}
}

package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Loan;
import com.ssafy.happyhouse.dto.Notice;

public interface LoanService {
	public List<Loan> getLoan(int age, int income, int houseNum, String asset) throws SQLException;
}

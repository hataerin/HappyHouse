package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Loan;
import com.ssafy.happyhouse.dto.Notice;
import com.ssafy.happyhouse.service.LoanService;
import com.ssafy.happyhouse.service.NoticeService;

@RestController
@RequestMapping("/rest")
public class LoanControllerRest {
	
	@Autowired
	private LoanService loanService;
	
	@GetMapping("/loan")
	public List<Loan> getLoan(@RequestParam int age, @RequestParam int income, @RequestParam int houseNum, @RequestParam String asset) throws SQLException {
		return loanService.getLoan(age, income, houseNum, asset);
	}
}

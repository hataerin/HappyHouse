package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.service.JwtService;
import com.ssafy.happyhouse.service.MemberService;

@CrossOrigin(origins="http://localhost:8080")
@RestController
@RequestMapping("/rest")
public class MemberControllerRest {
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private MemberService memberService;

	public static final Logger logger = LoggerFactory.getLogger(MemberControllerRest.class);

	/*
	 * 	
	void insertMember(Member member) throws SQLException;
V	void deleteMember(Member member) throws SQLException;
?	Member selectMember(Member member) throws SQLException;
V	List<Member> selectAllMember(Member member) throws SQLException;
V	void updateMember(Member member) throws SQLException;
V	Member loginMember(Member member) throws SQLException;  
	 * 
	 * */
	@GetMapping("/member/admin")
	public List<Member> selectAllMember() throws SQLException {
		return memberService.selectAllMember();
	}
	
	@GetMapping("/member")
	public List<String> searchId() throws SQLException {
		return memberService.searchId();
	}
	
/*	@GetMapping("/member/login")
	public Member login(Member member) throws SQLException {
		return memberService.loginMember(member);
	}*/
	@PostMapping("/member/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String,String> param, HttpServletResponse response, HttpSession session) throws SQLException{
	//	System.out.println(param.get("id"));
	//	System.out.println(param.get("pwd"));
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			Member loginUser = memberService.loginMember(param);;
			
			if(loginUser != null) {
//				jwt.io에서 확인
//				로그인 성공했다면 토큰을 생성한다.
				String token = jwtService.create(loginUser);
				logger.trace("로그인 토큰정보 : {}", token);
				
//				토큰 정보는 response의 헤더로 보내고 나머지는 Map에 담는다.
//				response.setHeader("auth-token", token);
				resultMap.put("auth-token", token);
//				resultMap.put("user-id", loginUser.getUserid());
//				resultMap.put("user-name", loginUser.getUsername());
				resultMap.put("user", loginUser);
//				resultMap.put("status", true);
//				resultMap.put("data", loginUser);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", "로그인 실패");
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
//		return memberService.loginMember(param);
	}
	
	@GetMapping("/member/info")
	public ResponseEntity<Map<String, Object>> getInfo(HttpServletRequest req) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		System.out.println(">>>>>> " + jwtService.get(req.getHeader("auth-token")));
		try {
			// 사용자에게 전달할 정보이다.
//			String info = memberService.getServerInfo();
			
			resultMap.putAll(jwtService.get(req.getHeader("auth-token")));
//
//			resultMap.put("status", true);
//			resultMap.put("info", info);
			status = HttpStatus.ACCEPTED;
		} catch (RuntimeException e) {
			logger.error("정보조회 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	
	@PutMapping("/member")
	public void updateMember(@RequestBody Member member) throws SQLException {
		System.out.println(member);
		memberService.updateMember(member);
	}
	
	@DeleteMapping("/member/{id}")
	public void deleteMember(@PathVariable String id) throws SQLException {
		memberService.deleteMember(id);
	}
	
	@PostMapping("/member")
	public void insertMember(@RequestBody Member member) throws SQLException{
		memberService.insertMember(member);
	}
	
	
}

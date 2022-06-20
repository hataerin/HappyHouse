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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Notice;
import com.ssafy.happyhouse.service.NoticeService;

@RestController
@RequestMapping("/rest")
public class NoticeControllerRest {
	
	@Autowired
	private NoticeService noticeService;

	@PostMapping("/notice")
	public void writeNotice(@RequestBody Notice notice)throws SQLException{
		noticeService.writeNotice(notice);
	}
	
	@GetMapping("/notice")
	public List<Notice> listNoticeAll() throws SQLException {
		return noticeService.listNoticeAll();
	}
	
	@GetMapping("/notice/detail/{noticeno}")
	public Notice getNotice(@PathVariable int noticeno) throws SQLException {
		return noticeService.getNotice(noticeno);
	}
	
	@PutMapping("/notice")
	public void modifyNotice(@RequestBody Notice notice) throws SQLException {
		noticeService.modifyNotice(notice);
	}
	
	@DeleteMapping("/notice/{noticeno}")
	public void deleteNotice(@PathVariable int noticeno) throws SQLException {
		noticeService.deleteNotice(noticeno);
	}
}

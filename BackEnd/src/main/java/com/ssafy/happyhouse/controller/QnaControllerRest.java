package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.List;

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
import com.ssafy.happyhouse.dto.Qna;
import com.ssafy.happyhouse.service.QnaService;

@RestController
@RequestMapping("/rest")
public class QnaControllerRest {
	
	@Autowired
	private QnaService qnaService;

	@PostMapping("/qna")
	public void writeQna(@RequestBody Qna qna)throws SQLException{
		qnaService.writeQna(qna);
	}
	
	@GetMapping("/qna")
	public List<Qna> listQnaAll() throws SQLException {
		return qnaService.listQnaAll();
	}
	
	@GetMapping("/qna/detail/{qnano}")
	public Qna getQna(@PathVariable int qnano) throws SQLException {
		return qnaService.getQna(qnano);
	}
	
	@PutMapping("/qna")
	public void modifyQna(@RequestBody Qna qna) throws SQLException {
		qnaService.modifyQna(qna);
	}
	
	@DeleteMapping("/qna/{qnano}")
	public void deleteNotice(@PathVariable int qnano) throws SQLException {
		qnaService.deleteQna(qnano);
	}
}

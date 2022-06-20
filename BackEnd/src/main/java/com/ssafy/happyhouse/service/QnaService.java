package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Qna;

public interface QnaService {
	public void writeQna(Qna qna) throws SQLException;
//	public List<qna> search(Map<String,String> param) throws SQLException;
	public List<Qna> listQnaAll() throws SQLException;
	public Qna getQna(int qnano) throws SQLException;
	public void modifyQna(Qna qna) throws SQLException;
	public void deleteQna(int qnano) throws SQLException;
}

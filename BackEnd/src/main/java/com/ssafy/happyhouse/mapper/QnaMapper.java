package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Qna;


public interface QnaMapper {
	public void writeQna(Qna qna) throws SQLException;
	public List<Qna> listQnaAll() throws SQLException;
	public int selectQnaCount() throws SQLException;
	public Qna getQna(int qnano) throws SQLException;
	public void modifyQna(Qna qna) throws SQLException;
	public void deleteQna(int qnano) throws SQLException;
}

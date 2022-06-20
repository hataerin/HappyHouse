package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.Qna;
import com.ssafy.happyhouse.mapper.QnaMapper;

@Service
public class QnaServiceImpl implements QnaService{
//	private QnaMapper QnaMapper;
	
	@Autowired
	private QnaMapper QnaMapper;
	
//	public QnaServiceImpl() {
//		QnaMapper = new QnaMapperImpl();
//	}



	@Override
	@Transactional
	public List<Qna> listQnaAll() throws SQLException {
		
		return QnaMapper.listQnaAll();
	}

	@Override
	@Transactional
	public Qna getQna(int qnano) throws SQLException {
		return QnaMapper.getQna(qnano);
	}

	@Override
	@Transactional
	public void modifyQna(Qna qna) throws SQLException {
		QnaMapper.modifyQna(qna);
		
	}

	@Override
	@Transactional
	public void deleteQna(int qnano) throws SQLException {
		QnaMapper.deleteQna(qnano);
		
	}

	@Override
	@Transactional
	public void writeQna(Qna qna) throws SQLException {
		QnaMapper.writeQna(qna);
		
	}


}

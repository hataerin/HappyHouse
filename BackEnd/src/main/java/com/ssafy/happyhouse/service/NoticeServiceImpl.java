package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.Notice;
import com.ssafy.happyhouse.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService{
//	private noticeMapper noticeMapper;
	
	@Autowired
	private NoticeMapper noticeMapper;
	
//	public NoticeServiceImpl() {
//		noticeMapper = new noticeMapperImpl();
//	}



	@Override
	@Transactional
	public List<Notice> listNoticeAll() throws SQLException {
		
		return noticeMapper.listNoticeAll();
	}

	@Override
	@Transactional
	public Notice getNotice(int noticeno) throws SQLException {
		return noticeMapper.getNotice(noticeno);
	}

	@Override
	@Transactional
	public void modifyNotice(Notice notice) throws SQLException {
		noticeMapper.modifyNotice(notice);
		
	}

	@Override
	@Transactional
	public void deleteNotice(int noticeno) throws SQLException {
		noticeMapper.deleteNotice(noticeno);
		
	}

	@Override
	@Transactional
	public void writeNotice(Notice notice) throws SQLException {
		noticeMapper.writeNotice(notice);
		
	}


}

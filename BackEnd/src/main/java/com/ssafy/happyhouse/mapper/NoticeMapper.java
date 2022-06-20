package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Notice;


public interface NoticeMapper {
	public void writeNotice(Notice notice) throws SQLException;
	public List<Notice> listNoticeAll() throws SQLException;
	public int selectNoticeCount() throws SQLException;
	public Notice getNotice(int noticeno) throws SQLException;
	public void modifyNotice(Notice notice) throws SQLException;
	public void deleteNotice(int noticeno) throws SQLException;
}

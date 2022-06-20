package com.ssafy.happyhouse.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.Favorite;
import com.ssafy.happyhouse.mapper.FavoriteMapper;


@Service
public class FavoriteServiceImpl implements FavoriteService{
	
	@Autowired
	private FavoriteMapper favoriteMapper;
	
	@Override
	@Transactional
	public void insertFavorite(Favorite favorite) throws SQLException {
		favoriteMapper.insertFavorite(favorite);
	}

	@Override
	@Transactional
	public void deleteFavorite(int no) throws SQLException {
		favoriteMapper.deleteFavorite(no);
	}

}

package com.ssafy.happyhouse.service;

import java.sql.SQLException;

import com.ssafy.happyhouse.dto.Favorite;

public interface FavoriteService {
	public void insertFavorite(Favorite favorite) throws SQLException;
	public void deleteFavorite(int no) throws SQLException;
}

package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.Favorite;

public interface FavoriteMapper {
	public void insertFavorite(Favorite favorite) throws SQLException;
	public void deleteFavorite(int no) throws SQLException;
}

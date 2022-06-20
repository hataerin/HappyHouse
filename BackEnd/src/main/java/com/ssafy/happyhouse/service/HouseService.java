package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.FavoriteHouse;
import com.ssafy.happyhouse.dto.House;

public interface HouseService {
	public List<House> searchHouse(List<String> word) throws SQLException;
	public List<FavoriteHouse> searchByFavoritesHouse(String userid) throws SQLException;
	public List<House> searchAllHouse() throws SQLException;
}

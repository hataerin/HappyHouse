package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.FavoriteHouse;
import com.ssafy.happyhouse.dto.House;
import com.ssafy.happyhouse.mapper.HouseMapper;

@Service
public class HouseServiceImpl implements HouseService{

	@Autowired
	private HouseMapper houseMapper;
	
	@Override
	public List<House> searchHouse(List<String> word) throws SQLException {
		return houseMapper.searchHouse(word);
	}

	@Override
	public List<FavoriteHouse> searchByFavoritesHouse(String userid) throws SQLException {
		return houseMapper.searchByFavoritesHouse(userid);
	}

	@Override
	public List<House> searchAllHouse() throws SQLException {
		return houseMapper.searchAllHouse();
	}

}

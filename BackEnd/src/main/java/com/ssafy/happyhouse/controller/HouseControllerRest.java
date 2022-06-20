package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.FavoriteHouse;
import com.ssafy.happyhouse.dto.House;
import com.ssafy.happyhouse.service.HouseService;

@RestController
@RequestMapping("/rest")
public class HouseControllerRest {
	@Autowired
	private HouseService houseService;
	
/*	public List<House> searchHouse(String word) throws SQLException;
	public List<House> searchByFavoritesHouse(String userid) throws SQLException;
	public List<House> searchAllHouse() throws SQLException;*/
	@GetMapping("/house")
	public List<House> searchAllHouse() throws SQLException{
		return houseService.searchAllHouse();
	}
/*	@GetMapping("/house/search/{word}")
	public List<House> searchBywordHouse(@PathVariable String word) throws SQLException{
		return houseService.searchHouse(word);
	}*/
	@GetMapping("/house/search")
	public List<House> searchBywordsHouse(@RequestParam List<String> word) throws SQLException{
		return houseService.searchHouse(word);
	}
	@GetMapping("/house/favorites/{userid}")
	public List<FavoriteHouse> searchByFavoritesHouse(@PathVariable String userid) throws SQLException{
		return houseService.searchByFavoritesHouse(userid);
	}
}

package com.ssafy.happyhouse.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Favorite;
import com.ssafy.happyhouse.service.FavoriteService;

@RestController
@RequestMapping("/rest")
public class FavoriteController {
	@Autowired
	private FavoriteService favoriteService;
	//	public void insertFavorite(Favorite favorite) throws SQLException;
	//	public void deleteFavorite(int no) throws SQLException;
	
	@PostMapping("/favorite")
	public void insertFavorite(Favorite favorite)throws SQLException{
		favoriteService.insertFavorite(favorite);
	}
	@DeleteMapping("/favorite")
	public void deleteFavorite(int no) throws SQLException {
		favoriteService.deleteFavorite(no);
	}
}

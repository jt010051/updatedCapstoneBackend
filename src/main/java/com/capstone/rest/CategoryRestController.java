package com.capstone.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.domain.Category;
import com.capstone.repositories.CategoryRepository;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

	@Autowired
	CategoryRepository categoryRepo;
	
	@GetMapping
	public List<Category> getAllSongs(HttpServletResponse response) {
		return categoryRepo.findAll();
	}
	
	
}

package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.Category;

@Service
public interface CategoryService {
	

	public List<Category> getCategoryList();
	
	
}

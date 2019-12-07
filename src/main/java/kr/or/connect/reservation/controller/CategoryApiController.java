package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.response.CategoryResponse;
import kr.or.connect.reservation.service.CategoryService;

@RestController
@RequestMapping(path = "/api/categories")
public class CategoryApiController {


	@Autowired
	public CategoryService categoryService;
	
    @GetMapping(path = "")
    public CategoryResponse getCategoryResponse() {
        return categoryService.getCategoryResponse();
    }

}

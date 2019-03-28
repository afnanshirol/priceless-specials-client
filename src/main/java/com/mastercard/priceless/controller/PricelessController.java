package com.mastercard.priceless.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mastercard.priceless.category.model.CategoryResponse;
import com.mastercard.priceless.category.service.CategoryService;
import com.mastercard.priceless.category.service.CountryService;
import com.mastercard.priceless.category.service.LanguageService;
import com.mastercard.priceless.category.service.MasterCardProductsService;
import com.mastercard.priceless.category.service.MasterCardPrograms;
import com.mastercard.priceless.category.service.PricelessOfferService;

@Controller
@RequestMapping(path = "/priceless/specials/v1")
public class PricelessController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	LanguageService languageService;
	
	@Autowired
	MasterCardProductsService masterProductsService;
	
	@Autowired
	MasterCardPrograms masterCardPrograms;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	PricelessOfferService pricelessOfferService;
	
	String queryParam = "";
	
	@RequestMapping(path="/categories")
	public ResponseEntity<CategoryResponse> getcategory() throws Exception{
		return categoryService.getPricelessCategories(queryParam);
	}
	
	@RequestMapping(path="/languages")
	public ResponseEntity<String> getLanguages() throws Exception{
		return languageService.getLanguagues(queryParam);
	}
	
	@RequestMapping(path="/mastercard-products")
	public ResponseEntity<String> getMasterCardProducts() throws Exception{
		return masterProductsService.getMasterCardProducts(queryParam);
	}
	
	@RequestMapping(path="/programs")
	public ResponseEntity<String> getMasterCardPrograms() throws Exception{
		return masterCardPrograms.getMasterCardPrograms(queryParam);
	}
	
	@RequestMapping(path="/countries")
	public ResponseEntity<String> getCountries() throws Exception{
		return countryService.getCountries(queryParam);
	}
	
	@RequestMapping(path="/offers")
	public ResponseEntity<String> getOffers() throws Exception{
		this.queryParam = "?category=201811010005";
		return pricelessOfferService.getOffers(queryParam);
	}
}

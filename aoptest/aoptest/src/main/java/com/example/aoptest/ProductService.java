package com.example.aoptest;

import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService {
	public ProductVo findProduct(String keyword) {
		System.out.println("finding ["+keyword+"]...");
		
		if(keyword.equals("bomb")) {
			throw new RuntimeException("BOOM~~~!") ;
		}
		
		return new ProductVo(keyword);
	}
}

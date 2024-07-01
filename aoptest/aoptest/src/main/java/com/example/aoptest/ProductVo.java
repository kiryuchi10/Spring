package com.example.aoptest;

public class ProductVo {
	private String name;
	
	public ProductVo() {
		
	}
	public ProductVo(String name) {
		this.name=name;
	}
	public String getName(String name) {
		return name;
	}
	public void setName() {
		this.name=name;
	}
	@Override
	public String toString() {
		return "ProductVo [name=" + name + "]";
	}
	
}

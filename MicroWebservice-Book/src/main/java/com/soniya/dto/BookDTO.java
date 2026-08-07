package com.soniya.dto;

public class BookDTO {
	private Long id;
	private String name;
	private Integer price;
	
	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDTO(Long id, String name, Integer price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}
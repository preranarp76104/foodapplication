package com.foodapplication.model;

public class CartItem {
	private int mid;
	private int rid;
	private String name;
	private int quantity;
	private int price;
	private double rating;
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public CartItem(int mid, int rid, String name, int quantity, int price) {
		super();
		this.mid = mid;
		this.rid = rid;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public CartItem(int rid, String name, int quantity, int price) {
		super();
		this.rid = rid;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CartItem [mid=" + mid + ", rid=" + rid + ", name=" + name + ", quantity=" + quantity + ", price="
				+ price + ", rating=" + rating + "]";
	}
	public CartItem(int mid, int rid, String name, int quantity, int price, double rating) {
		super();
		this.mid = mid;
		this.rid = rid;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.rating = rating;
	}
	public CartItem(int rid, String name, int quantity, int price, double rating) {
		super();
		this.rid = rid;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.rating = rating;
	}
	
	
	

}

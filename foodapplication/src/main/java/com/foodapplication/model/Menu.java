package com.foodapplication.model;




public class Menu {

		private int mid;
		private int rid;
		private String mname;
		private String description;
		private int price;
		private double rating;
		private String image;
		public Menu(int mid, int rid, String mname, String description, int price, double ratings,String image) {
			super();
			this.mid = mid;
			this.rid = rid;
			this.mname = mname;
			this.description = description;
			this.price = price;
			this.rating = rating;
			this.image = image;
		}
		public Menu(int rid, String mname, String description, int price, double rating, String image) {
			super();
			this.rid = rid;
			this.mname = mname;
			this.description = description;
			this.price = price;
			this.rating = rating;
			this.image = image;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
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
		public String getMname() {
			return mname;
		}
		public void setMname(String mname) {
			this.mname = mname;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public double getRating() {
			return rating;
		}
		public void setRating(double rating) {
			this.rating = rating;
		}
		public Menu(int mid, int rid, String mname, String description, int price, double rating) {
			super();
			this.mid = mid;
			this.rid = rid;
			this.mname = mname;
			this.description = description;
			this.price = price;
			this.rating = rating;
		}
	
		
		
		public Menu() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Menu(int rid, String mname, String description, int price, double rating) {
			super();
			this.rid = rid;
			this.mname = mname;
			this.description = description;
			this.price = price;
			this.rating = rating;
		}
		@Override
		public String toString() {
			return "Menu [mid=" + mid + ", rid=" + rid + ", mname=" + mname + ", description=" + description
					+ ", price=" + price + ", rating=" + rating + ", image=" + image + "]";
		}
		public Menu(int mid, int rid, String mname, String description, int price) {
			super();
			this.mid = mid;
			this.rid = rid;
			this.mname = mname;
			this.description = description;
			this.price = price;
		}
		
		

	}




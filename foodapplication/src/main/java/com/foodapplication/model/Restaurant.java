package com.foodapplication.model;



public class Restaurant {

   
	private int rid;
    private String rname;
    private String cuisineType;
    private String address;
    private double ratings;
    private int deliveryTime;
    private boolean isActive;
    private String image;

    public Restaurant(String rname, String cuisineType, String address, double ratings, int deliveryTime,
			boolean isActive, String image) {
		super();
		this.rname = rname;
		this.cuisineType = cuisineType;
		this.address = address;
		this.ratings = ratings;
		this.deliveryTime = deliveryTime;
		this.isActive = isActive;
		this.image = image;
	}

	public Restaurant(int rid, String rname, String cuisineType, String address, double ratings, String image) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.cuisineType = cuisineType;
		this.address = address;
		this.ratings = ratings;
		this.deliveryTime = deliveryTime;
		this.isActive = isActive;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	// Default constructor
    public Restaurant() {
    	
    }

    // Parameterized constructor
    public Restaurant(int rid, String rname, String cuisineType, String address, double ratings, int deliveryTime, boolean isActive) {
        this.rid = rid;
        this.rname = rname;
        this.cuisineType = cuisineType;
        this.address = address;
        this.ratings = ratings;
        this.deliveryTime = deliveryTime;
        this.isActive = isActive;
    }
    
    public Restaurant(String rname, String cuisineType, String address, double ratings, int deliveryTime,
			boolean isActive) {
		super();
		this.rname = rname;
		this.cuisineType = cuisineType;
		this.address = address;
		this.ratings = ratings;
		this.deliveryTime = deliveryTime;
		this.isActive = isActive;
	}


  
	public Restaurant(int rid, String rname, String cuisineType, String address, double ratings) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.cuisineType = cuisineType;
		this.address = address;
		this.ratings = ratings;
	}

	// Getters and Setters
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
	public String toString() {
		return "Restaurant [rid=" + rid + ", rname=" + rname + ", cuisineType=" + cuisineType + ", address=" + address
				+ ", ratings=" + ratings + ", deliveryTime=" + deliveryTime + ", isActive=" + isActive + ", image="
				+ image + "]";
	}
}

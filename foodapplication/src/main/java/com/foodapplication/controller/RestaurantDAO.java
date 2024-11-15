package com.foodapplication.controller;

import java.util.ArrayList;

import com.foodapplication.model.Restaurant;

public interface RestaurantDAO {

    int addRestaurant(Restaurant restaurant);
    ArrayList<Restaurant> getAllRestaurants();
    Restaurant fetchSpecific(int restaurantId);
    int updateRestaurant(Restaurant restaurant);
    int deleteRestaurant(int restaurantId);
    
}
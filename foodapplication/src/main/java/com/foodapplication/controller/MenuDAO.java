package com.foodapplication.controller;

import java.util.ArrayList;
import com.foodapplication.model.Menu;

public interface MenuDAO {

    // Adds a new menu item
    int addMenuItem(Menu menuItem);

    // Retrieves all menu items
    ArrayList<Menu> getAllMenuItems();

    // Fetches a specific menu item by menu ID
    Menu fetchSpecific(int menuId);

    // Updates an existing menu item
    int updateMenuItem(Menu menuItem);

    // Deletes a menu item by menu ID
    int deleteMenuItem(int menuId);

    // Retrieves all menu items for a specific restaurant by restaurant ID
    ArrayList<Menu> getOnrid(int rid);
}

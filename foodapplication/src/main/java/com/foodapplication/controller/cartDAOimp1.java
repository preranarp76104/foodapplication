package com.foodapplication.controller;

import java.util.HashMap;
import java.util.Map;

import com.foodapplication.model.CartItem;

public class cartDAOimp1 {
	private Map<Integer, CartItem> items;

	public cartDAOimp1() {
		this.items = new HashMap<>();
	}
	
	 public Map<Integer,CartItem> addItem( Map<Integer, CartItem> items,CartItem item){
		 int mid=item.getMid();
	 if(items.containsKey(mid)) { 
		 CartItem existingItem=items.get(mid);
	     existingItem.setQuantity(existingItem.getQuantity()+item.getQuantity());
	  
	 }else { 
		 items.put(mid, item);
		 }
	 return items;
	 }
	 

	public Map<Integer, CartItem> updateItem(Map<Integer, CartItem> items,int mid, int quantity) {
		if (items.containsKey(mid)) {
			CartItem item=items.get(mid);
			
			if (quantity <= 0) {
				items.remove(mid);
			} else {
				item.setQuantity(quantity);
			}
		
		}else {
			System.out.println("Item with id"+mid+"not found in cart");
		}
		return items;
	}


}


	



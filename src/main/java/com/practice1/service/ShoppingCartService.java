package com.practice1.service;

import java.util.List;

import com.practice1.entities.CartItem;
import com.practice1.entities.SanPham;
import com.practice1.entities.ShoppingCart;
import com.practice1.entities.User;

public interface ShoppingCartService {
	ShoppingCart addItem(SanPham sp, int quantity, User customer);
	ShoppingCart updateItem(SanPham sp, int quantity, User customer);
	ShoppingCart deleteItem(SanPham sp, User customer);
	List<CartItem> getAllItem();
	

}

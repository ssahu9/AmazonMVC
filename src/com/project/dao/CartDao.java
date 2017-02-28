package com.project.dao;

import java.sql.SQLException;
import java.util.List;
import com.project.bean.Cart;
import com.project.bean.CartDetails;

public interface CartDao {
	
	//addToCart function linked to CartDaoImpl
	boolean addToCart(List<Cart> cartList) throws ClassNotFoundException, SQLException;

	//removeFromCart function linked to CartDaoImpl
	boolean removeFromCart(int productId, int customerIdt) throws ClassNotFoundException, SQLException;

	//viewCart function linked to CartDaoImpl
	List<CartDetails> viewCart(int Customer_id) throws SQLException, ClassNotFoundException;
}

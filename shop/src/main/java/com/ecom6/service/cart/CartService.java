package com.ecom6.service.cart;

import java.util.Hashtable;

import com.ecom6.VO.order.OrderVO;

public interface CartService {
	// DB 테이블 역할
	void setCartList(Hashtable<Integer, OrderVO> hCartList);

	Hashtable<Integer, OrderVO> addCart(OrderVO ovo);

	Hashtable<Integer, OrderVO> updateCart(OrderVO ovo);

	Hashtable<Integer, OrderVO> deleteCart(OrderVO ovo);

	Hashtable<Integer, OrderVO> getCartList();
}

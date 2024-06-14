package com.ecom6.service.cart;

import java.util.Hashtable;

import com.ecom6.VO.order.OrderVO;

public interface CartService {
	// DB 테이블 역할
	void setCartList(Hashtable<Integer, OrderVO> hCartList);
}

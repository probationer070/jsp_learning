package com.ecom6.service.cart;

import java.util.Hashtable;

import org.springframework.stereotype.Service;

import com.ecom6.VO.order.OrderVO;

@Service
public class CartServiceImpl implements CartService {

	// 내부에 사용할 해시테이블
	private Hashtable<Integer, OrderVO> hCartList;

	@Override
	public void setCartList(Hashtable<Integer, OrderVO> hCartList) {
		this.hCartList = hCartList;
	}
	
	
}

package com.ecom6.service.order;

import java.util.Hashtable;

import com.ecom6.VO.order.OrderVO;

public interface OrderService {

	int insertOrders(Hashtable<Integer, OrderVO> hCartList);

}

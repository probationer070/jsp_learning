package com.ecom6.service.order;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import com.ecom6.VO.order.OrderVO;

public interface OrderService {

	int insertOrders(Hashtable<Integer, OrderVO> hCartList);

	Map<String, Object> getOrders(OrderVO ovo);

	OrderVO getOrder(OrderVO ovo);

	Map<String, Object> getOrderList(OrderVO ovo);

	void orderStateUpdate(ArrayList<String> tdArr);

	int updateState(OrderVO ovo);

	int deleteOrder(OrderVO ovo);

}

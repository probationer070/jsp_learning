package com.ecom6.service.order;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom6.VO.order.OrderVO;
import com.ecom6.dao.order.OrderDao;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public int insertOrders(Hashtable<Integer, OrderVO> hCartList) {
		List<OrderVO> list = new ArrayList<OrderVO>(hCartList.keySet().size());
		for (int key : hCartList.keySet()) {
			list.add(hCartList.get(key));
		}
		return orderDao.insertOrders(list);
	}

}

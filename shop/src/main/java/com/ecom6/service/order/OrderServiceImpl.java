package com.ecom6.service.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom6.VO.order.OrderVO;
import com.ecom6.dao.order.OrderDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	
	@Transactional
	@Override
	public Map<String, Object> getOrders(OrderVO ovo) {
		Map<String, Object> reSet = new HashMap<>();
		// total
		int cnt = orderDao.getTotalOrders(ovo);
		// list
		List<OrderVO> orders = orderDao.getOrders(ovo);
		
		reSet.put("orderTot", cnt);
		reSet.put("orders", orders);
		return reSet;
	}

	@Override
	public OrderVO getOrder(OrderVO ovo) {
		List<OrderVO> list = orderDao.getOrders(ovo);
		if (list.size()>0)
			return list.get(0);
		return orderDao.getOrders(ovo).get(0);
	}

	@Override
	public Map<String, Object> getOrderList(OrderVO ovo) {
		Map<String, Object> reSet = new HashMap<>();
		
		int cnt = orderDao.getTotalOrders(null);
		List<OrderVO> orders = orderDao.getOrderList(ovo);
		log.info("OrderTot =====> "+cnt);
		reSet.put("orderTot", cnt);
		reSet.put("orders", orders);
		return reSet;
	}

}

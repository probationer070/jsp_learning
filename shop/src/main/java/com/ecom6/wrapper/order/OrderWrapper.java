package com.ecom6.wrapper.order;

import java.util.HashMap;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom6.VO.order.OrderVO;
import com.ecom6.service.order.OrderService;
import com.ecom6.service.product.ProductService;

@Service("orderWrapper")
public class OrderWrapper {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;

	@Transactional
	public HashMap<String, Object> orderProc(OrderVO ovo, 
											 Hashtable<Integer, OrderVO> hCartList) {
		
		String url;
		String msg;
		int r = orderService.insertOrders(hCartList);
		if (r>0) {
			productService.updateStocks(hCartList);
			msg = "주문완료했습니다.";
			url = "orderlist";
			hCartList.clear();
		} else {
			msg = "주문 실패.";
			url = "cartList";
		}
		HashMap<String, Object> reMap = new HashMap<>();
		reMap.put("msg", msg);
		reMap.put("url", url);
		reMap.put("hCartList", hCartList);
		
		return reMap;
	}
	
}

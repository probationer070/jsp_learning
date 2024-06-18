package com.ecom6.dao.order;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ecom6.VO.order.OrderVO;

@Mapper
public interface OrderDao {

	int insertOrders(List<OrderVO> list);

	int getTotalOrders(OrderVO ovo);

	List<OrderVO> getOrders(OrderVO ovo);

	List<OrderVO> getOrderList(OrderVO ovo);

}

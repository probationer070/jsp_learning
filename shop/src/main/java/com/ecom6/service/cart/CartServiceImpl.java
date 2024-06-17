package com.ecom6.service.cart;

import java.util.Hashtable;

import org.springframework.stereotype.Service;

import com.ecom6.VO.order.OrderVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CartServiceImpl implements CartService {

	// 내부에 사용할 해시테이블
	private Hashtable<Integer, OrderVO> hCartList;

	@Override
	public void setCartList(Hashtable<Integer, OrderVO> hCartList) {
		this.hCartList = hCartList;
	}

	@Override
	public Hashtable<Integer, OrderVO> addCart(OrderVO ovo) {
		// 상품을 추가하는데 시존 장바구니에 있으면 수량 추가
		int p_no = ovo.getP_no();
		int quantity = ovo.getQuantity();
		if(hCartList.containsKey(p_no)) {			
			OrderVO temp = (OrderVO) hCartList.get(p_no);
			quantity += temp.getQuantity();
			if(temp.getStock()<quantity) {
				// 메세지 없이 최대 수량으로 수정
				temp.setQuantity(temp.getStock());
			} else {
				temp.setQuantity(quantity);
			}
			hCartList.put(p_no, temp);
		} else {
			hCartList.put(p_no, ovo);			
		}
		//log.info("hCartList ===> : "+hCartList.get(p_no));
		return hCartList;
		
		
	}

	@Override
	public Hashtable<Integer, OrderVO> updateCart(OrderVO ovo) {
		// 상품을 추가하는데 시존 장바구니에 있으면 수량 추가
		int p_no = ovo.getP_no();
		int quantity = ovo.getQuantity();
		if(hCartList.containsKey(p_no)) {			
			OrderVO temp = (OrderVO) hCartList.get(p_no);		
			if(temp.getStock()<quantity) {
				// 메세지 없이 최대 수량으로 수정
				temp.setQuantity(temp.getStock());
			} else {
				temp.setQuantity(quantity);
			}
			hCartList.put(p_no, temp);
		} 
		return hCartList;
	}

	@Override
	public Hashtable<Integer, OrderVO> deleteCart(OrderVO ovo) {
		hCartList.remove(ovo.getP_no());
		return hCartList;
	}

	@Override
	public Hashtable<Integer, OrderVO> getCartList() {
		return hCartList;
	}
	
	
}

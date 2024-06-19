package com.ecom6.dao.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ecom6.VO.order.OrderVO;
import com.ecom6.VO.product.ProductVO;
import com.ecom6.common.vo.PageVO;

@Mapper
public interface ProductDao {

	int getProductCnt();

	List<ProductVO> getProductList(PageVO pgVo);

	int insertProduct(ProductVO pvo);

	ProductVO productDetail(int p_no);

	void updateStocks(List<OrderVO> list);

	int updateProduct(ProductVO pvo);

	int deleteProduct(ProductVO pvo);
}

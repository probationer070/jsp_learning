package com.ecom6.dao.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ecom6.VO.PageVO;
import com.ecom6.VO.product.ProductVO;

@Mapper
public interface ProductDao {

	int getProductCnt();

	List<ProductVO> getProductList(PageVO pgVo);

	int insertProduct(ProductVO pvo);

	

}

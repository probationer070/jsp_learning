package com.ecom6.service.product;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ecom6.VO.PageVO;
import com.ecom6.VO.product.ProductVO;

public interface ProductService {

	Map<String, Object> getProductsList(PageVO pgVo);

	int insertProduct(ProductVO pvo, MultipartFile file);

}

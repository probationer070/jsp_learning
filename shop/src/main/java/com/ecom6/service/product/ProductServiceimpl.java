package com.ecom6.service.product;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecom6.VO.product.ProductVO;
import com.ecom6.common.vo.PageVO;
import com.ecom6.dao.product.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceimpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Map<String, Object> getProductsList(PageVO pgVo) {
		Map<String, Object> reSet = new HashMap<String, Object>();
		int cnt = productDao.getProductCnt();
		
		// 페이지 계산로직
		
		
		List<ProductVO> productList = productDao.getProductList(pgVo);
		
		reSet.put("pcnt", cnt); 
		reSet.put("productList", productList);
		
		return reSet;
	}

	@Override
	public int insertProduct(ProductVO pvo, MultipartFile file) {
		String originalFileNm = file.getOriginalFilename();
		File destinationFile;
		if (originalFileNm==null || originalFileNm.length()==0) {
			pvo.setImage("ready.gif");
		} else {
			pvo.setImage(originalFileNm);
			destinationFile = new File(pvo.getPath()+originalFileNm);
			// 실제 파일 전송
			try {
				file.transferTo(destinationFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return productDao.insertProduct(pvo);
	}

	@Override
	public ProductVO productDetail(ProductVO pvo) {
		return productDao.productDetail(pvo.getP_no());
	}

}

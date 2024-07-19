package com.pg.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pg.service.ApiService;


@Controller
public class PgController {
	
	@Autowired
	private ApiService apiService;
	
	@RequestMapping("/")
	public String test() {
		System.out.println("컨트롤러 확인");
		return "redirect:payForm";
	}

	@RequestMapping("/payForm")
	public ModelAndView payForm() {
		
		ModelAndView mav =  new ModelAndView();
		mav.setViewName("form/payForm");
		
		return mav;
	}
	
	@RequestMapping("/payProc")
	public ModelAndView payProc(@RequestParam HashMap<String, String> param) throws NoSuchAlgorithmException {
		ModelAndView mav =  new ModelAndView();
		
//		System.out.println("trace input 내용 : "+param.toString());
//		System.out.println(param.get("cardNo"));
//		System.out.println(param.get("expireYear"));
		
		String url = "https://api.testpayup.co.kr/v2/api/payment/himedia/keyin2";
		Map<String, String> apiMap = new HashMap<String, String>();
		Map<String, Object> apiResult = new HashMap<String, Object>();
		
		String orderNumber = UUID.randomUUID().toString().substring(0,8).replace("-", "").toUpperCase();
		apiMap.put("orderNumber", orderNumber);
		
		Iterator<String> keys = param.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			apiMap.put(key, param.get(key));
		}
		
		LocalDateTime time = LocalDateTime.now();
		String Formattime = time.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		apiMap.put("timestamp", Formattime);
		apiMap.put("quota", "0");	// 할부개월
		apiMap.put("itemName", "Test");
		apiMap.put("userName", "Testor");
		String signNotEncode = "himedia|"+orderNumber+"|"+param.get("amount")+"|ac805b30517f4fd08e3e80490e559f8e|"+Formattime;
		String sign = apiService.getSHA256Hash(signNotEncode);
		apiMap.put("signature", sign);
		apiResult = apiService.JsonApi(url, apiMap);
		
		System.out.println("API 통신 값: "+apiResult);
		
		// 결과에 대해 화면을 바꿀 수 있다.
		
		// 1. 결과페이지 1개의 경우
		mav.setViewName("form/payResult");
		mav.addObject("data", apiResult);
		mav.addObject("responseMsg", apiResult.get("responseMsg"));
		
//		// 2. 분기처리
//		// PaySuccess, PayFailure
//		if ("0000".equals(apiResult.get("responseCode"))) {
//			mav.setViewName("form/paySuccess");
//		} else {
//			mav.setViewName("form/payFailure");
//		}
		
		return mav;
	}
	
	@RequestMapping("/cancelForm")
	public ModelAndView cancelForm() {
		
		ModelAndView mav =  new ModelAndView();
		mav.setViewName("form/cancelForm");
		
		return mav;
	}
	
	@RequestMapping("/payResult")
	public ModelAndView payResult() {
		
		ModelAndView mav =  new ModelAndView();
		mav.setViewName("form/payResult");
		
		return mav;
	}
	
	@RequestMapping("/cancelProc")
	public ModelAndView cancelProc(@RequestParam HashMap<String, String> param) throws NoSuchAlgorithmException {
		ModelAndView mav =  new ModelAndView();
		mav.setViewName("form/payForm");
		
		String url = "https://api.testpayup.co.kr/v2/api/payment/himedia/cancel2";
		Map<String, String> apiMap = new HashMap<String, String>();
		Map<String, Object> apiResult = new HashMap<String, Object>();
		

		apiMap.put("merchantId", "himedia");
		apiMap.put("transactionId", param.get("transactionId"));
		String signNotEncode = "himedia|"+param.get("transactionId")+"|ac805b30517f4fd08e3e80490e559f8e";
		String sign = apiService.getSHA256Hash(signNotEncode);
		apiMap.put("signature", sign);
		apiResult = apiService.JsonApi(url, apiMap);
		
		System.out.println("API 통신 값 취소요청: "+apiResult);

		return mav;
	}
	
	@RequestMapping("/orderForm")
	public ModelAndView orderForm() {
		
		ModelAndView mav =  new ModelAndView();
		mav.setViewName("form/orderForm");
		
		return mav;
	}
	
	@RequestMapping("/orderProc")
	public ModelAndView orderProc(@RequestParam HashMap<String, String> param) throws NoSuchAlgorithmException {
		ModelAndView mav =  new ModelAndView();
		mav.setViewName("form/orderProc");
		System.out.println("param CHECK : ===> "+param);
		String url = "https://api.testpayup.co.kr/ap/api/payment/himedia/order";
		Map<String, String> apiMap = new HashMap<String, String>();
		Map<String, Object> apiResult = new HashMap<String, Object>();
		

		String orderNumber = UUID.randomUUID().toString().substring(0,8).replace("-", "").toUpperCase();
		apiMap.put("orderNumber", orderNumber);
		
		// String amount = "100000";
		 String amount = param.get("amount");
		String merchantId = "himedia";
		String apiCertKey = "ac805b30517f4fd08e3e80490e559f8e";

//		apiMap.put("amount", amount);
//		apiMap.put("itemName", "Test");
//		apiMap.put("userName", "Testor");
		Iterator<String> keys = param.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			apiMap.put(key, param.get(key));
		}
		apiMap.put("userAgent", "WP");
		apiMap.put("returnUrl", "orderProc");
		
		LocalDateTime time = LocalDateTime.now();
		String Formattime = time.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		apiMap.put("timestamp", Formattime);
		
		String signNotEncode = merchantId+"|"+orderNumber+"|"+amount+"|"+apiCertKey+"|"+Formattime;
		String sign = apiService.getSHA256Hash(signNotEncode);
		apiMap.put("signature", sign);

		apiResult = apiService.JsonApi(url, apiMap);
		
		System.out.println("API 통신 주문 값: "+apiResult);
		mav.addObject("data", apiResult);
		return mav;
	}
	
	@PostMapping("/payProc2")
	public ModelAndView payProc2(@RequestParam HashMap<String, String> param) throws NoSuchAlgorithmException {
		ModelAndView mav =  new ModelAndView();
		
		System.out.println("trace input 내용 : "+param.toString());
//		System.out.println(param.get("cardNo"));
//		System.out.println(param.get("expireYear"));
		
		String url = "https://api.testpayup.co.kr/ap/api/payment/"+param.get("ordr_idxx")+"/pay";
		Map<String, String> apiMap = new HashMap<String, String>();
		Map<String, Object> apiResult = new HashMap<String, Object>();

		apiMap.put("res_cd", param.get("res_cd"));	// 할부개월
		apiMap.put("res_msg", param.get("res_msg"));	// 할부개월
		apiMap.put("enc_data", param.get("enc_data"));	// 할부개월
		apiMap.put("enc_info", param.get("enc_info"));	// 할부개월
		apiMap.put("tran_cd", param.get("tran_cd"));	// 할부개월
		apiMap.put("buyr_mail", param.get("buyr_mail"));	// 할부개월

		apiResult = apiService.JsonApi(url, apiMap);
		
		System.out.println("API 통신 값: "+apiResult);
		
		mav.setViewName("form/payResult");
		mav.addObject("data", apiResult);

		return mav;
	}
	
	@RequestMapping("/cancelForm2")
	public ModelAndView cancelForm2() {
		
		ModelAndView mav =  new ModelAndView();
		mav.setViewName("form/cancelForm2");
		
		return mav;
	}
	
	@RequestMapping("/cancelProc2")
	public ModelAndView cancelProc2(@RequestParam HashMap<String, String> param) throws NoSuchAlgorithmException {
		ModelAndView mav =  new ModelAndView();
		mav.setViewName("redirect:/orderForm");
		
		String url = "https://api.testpayup.co.kr/v2/api/payment/himedia/cancel2";
		Map<String, String> apiMap = new HashMap<String, String>();
		Map<String, Object> apiResult = new HashMap<String, Object>();
		
		String merchantId = "himedia";
		apiMap.put("merchantId", merchantId);
		apiMap.put("transactionId", param.get("transactionId"));
		String signNotEncode = merchantId+"|"+param.get("transactionId")+"|ac805b30517f4fd08e3e80490e559f8e";
		String sign = apiService.getSHA256Hash(signNotEncode);
		apiMap.put("signature", sign);
		apiResult = apiService.JsonApi(url, apiMap);
		
		System.out.println("API 통신 값 취소요청2: "+apiResult);

		return mav;
	}
	
}

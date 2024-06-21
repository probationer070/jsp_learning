package com.ecom6.service.notice;

import java.util.Map;

import com.ecom6.VO.notice.NoticeVO;
import com.ecom6.common.vo.PageVO;

public interface NoticeService {

	Map<String, Object> getNotices(NoticeVO nvo, PageVO pgvo);

}

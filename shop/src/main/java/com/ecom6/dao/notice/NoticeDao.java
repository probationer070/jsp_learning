package com.ecom6.dao.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ecom6.VO.notice.NoticeVO;
import com.ecom6.common.vo.PageVO;

@Mapper
public interface NoticeDao {


	List<NoticeVO> getNoticeList(NoticeVO nvo);

	int getNoticeCnt();

}

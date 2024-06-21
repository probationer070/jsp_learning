package com.ecom6.service.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom6.VO.notice.NoticeVO;
import com.ecom6.common.vo.PageInfo;
import com.ecom6.common.vo.PageVO;
import com.ecom6.dao.notice.NoticeDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public Map<String, Object> getNotices(NoticeVO nvo, PageVO pgVo) {
		Map<String, Object> reSet = new HashMap<String, Object>();
		// 전체 공지사항 개수
		int noticeTot = noticeDao.getNoticeCnt();
		// page 계산
		if (pgVo.getCurBlock()<=0) pgVo.setCurBlock(1);
		if (pgVo.getCurPg()<=0) pgVo.setCurPg(1);
		
		int start = (pgVo.getCurBlock()-1)*PageInfo.ROW_OF_PAGE+1;
		int end = (pgVo.getCurBlock() * PageInfo.ROW_OF_PAGE) > noticeTot ?
				noticeTot : pgVo.getCurPg()*PageInfo.ROW_OF_PAGE;
		log.info("start =====> "+start);
		log.info("end =====> "+end);
		nvo.setStart(start);
		nvo.setEnd(end);
		// 페이지 수 계산
		int pgCnt = ((noticeTot % PageInfo.ROW_OF_PAGE) == 0) ?
					(noticeTot % PageInfo.ROW_OF_PAGE) :
					(noticeTot % PageInfo.ROW_OF_PAGE)+1;
		pgVo.setPgCnt(pgCnt);
		// 페이지 블록 계산
		int blCnt = (pgCnt % PageInfo.PAGE_OF_BLOCK == 0) ?
					(pgCnt % PageInfo.PAGE_OF_BLOCK) :
					(pgCnt % PageInfo.PAGE_OF_BLOCK)+1;
		pgVo.setBlockCnt(blCnt);
		// startPg
		int startPg = (pgVo.getCurBlock()-1)*PageInfo.PAGE_OF_BLOCK+1;
		// endPg
		int endPg = pgVo.getCurBlock()*PageInfo.PAGE_OF_BLOCK > pgCnt ?
					pgCnt : pgVo.getCurBlock()*PageInfo.PAGE_OF_BLOCK;
		pgVo.setStartPage(startPg);
		pgVo.setEndPage(endPg);
		
		// noticelist
		List<NoticeVO> NoticeList = noticeDao.getNoticeList(nvo);
		
		reSet.put("pgVo", pgVo);
		reSet.put("noticeTot", noticeTot); 
		reSet.put("NoticeList", NoticeList);
		
		return reSet;
	}

}

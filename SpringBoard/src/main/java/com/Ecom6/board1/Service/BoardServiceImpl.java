package com.Ecom6.board1.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Ecom6.board1.model.PageDTO;
import com.Ecom6.board1.model.BoardDAO;
import com.Ecom6.board1.model.BoardDTO;
import com.Ecom6.board1.model.InterPginfo;

@Service(value="boardService")
public class BoardServiceImpl implements BoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public Map<String, Object> getArticles(BoardDTO bdto, PageDTO pdto) {
		
		// ������ ���������� ������ ��������
		// ������ ���
		// ��ü �� ���� ��
		int totArticle = boardDAO.getTotArticleCnt(bdto);
		int totRecordCnt = boardDAO.getTotArticleCnt(null);
		
		// ���� �������� �ް� 
		// �������� ������ ���
		logger.info(pdto.toString());
		
		int strat = ((pdto.getCurPg()-1)*InterPginfo.ROW_OF_PAGE)+1;
        int end = (pdto.getCurPg()* InterPginfo.ROW_OF_PAGE) > totArticle?		 
       		   totArticle: (pdto.getCurPg()* InterPginfo.ROW_OF_PAGE);
		 //start page, and page
		 bdto.setStart(strat);
		 bdto.setEnd(end);
		 
		// �� ������ ��
		 int pgcnt = totArticle%InterPginfo.ROW_OF_PAGE==0 ?
				     totArticle/InterPginfo.ROW_OF_PAGE: 
					 totArticle/InterPginfo.ROW_OF_PAGE+1;
		
		// �������� ��� �� -> ������ �� / ���� ������ �� �������� 0 �̸� ������ �׷��� ���� ��� +1
		 int blcnt =(pgcnt%InterPginfo.PAGE_OF_BLOCK==0)?
				     pgcnt/InterPginfo.PAGE_OF_BLOCK:
				     pgcnt/InterPginfo.PAGE_OF_BLOCK+1; 
		 int startPg =(pdto.getCurBlock()-1)*InterPginfo.PAGE_OF_BLOCK+1;
		 
		// ���� �信�� ���
		int  endpg = (pdto.getCurBlock()*InterPginfo.PAGE_OF_BLOCK)>pgcnt?
				pgcnt: pdto.getCurBlock()*InterPginfo.PAGE_OF_BLOCK; 	
			

		pdto.setPgCnt(pgcnt);	// �������� ��
		pdto.setBlockCnt(blcnt);	
		pdto.setStartPage(startPg);
		pdto.setEndPage(endpg);
		
		Map<String, Object> remap = new HashMap<String, Object>();
		List<BoardDTO> articles = boardDAO.getArticles(bdto);
		remap.put("articles", articles);
		remap.put("totArticle", totArticle);
		remap.put("pdto", pdto);
		logger.info(pdto.toString());
		
		return remap;
	}
	
	@Override
	public int writePro(BoardDTO bdto) {
		return boardDAO.writePro(bdto);
	}
	
	@Transactional
	@Override
	public BoardDTO getContent(BoardDTO bdto) {	
		boardDAO.upCount(bdto);
		return boardDAO.getContent(bdto);
	}

	@Override
	public int updatePro(BoardDTO bdto) {
		return boardDAO.updatePro(bdto);
	}

	@Override
	public int deletePro(int bno) {
		return boardDAO.deletePro(bno);
	}


}

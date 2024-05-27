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
	public Map<String, Object> getArticles(PageDTO pdto) {
		Map<String, Object> remap = new HashMap<String, Object>();
		// ������ ���������� ������ ��������
		// ������ ���
		// ��ü �� ���� ��
		int totArticle = boardDAO.getTotArticleCnt();
		
		// ���� �������� �ް� 
		// �������� ������ ���
		int start, end;
		start = (pdto.getCurPg() - 1) * InterPginfo.ROW_OF_PAGE + 1;
		end = (pdto.getCurPg() * InterPginfo.ROW_OF_PAGE) > totArticle ? 
				totArticle: (pdto.getCurPg() * InterPginfo.ROW_OF_PAGE);
		BoardDTO bdto = new BoardDTO();
		bdto.setStart(start);
		bdto.setEnd(end);
		// start page, end page
		
		// PageNav
		// �� ���ڵ�� �������� ���μ��� ������ �� ������ ��
		
		pdto.setStartPage((pdto.getCurBlock()-1)+1);
		int pgCnt = (totArticle % InterPginfo.ROW_OF_PAGE == 0) ?
				totArticle / InterPginfo.ROW_OF_PAGE: totArticle/InterPginfo.ROW_OF_PAGE+1;
		
		pdto.setPgCnt(pgCnt);	// �������� ��
		
		// �������� ��� �� -> ������ �� / ���� ������ �� �������� 0 �̸� ������ �׷��� ���� ��� +1
		int blCnt = pdto.getPgCnt() % InterPginfo.PAGE_OF_BLOCK == 0 ?
					pdto.getPgCnt() / InterPginfo.PAGE_OF_BLOCK:
					pdto.getPgCnt() / InterPginfo.PAGE_OF_BLOCK+1;
		pdto.setBlockCnt(blCnt);	// ������ �� ��
		
		if (pdto.getCurBlock() > 1) {
			// ���� ������ ���
			int endpg = (pdto.getCurBlock() * InterPginfo.PAGE_OF_BLOCK)> pdto.getPgCnt() ?
						pdto.getPgCnt() : pdto.getCurBlock() * InterPginfo.PAGE_OF_BLOCK;
					
			pdto.setEndPage(endpg);
		} else {
			pdto.setStartPage(1);
			int endpg = 1*InterPginfo.PAGE_OF_BLOCK > pdto.getPgCnt()?
					pdto.getPgCnt(): 1*InterPginfo.PAGE_OF_BLOCK;
			pdto.setEndPage(endpg);
			logger.info("endpg==> "+endpg);
		}

		List<BoardDTO> articles = boardDAO.getArticles(bdto);
		remap.put("articles", articles);
		remap.put("totArticle", totArticle);
		remap.put("pdto", pdto);
		return remap;
	}
	
	@Transactional
	@Override
	public int writePro(BoardDTO bdto) {
		return boardDAO.writePro(bdto);
	}

	@Override
	public BoardDTO getContent(int bno) {
		return boardDAO.getContent(bno);
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

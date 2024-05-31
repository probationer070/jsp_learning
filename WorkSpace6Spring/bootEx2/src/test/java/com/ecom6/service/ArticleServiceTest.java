package com.ecom6.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecom6.dto.ArticleForm;
import com.ecom6.entity.Article;

import jakarta.transaction.Transactional;

@SpringBootTest
class ArticleServiceTest {
	
	@Autowired
	ArticleService articleService;
	
	@Test
	@Transactional
	void testIndex() {
		// 예상 데이터
		Article a = new Article(1L, "가가가가", "1111");
		Article b = new Article(2L, "나나나나", "2222");
		Article c = new Article(3L, "다다다다", "3333");
		Article d = new Article(4L, "당신의 인생 영화는?", "댓글 고");
		Article e = new Article(5L, "당신의 소울 푸드는?", "댓글 고고");
		Article f = new Article(6L, "당신의 취미는?", "댓글 고고고");
		List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c, d, e, f));
		// 실제 데이터
		List<Article> articles = articleService.index();
		System.err.println(expected.toString());
		System.err.println(articles.toString());
		
		// 비교 및 검증
		assertEquals(expected.toString(), articles.toString());
	}

	@Test
	@Transactional
	void testShow_success() {	// 성공 존재하는 id 입력
		Long id = 1L;
		Article expected = new Article(id, "가가가가", "1111");
		Article article = articleService.show(id);
		assertEquals(expected.toString(), article.toString());
	}

	@Test
	@Transactional
	void testShow_failed() {	// 실패 존재하지 않는 id 입력
		Long id = -1L;
		Article expected = null;
		Article article = articleService.show(id);
		assertEquals(expected, article);
	}

	@Test
	@Transactional
	void testCreate_success() {	// 성공 title 과 content만 입력
		String title = "라라라라";
		String content = "4444";
		Article dto = new Article(null, title, content);
		Article expected = new Article(7L, title, content);
		Article article = articleService.create(dto);
		System.err.println(expected.toString());
		System.err.println(article.toString());
		assertEquals(expected.toString(), article.toString());
		
	}
	
	@Test
	@Transactional
	void testCreate_failed() {
		Long id = 4L;
		String title = "라라라라";
		String content = "4444";
		Article dto = new Article(id, title, content);
		Article expected = null;
		Article article = articleService.create(dto);
		assertEquals(expected, article);
	}
	
	// 13장 셀프체크 1. update()를 성공한 경우 1
    @Test
    @Transactional
    void update_success1() {
        // 예상 데이터
        Long id = 1L;
        String title = "가나다라";
        String content = "1234";
//        Article dto = new Article(id, title, content);
        Article expected = new Article(id, title, content);
        // 실제 데이터
        Article article = articleService.update(id, expected);
        // 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }


    // 13장 셀프체크 3. update()를 실패한 경우 1
    @Test
    @Transactional
    void update_failed() {
        // 예상 데이터
        Long id = -1L;
        String title = "가나다라";
        String content = "1234";
        Article dto = new Article(id, title, content);
        Article expected = null;
        // 실제 데이터
        Article article = articleService.update(id, dto);
        // 비교 및 검증
        assertEquals(expected, article);
    }

    // 13장 셀프체크 4. delete()를 성공한 경우
    @Test
    @Transactional
    void delete_sucess() {
        // 예상 데이터
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");
        // 실제 데이터
        Article article = articleService.delete(id);
        // 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }

    // 13장 셀프체크 5. delete()를 실패한 경우
    @Test
    @Transactional
    void delete_failed() {
        // 예상 데이터
        Long id = -1L;
        Article expected = null;
        // 실제 데이터
        Article article = articleService.delete(id);
        // 비교 및 검증
        assertEquals(expected, article);
    }

}

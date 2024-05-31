package com.ecom6.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom6.controller.ArticleController;
import com.ecom6.dto.ArticleForm;
import com.ecom6.entity.Article;
import com.ecom6.repository.ArticleRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ArticleService {
	
	// private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	private ArticleRepository articleRepository;

	public List<Article> index() {
		return (List<Article>) articleRepository.findAll();
	}

	public Article show(Long id) {
		return articleRepository.findById(id).orElse(null);
	}

	public Article create(Article article) {
		// Article article = article2.toEntity();
		if (article.getId() != null) 
			return null;
		return articleRepository.save(article);
	}
	
	@SuppressWarnings("unlikely-arg-true")
	public Article update(Long id, Article article) {
		//Article article = dto.toEntity();
		//logger.info("id: {}, article: {}", id, article.toString());
		
		Article target = articleRepository.findById(id).orElse(null);
		if (target == null || !id.equals(article.getId())) {
			log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
			return null;
		}
		target.patch(article);
		Article updated = articleRepository.save(target);
		return updated;
	}

	public Article delete(Long id) {
		Article target = articleRepository.findById(id).orElse(null);
		if (target == null) 
			return null;
		articleRepository.delete(target);
		return target;
	}
	
	@Transactional
	public List<Article> createArticles(List<Article> articles) {
		// dto 묶음을 엔티티 묶음
//		List<Article> articleList = articles.stream()
//				.map(dto -> dto.toEntity())
//				.collect(Collectors.toList());
		// Entity 묶음을 DB 에 저장
		articles.stream()
			.forEach(article -> articleRepository.save(article));
		// 강제 예외 발생시키기
		articleRepository.findById(-1L)
			.orElseThrow(() -> new IllegalArgumentException("결제 실패"));
		// 결과 값 반환
		return articles;
	}

}

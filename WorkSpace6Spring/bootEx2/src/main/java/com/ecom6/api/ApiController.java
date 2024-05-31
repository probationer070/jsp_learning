package com.ecom6.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom6.controller.ArticleController;
import com.ecom6.dto.ArticleForm;
import com.ecom6.entity.Article;
import com.ecom6.repository.ArticleRepository;
import com.ecom6.service.ArticleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ApiController {
	
	// private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ArticleRepository articleRepository;

//	// GET
//	@GetMapping("/api/articles")
//	public List<Article> index() {
//		return (List<Article>) articleRepository.findAll();
//	}
	@GetMapping("/api/articles")
	public List<Article> index() {
		return articleService.index();
	}
	
//	@GetMapping("/api/articles/{id}")
//	public Article show(@PathVariable("id") Long id) {
//		return articleRepository.findById(id).orElse(null);
//	}
	
	@GetMapping("/api/articles/{id}")
	public Article show(@PathVariable("id") Long id) {
		return articleService.show(id);
	}
	
//	
//	// POST
//	@PostMapping("/api/articles")
//	public Article create(@RequestBody ArticleForm dto) {
//		Article article = dto.toEntity();
//		return articleRepository.save(article);
//	}

	@PostMapping("/api/articles")
	public ResponseEntity<Article> create(@RequestBody Article article) {
		Article created = articleService.create(article);
		return (created != null) ?
				ResponseEntity.status(HttpStatus.OK).body(created) :
				ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
 
//	// PATCH
//	@PatchMapping("/api/articles/{id}")
//	public ResponseEntity<Article> update(@PathVariable("id") Long id,
//						  @RequestBody ArticleForm dto) {
//		// DTO -> Entity 변환
//		Article article = dto.toEntity();
//		logger.info("id: {}, article: {}", id, article.toString());
//		// target 조회
//		Article target = articleRepository.findById(id).orElse(null);
//		// 잘못된 요청 처리
//		if (target == null || id != article.getId()) {
//			logger.info("잘못된 요청! id: {}, article: {}", id, article.toString());
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//		}
//		// update 및 정상 응답(200)으로 출력
//		target.patch(article);
//		Article updated = articleRepository.save(article);
//		return ResponseEntity.status(HttpStatus.OK).body(updated);
//	}
	
	@PatchMapping("/api/articles/{id}")
	public ResponseEntity<Article> update(@PathVariable("id") Long id,
			  @RequestBody Article article) {
		// Article updated = articleService.update(id, dto);
		Article updated = articleService.update(id, article);
		return (updated != null) ?
				ResponseEntity.status(HttpStatus.OK).body(updated) :
				ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	
	//	
//	// DELETE
//	@DeleteMapping("api/articles/{id}")
//	public ResponseEntity<Article> delete(@PathVariable("id") Long id) {
//		// 대상 찾기
//		Article target = articleRepository.findById(id).orElse(null);
//		// 잘못된 요청 처리
//		if (target == null) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//		}
//		// 대상 삭제
//		articleRepository.delete(target);
//		return ResponseEntity.status(HttpStatus.OK).build();
//	}
	
	@DeleteMapping("api/articles/{id}")
	public ResponseEntity<Article> delete(@PathVariable("id") Long id) {
		Article deleted = articleService.delete(id);
		return (deleted != null) ?
				ResponseEntity.status(HttpStatus.OK).body(null) :
				ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PostMapping("api/transaction-test")
	public ResponseEntity<List<Article>> transactionTest
		(@RequestBody List<Article> articles) {
		List<Article> createdList = articleService.createArticles(articles);
		return (createdList != null) ?
				ResponseEntity.status(HttpStatus.OK).body(null) :
				ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}

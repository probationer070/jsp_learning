package com.ecom6.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecom6.dto.ArticleForm;
import com.ecom6.dto.CommentDto;
import com.ecom6.entity.Article;
import com.ecom6.repository.ArticleRepository;
import com.ecom6.service.CommentService;


@Controller
public class ArticleController {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired	// DI
	private ArticleRepository articleRepository;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/articles/new")
	public String newArticleForm() {
		return "articles/new";
	}

	@PostMapping("/articles/create")
	public String createArticle(ArticleForm form) {
		logger.info(form.toString());
		// DTO를 Entity 로 변환
		Article article = form.toEntity();
		logger.info(article.toString());
		// Repository 로 Entity 를 DB 에 저장
		Article saved = articleRepository.save(article);
		logger.info(saved.toString());
		return "redirect:/articles/"+saved.getId();
	}
	
	@GetMapping("/articles/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		// logger.info("id =>" + id);
		// id 를 조회해 데이터 가져오기
		// Optional<Article> articleEntity = articleRepository.findById(id);
		Article articleEntity = articleRepository.findById(id).orElse(null);
		List<CommentDto> commentsDtos = commentService.comments(id);
		// 모델에 데이터 등록하기
		model.addAttribute("article", articleEntity);
		model.addAttribute("commentDtos", commentsDtos);
		// 뷰 페이지 반환
		return "articles/show";
	}
	
	@GetMapping("/articles")
	public String index(Model model) {
		// 모든 데이터 가져오기
		
		List<Article> articleEntityList = (List<Article>) articleRepository.findAll();
		// Iterable<Article> articleEntityList = articleRepository.findAll();
		// 모델에 데이터 등록
		model.addAttribute("articleList", articleEntityList);
		// 뷰 페이지 설정
		return "articles/index";
	}
	
	@GetMapping("/articles/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		// 수정할 데이터 가져오기
		Article articleEntity = articleRepository.findById(id).orElse(null);
		// 모델에 데이터 등록
		model.addAttribute("article", articleEntity);
		// 뷰 페이지 수정
		return "articles/edit";
	}
	
	@PostMapping("/articles/update")
	public String update(ArticleForm form, Article atiy) {
		// 수정할 데이터 가져오기
		// Article articleEntity = form.toEntity();
		atiy = form.toEntity();
		// logger.info(articleEntity.toString());
		logger.info("atiy ==> "+atiy.getId());
		// DB 서 기존 데이터 가져오기
		Article target = articleRepository.findById(atiy.getId()).orElse(null);
		// 기존 데이터 값 갱신
		if (target != null) {
			articleRepository.save(atiy);
		}
		return "redirect:/articles/" + atiy.getId();
	}
	
	@GetMapping("/articles/{id}/delete")
	public String delete(@PathVariable("id") Long id, RedirectAttributes rttr) {
		// logger.info("삭제 요청");
		// 삭제할 대상 가져오기
		Article target = articleRepository.findById(id).orElse(null);
		// logger.info(target.toString());
		// 대상 엔티티 삭제
		if (target != null) {
			articleRepository.delete(target);
			rttr.addFlashAttribute("msg", "삭제되었습니다.");
		}
		// 결과 페이지 Redirect
		
		return "redirect:/articles";
	}
}

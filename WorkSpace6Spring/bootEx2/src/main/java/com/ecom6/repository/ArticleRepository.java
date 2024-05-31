package com.ecom6.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.ecom6.entity.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {
	@Override
	ArrayList<Article> findAll();	// Iterable -> ArrayList 수정
}

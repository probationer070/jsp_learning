package com.ecom6.dto;

import com.ecom6.entity.Article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ArticleForm {
	private Long id;
	private String title;
	private String content;

	public Article toEntity() {
		return new Article(id, title, content);
	}
}

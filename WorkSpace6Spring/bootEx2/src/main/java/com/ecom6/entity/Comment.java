package com.ecom6.entity;

import com.ecom6.dto.CommentDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "article_id")
	private Article article;
	@Column
	private String nickname;
	@Column
	private String body;
	
	public static Comment createComment(CommentDto dto, Article article) {

		if (dto.getId() != null) 
			throw new IllegalArgumentException("댓글 생성 실패! 댓글의 id가 없어야 합니다");
		if (dto.getArticleId() != article.getId())
			throw new IllegalArgumentException("댓글 생성 실패! 게시글의 id가 잘못됐습니다 "+ dto.getArticleId() +"/"+ dto.getId());
		
		return new Comment(
				dto.getId(),
				article,
				dto.getNickname(),
				dto.getBody()
		);
	}

	public void patch(CommentDto dto) {
		// 예외 발생
		if (this.id != dto.getId())
			throw new IllegalArgumentException("댓글 생성 실패! 잘못된 id가 입력됐습니다.");
		// 객체 갱신
		if (dto.getNickname() != null)
			this.nickname = dto.getNickname();
		if (dto.getBody() != null)
			this.body = dto.getBody();
	}
}

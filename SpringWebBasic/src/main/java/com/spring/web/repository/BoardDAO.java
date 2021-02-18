package com.spring.web.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.web.model.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {

	//게시글을 저장할 리스트 : DB대용
	private List<BoardVO> articles = new ArrayList<BoardVO>();
	
	
	@Override
	public List<BoardVO> getArticles() {
		return articles;
	}

	@Override
	public void insertArticle(BoardVO article) {
		articles.add(article);
	}

	@Override
	public void deleteArticle(int index) {
		articles.remove(index);
	}

	@Override
	public BoardVO getArticle(int index) {
		return articles.get(index);
	}

	@Override
	public void updateArticle(BoardVO article,int index) {
		//수정하는 메서드는 set()
		articles.set(index, article);
	}

}

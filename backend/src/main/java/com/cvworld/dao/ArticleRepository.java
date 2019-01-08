package com.cvworld.dao;

import com.cvworld.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository <Article,Integer> {

}

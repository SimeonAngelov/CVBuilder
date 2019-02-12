package com.cvworld.dao;

import com.cvworld.model.CvResources;
import org.springframework.data.repository.CrudRepository;

public interface CvRepo extends CrudRepository<CvResources,Integer> {
}

package com.cvworld.dao;

import com.cvworld.model.BasicProfileInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicProfileInfoRepo  extends CrudRepository<BasicProfileInfo,String> {
}

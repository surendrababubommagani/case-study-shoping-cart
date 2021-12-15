package com.casestudy.catalogservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.catalogservice.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer>{

	Object findByName(String string);

}

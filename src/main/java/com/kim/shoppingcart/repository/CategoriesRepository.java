package com.kim.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kim.shoppingcart.model.Categories;

@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
public interface CategoriesRepository extends JpaRepository<Categories, Long> {

}

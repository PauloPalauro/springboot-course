package com.palauro.coursespring.Repository;

import com.palauro.coursespring.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {


}
package com.capstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}

package com.yj.todo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yj.todo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	Page<Todo> findAll(Specification<Todo> spec,Pageable pageable);
}

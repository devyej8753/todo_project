package com.yj.todo.specification;

import org.springframework.data.jpa.domain.Specification;

import com.yj.todo.entity.Todo;

public class TodoSpecification {

	public static Specification<Todo> todoContentContains(String keyword) {
	    return (root, query, criteriaBuilder) -> {
	        if (keyword == null || keyword.isEmpty()) {
	            return criteriaBuilder.conjunction();
	        }
	        return criteriaBuilder.like(root.get("todoContent"), "%" + keyword + "%");
	    };
	}

}

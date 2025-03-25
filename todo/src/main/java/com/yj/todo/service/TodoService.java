package com.yj.todo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.yj.todo.dto.PageDto;
import com.yj.todo.dto.SearchDto;
import com.yj.todo.dto.TodoDto;
import com.yj.todo.entity.Todo;
import com.yj.todo.repository.TodoRepository;
import com.yj.todo.specification.TodoSpecification;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class TodoService {
	
	private final TodoRepository repository;
	
	public int createTodo(TodoDto dto) {
		int result = 0;
		try {
			Todo entity = dto.toEntity();
			Todo saved = repository.save(entity);
			
			Long todoNo = saved.getTodoNo();
			
			dto.setTodo_no(todoNo);
			
			result = 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Page<Todo> selectTodoAll(SearchDto searchDto, PageDto pageDto) {
		Pageable pageable = PageRequest.of(pageDto.getNowPage() -1, pageDto.getNumPerPage());
		Specification<Todo> spec = (root,query,criteriaBuilder)->null;
		
		if(searchDto.getSearch_text() == null) {
			searchDto.setSearch_text(null);
		}
		spec = spec.and(TodoSpecification.todoContentContains(searchDto.getSearch_text()));
		
		Page<Todo> list = repository.findAll(spec, pageable);
		return list;
		
	}

	public int deleteTodo(Long id) {
		int result = 0;
		try {
			Todo target = repository.findById(id).orElse(null);
			if(target != null) {
				repository.deleteById(id);
			}
			result = 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updateTodo(Long id) {
		int result = 0;
		try {
			Todo target = repository.findById(id).orElse(null);
			if(target.getTodoFlag().equals("Y")) {
				target.setTodoFlag("N");
			}else {
				target.setTodoFlag("Y");
			}
			if(target != null) {
				repository.save(target);
			}
			result = 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}

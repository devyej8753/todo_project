package com.yj.todo.service;

import org.springframework.stereotype.Service;

import com.yj.todo.dto.TodoDto;
import com.yj.todo.entity.Todo;
import com.yj.todo.repository.TodoRepository;

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

}

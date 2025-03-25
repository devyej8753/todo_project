package com.yj.todo.dto;

import com.yj.todo.entity.Todo;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name="todo")
public class TodoDto {
	
	private Long todo_no;
	private String todo_content;
	private String todo_flag = "N";
	
	public Todo toEntity() {
		return Todo.builder()
					.todoNo(todo_no)
					.todoContent(todo_content)
					.todoFlag(todo_flag)
					.build();
	}
	public TodoDto toDto(Todo Todo) {
		return TodoDto.builder()
						.todo_no(Todo.getTodoNo())
						.todo_content(Todo.getTodoContent())
						.todo_flag(Todo.getTodoFlag())
						.build();
	}
	
	
}

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
	
	private Long no;
	private String content;
	private String flag;
	
	public Todo toEntity() {
		return Todo.builder()
					.content(content)
					.flag(flag)
					.build();
	}
	public TodoDto toDto(Todo Todo) {
		return TodoDto.builder()
						.no(Todo.getNo())
						.content(Todo.getContent())
						.build();
	}
	
	
}

package com.yj.todo.dto;

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
	private String todo_flag;
	
	
	
	
}

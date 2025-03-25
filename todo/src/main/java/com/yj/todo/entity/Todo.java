package com.yj.todo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="todo")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="todo_no")
	private Long todoNo;
	
	@Column(name="todo_content")
	private String todoContent;
	
	@Column(name="todo_flag")
	private String todoFlag;
	
}

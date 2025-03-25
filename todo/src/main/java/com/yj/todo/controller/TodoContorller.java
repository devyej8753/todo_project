package com.yj.todo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.todo.dto.TodoDto;
import com.yj.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodoContorller {
	
	private final TodoService service;
	
	@GetMapping({"","/"})
	public String todolist() {
		return "todolist";
	}
//	@GetMapping("/Todolist")
//	public String selectTodoAll(Model model) {
//		
//		
//		model.addAttribute("todoList",)
// }
	@GetMapping("/todo")
	public String createTodoView() {
		return "/todolist";
	}
	@PostMapping("/todo")
	@ResponseBody
	public Map<String,String> createTodoApi(TodoDto dto){
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("res_code", "500");
		resultMap.put("res_msg", "할일 등록중 오류가 발생했습니다");
		
		int result = service.createTodo(dto);
		if(result > 0) {
			resultMap.put("res_code", "200");
			resultMap.put("res_msg", "정상적으로 할일이 등록되었습니다.");
		}
		return resultMap;
	}
	
}

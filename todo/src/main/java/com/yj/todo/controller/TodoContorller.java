package com.yj.todo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.todo.dto.PageDto;
import com.yj.todo.dto.SearchDto;
import com.yj.todo.dto.TodoDto;
import com.yj.todo.entity.Todo;
import com.yj.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodoContorller {
	
	private final TodoService service;
	
	
	@GetMapping({"","/"})
	public String selectTodoAll(Model model ,SearchDto searchDto ,PageDto pageDto) {
		
		if(pageDto.getNowPage() == 0) pageDto.setNowPage(1);
		
		Page<Todo> resultList = service.selectTodoAll(searchDto,pageDto);
		
//		if(resultList.isEmpty()) {
//			resultList = null;
//		}
		
		pageDto.setTotalPage(resultList.getTotalPages());
		
		
		model.addAttribute("todoList",resultList.getContent());
		model.addAttribute("searchDto",searchDto);
		model.addAttribute("pageDto",pageDto);
		return "todolist";
	}
	
	@PostMapping("/todo/create")
	@ResponseBody
	public Map<String,String> createTodoApi(TodoDto dto){
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("res_code", "500");
		resultMap.put("res_msg", "할일 등록중 오류가 발생했습니다");
		
		Todo result = service.createTodo(dto);
		if(result != null) {
			resultMap.put("res_code", "200");
			resultMap.put("res_msg", "정상적으로 할일이 등록되었습니다.");
		}
		return resultMap;
	}
	
	@DeleteMapping("/todo/{id}")
	@ResponseBody
	public Map<String,String> deleteTodoApi(@PathVariable("id") Long id){
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("res_code", "500");
		resultMap.put("res_msg", "할일 삭제중 문제가 발생했습니다.");
		int result = service.deleteTodo(id);
		if(result > 0) {
			resultMap.put("res_code", "200");
			resultMap.put("res_msg", "정상적으로 할일을 삭제했습니다.");
	}
		return resultMap;
	}
	
	@PostMapping("/todo/{id}")
	@ResponseBody
	public Map<String,String> updateTodoAPi(@PathVariable("id") Long id){
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("res_code", "500");
		resultMap.put("res_msg", "할일 완료 여부 수정실패");
		int result = service.updateTodo(id);
		if(result > 0) {
			resultMap.put("res_code", "200");
			resultMap.put("res_msg", "정상적으로 할일을 마무리했습니다.");
	}
		return resultMap;
	}

}

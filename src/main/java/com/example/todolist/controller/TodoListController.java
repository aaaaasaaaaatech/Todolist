package com.example.todolist.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor // ②
public class TodoListController {
	private final TodoRepository todoRepository; // ①

	@GetMapping("/todo")
	public ModelAndView showTodoList(ModelAndView mv) {
		// 一覧を検索して表示する
		mv.setViewName("todoList");
		List<Todo> todoList = todoRepository.findAll(); // ③
		mv.addObject("todoList", todoList); // ④
		return mv;
	}
}

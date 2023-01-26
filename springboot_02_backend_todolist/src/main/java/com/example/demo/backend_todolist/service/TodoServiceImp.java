package com.example.demo.backend_todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.backend_todolist.dao.TodoDAO;
import com.example.demo.backend_todolist.dto.TodoDTO;

@Service
public class TodoServiceImp implements TodoServerice {
	
	@Autowired
	private TodoDAO todoDAO;
	
	public TodoServiceImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<TodoDTO> search() throws Exception {
		// TODO Auto-generated method stub
		return todoDAO.getTodoList();
	}

	@Override
	   public int insert(TodoDTO dto) throws Exception {
	      return todoDAO.insertTodoList(dto);
	   }

	@Override
	public int update(TodoDTO dto ) throws Exception {
		// TODO Auto-generated method stub
		return todoDAO.updateTodoList(dto);
	}

	@Override
	public int delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return todoDAO.deletTodoList(id);
	}
	
	
}

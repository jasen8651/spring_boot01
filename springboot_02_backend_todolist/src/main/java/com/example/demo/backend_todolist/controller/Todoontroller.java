package com.example.demo.backend_todolist.controller;


import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.backend_todolist.dto.TodoDTO;
import com.example.demo.backend_todolist.service.TodoServerice;
//스픵부트 데이터베이스 ㄷ아아아아앚대재재재재
//@RequiredArgsConstructor =@Controller + @ResponseBody
// http://localhost:8090/todo/all

//@CrossOrigin("*")
@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class Todoontroller {
	
	@Autowired
	private TodoServerice todoServerice;
	
	public Todoontroller() {
		System.out.println("controller");
	}
	
	//@ResponseBody
	@GetMapping("/todo/all")
	public List<TodoDTO> getList() throws Exception{
		System.out.println("all");
		return todoServerice.search();
	}
	// http://localhost:8090/todo
	@PostMapping("/todo")
	public ResponseEntity<Object> postTodo(@RequestBody TodoDTO dto) throws Exception{
		System.out.println(dto.getTodoname());
		int chk = todoServerice.insert(dto);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		HashMap<String, String> map = new  HashMap<>();
		map.put("createDate", new Date().toString());
		map.put("message", "insert ok");
		
		if(chk>=1) {
			//return new ResponseEntity<Object>(headers,HttpStatus.OK);
			return new ResponseEntity<Object>(HttpStatus.OK);
			//return new ResponseEntity<Object>(map, headers, HttpStatus.OK);
			//return new ResponseEntity<Object>(map, HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@PutMapping("/todo/{id}/{completed}")
	public void putTodo(@PathVariable("id") int id, @PathVariable("completed") int completed) throws Exception{
		//update
		System.out.printf("id= %d, completed=%d\n", id, completed);
		TodoDTO dto = new TodoDTO();
		dto.setId(id);
		dto.setCompleted(completed==0 ? 1 :0);
		todoServerice.update(dto);
	}
	//http://localhost:8090/todo/1
	@DeleteMapping("/todo/{id}")
	public void deleteTodo(@PathVariable("id") int id) throws Exception{
		System.out.println("id :"+ id);
		todoServerice.delete(id);
	}
}

package com.example.demo.backend_todolist.dto;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//@Data: @Getter,@Setter,@ToString @tostring, @EqualsAndHashCode@requestdarguscontructor을 합쳐 놓은 이노테이션이다.

public class TodoDTO {
	private int id;
	private int completed;
	private String todoname;
}

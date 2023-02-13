package com.ycopp.todo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.ycopp.todo.controller.HelloWorldController;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloWorldController.class)
class TodoApplicationTests {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	void return_hello() throws Exception {
		String helloWorld = "Hello World";
		
		mvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(content().string(helloWorld));
	}

}

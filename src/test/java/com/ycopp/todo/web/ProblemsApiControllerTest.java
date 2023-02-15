package com.ycopp.todo.web;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ycopp.todo.domain.problems.Problems;
import com.ycopp.todo.domain.problems.ProblemsRepository;
import com.ycopp.todo.web.dto.ProblemsSaveRequestDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProblemsApiControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	ProblemsRepository problemsRepository;

	@AfterEach
	public void tearDown() throws Exception {
		problemsRepository.deleteAll();
	}

	@Test
	public void register_Problems() {
		//given
		String title = "문제이름";
		Long problemNum = 9229L;

		ProblemsSaveRequestDto requestDto = ProblemsSaveRequestDto.builder().title(title).problemNum(problemNum)
				.build();
		
		String url = "http://localhost:" + port + "/api/v1/problems";
		
		//when
		ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
		
		//then
		
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isGreaterThan(0L);
		
		List<Problems> all = problemsRepository.findAll();

		Problems problems = all.get(0);
		assertThat(problems.getTitle()).isEqualTo(title);
		assertThat(problems.getProblemNum()).isEqualTo(problemNum);

	}
}

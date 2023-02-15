package com.ycopp.todo.domain.problems;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProblemsRepositoryTest {

	@Autowired
	ProblemsRepository problemsRepository;

	@Test
	public void save_load_problem() {
		String title = "문제이름";
		Long problemNum = 9229L;

		problemsRepository.save(Problems.builder().title(title).problemNum(problemNum).build());

		List<Problems> problemsList = problemsRepository.findAll();

		Problems problems = problemsList.get(0);
		assertThat(problems.getTitle()).isEqualTo(title);
		assertThat(problems.getProblemNum()).isEqualTo(problemNum);
//		assertThat(problems.getSolved()).isEqualTo(0);
//		assertThat(problems.getId()).isEqualTo(0);

	}
}

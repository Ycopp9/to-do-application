package com.ycopp.todo.web.dto;

import com.ycopp.todo.domain.problems.Problems;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProblemsSaveRequestDto {
	private String title;
	private Long problemNum;

	@Builder
	public ProblemsSaveRequestDto(String title, Long problemNum) {
		this.title = title;
		this.problemNum = problemNum;
	}

	public Problems toEntity() {
		return Problems.builder().title(title).problemNum(problemNum).build();
	}
}

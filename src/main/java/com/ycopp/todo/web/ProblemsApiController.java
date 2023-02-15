package com.ycopp.todo.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ycopp.todo.service.problems.ProblemsService;
import com.ycopp.todo.web.dto.ProblemsSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProblemsApiController {
	private final ProblemsService problemsService;
	
	@PostMapping("/api/v1/problems")
	public Long save(@RequestBody ProblemsSaveRequestDto requestDto) {
		return problemsService.save(requestDto);
	}
}

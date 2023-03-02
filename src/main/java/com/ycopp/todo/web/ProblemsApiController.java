package com.ycopp.todo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ycopp.todo.service.problems.ProblemsService;
import com.ycopp.todo.web.dto.ProblemsSaveRequestDto;
import com.ycopp.todo.web.dto.ProblemsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProblemsApiController {
	private final ProblemsService problemsService;

	@PostMapping("/api/v1/problems")
	public Long save(@RequestBody ProblemsSaveRequestDto requestDto) {
		return problemsService.save(requestDto);
	}

	@PutMapping("/api/v1/problems/{id}")
	public Long update(@PathVariable Long id, @RequestBody ProblemsUpdateRequestDto requestDto) {
		return problemsService.update(id, requestDto);
	}
}

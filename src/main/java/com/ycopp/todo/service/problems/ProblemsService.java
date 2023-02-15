package com.ycopp.todo.service.problems;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ycopp.todo.domain.problems.ProblemsRepository;
import com.ycopp.todo.web.dto.ProblemsSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProblemsService {
	private final ProblemsRepository problemsRepository;
	
	@Transactional
	public Long save(ProblemsSaveRequestDto requestDto) {
		return problemsRepository.save(requestDto.toEntity()).getId();
	}
}

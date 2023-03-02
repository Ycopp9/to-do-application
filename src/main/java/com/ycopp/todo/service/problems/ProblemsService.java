package com.ycopp.todo.service.problems;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ycopp.todo.domain.problems.Problems;
import com.ycopp.todo.domain.problems.ProblemsRepository;
import com.ycopp.todo.web.dto.ProblemsSaveRequestDto;
import com.ycopp.todo.web.dto.ProblemsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProblemsService {
	private final ProblemsRepository problemsRepository;
	
	@Transactional
	public Long save(ProblemsSaveRequestDto requestDto) {
		return problemsRepository.save(requestDto.toEntity()).getId();
	}
	
	@Transactional
	public Long update(Long id, ProblemsUpdateRequestDto requestDto) {
		Problems problems = problemsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException());
		problems.update(requestDto.getTitle(), requestDto.getSolved());
		return id;
	}
}

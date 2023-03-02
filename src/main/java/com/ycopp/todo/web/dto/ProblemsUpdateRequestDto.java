package com.ycopp.todo.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProblemsUpdateRequestDto {
	private String title;
	private Integer solved;
	
	@Builder
	public ProblemsUpdateRequestDto(String title, Integer solved) {
		this.title = title;
		this.solved = solved;
	}
}

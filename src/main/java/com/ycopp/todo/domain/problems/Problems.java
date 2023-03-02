package com.ycopp.todo.domain.problems;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Problems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(nullable = false)
	private Long problemNum;
	
	@Column
	@ColumnDefault("0")
	private Integer solved;
	
	@Builder
	public Problems(String title, Long problemNum) {
		this.title = title;
		this.problemNum = problemNum;
	}
	
	
	public void update(String title, Integer solved) {
		this.title = title;
		this.solved = solved;
	}
}

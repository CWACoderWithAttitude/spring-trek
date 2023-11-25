package io.github.cwacoderwithattitude.crud;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String passportNumber;

	public Student(String name, String passportNumber) {
		this.name = name;
		this.passportNumber = passportNumber;
	}

	public Student() {

	}
}
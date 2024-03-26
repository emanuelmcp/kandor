package io.github.com.dto.staff;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CreateJobDTO implements Serializable {
	private String id;
	private String name;
	private String description;
}

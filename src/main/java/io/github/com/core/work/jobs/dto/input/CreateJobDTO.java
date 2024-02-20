package io.github.com.core.work.jobs.dto.input;

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

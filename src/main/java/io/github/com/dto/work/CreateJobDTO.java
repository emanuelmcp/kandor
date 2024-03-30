package io.github.com.dto.work;

import io.github.com.dto.work.ActionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
public class CreateJobDTO implements Serializable {
	private String id;
	private String name;
	private String description;
	private Map<String, ActionDTO> actions;
}

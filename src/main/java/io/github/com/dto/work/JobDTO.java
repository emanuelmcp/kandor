package io.github.com.dto.work;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class JobDTO {
	private String id;
	private String name;
	private String description;
	private Map<String, ActionDTO> actions;
}

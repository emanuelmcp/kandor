package io.github.com.dto.work;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ActionDTO {
	private String description;
	private Set<AffectedDTO> affected;
}

package io.github.com.core.work.skills.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class SkillDTO implements Serializable {
	String id;
	String name;
	String description;
	Double health;
	Boolean backpack;
	Double movementSpeed;
}

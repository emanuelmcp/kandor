package io.github.com.dto.work;

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

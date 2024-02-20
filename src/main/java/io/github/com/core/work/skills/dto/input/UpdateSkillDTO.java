package io.github.com.core.work.skills.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UpdateSkillDTO implements Serializable {
	String name;
	String description;
	Double health;
	Boolean backpack;
	Double movementSpeed;
}

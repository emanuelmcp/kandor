package io.github.com.dto.work;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CreateSkillDTO implements Serializable {
	String name;
	String description;
	Double health;
	Boolean backpack;
	Double movementSpeed;
}

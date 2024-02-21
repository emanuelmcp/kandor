package io.github.com.entities.skills;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "skill")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
	@Id
	String id;
	@Indexed(unique = true)
	String name;
	String description;
	Double health;
	Boolean backpack;
	Double movementSpeed;
	Set<String> jobs = new HashSet<>();
}

package io.github.com.repositories;

import io.github.com.entities.skills.Skill;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SkillRepository extends MongoRepository<Skill, String> {
	Optional<Skill> findByName(String name);
	void deleteByName(String name);
}

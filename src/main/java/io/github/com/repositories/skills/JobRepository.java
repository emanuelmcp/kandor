package io.github.com.repositories.skills;

import io.github.com.entities.skills.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface JobRepository extends MongoRepository<Job, String> {
	Optional<Job> findByName(String jobName);
	void deleteByName(String jobName);
}

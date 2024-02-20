package io.github.com.core.work.jobs.services;

import io.github.com.common.dto.output.StringIdResponseDTO;
import io.github.com.core.work.jobs.dto.input.CreateJobDTO;
import io.github.com.core.work.jobs.dto.input.UpdateJobDTO;
import io.github.com.core.work.skills.dto.output.SkillDTO;

import java.util.List;

public interface JobService {
	// Create
	StringIdResponseDTO create(CreateJobDTO dto);

	// Read
	List<SkillDTO> findAll();
	SkillDTO findById(String id);
	SkillDTO findByName(String jobName);

	// Update
	StringIdResponseDTO updateById(String id, UpdateJobDTO dto);
	StringIdResponseDTO updateByName(String jobName, UpdateJobDTO dto);

	// Delete
	void deleteById(String id);
	void deleteByName(String jobName);
}

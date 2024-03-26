package io.github.com.services.interfaces;


import io.github.com.dto.common.StringIdResponseDTO;
import io.github.com.dto.staff.CreateJobDTO;
import io.github.com.dto.work.UpdateJobDTO;
import io.github.com.dto.work.SkillDTO;

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

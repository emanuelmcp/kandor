package io.github.com.services.interfaces;


import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.dto.work.CreateJobDTO;
import io.github.com.dto.work.JobDTO;

import java.util.List;

public interface JobService {
	// Create
	ApiResponseDTO create(CreateJobDTO dto);

	// Read
	List<JobDTO> findAll();
	JobDTO findById(String id);
	JobDTO findByName(String jobName);

	// Update
	ApiResponseDTO updateById(String id, JobDTO dto);
	ApiResponseDTO updateByName(String jobName, JobDTO dto);

	// Delete
	void deleteById(String id);
	void deleteByName(String jobName);
}

package io.github.com.services.interfaces;

import io.github.com.dto.common.ApiResponseDTO;

public interface SkillJobService {
	ApiResponseDTO addJobById(String skillId, String jobId);
	ApiResponseDTO addJobByName(String skillName, String jobName);

	void deleteJobById(String skillId, String jobId);
	void deleteJobByName(String skillName, String jobName);
}

package io.github.com.services.interfaces;

import io.github.com.dto.common.StringIdResponseDTO;

public interface SkillJobService {
	StringIdResponseDTO addJobById(String skillId, String jobId);
	StringIdResponseDTO addJobByName(String skillName, String jobName);

	void deleteJobById(String skillId, String jobId);
	void deleteJobByName(String skillName, String jobName);
}

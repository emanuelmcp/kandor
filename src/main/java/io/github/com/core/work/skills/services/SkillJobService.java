package io.github.com.core.work.skills.services;

import io.github.com.common.dto.output.StringIdResponseDTO;

public interface SkillJobService {
	StringIdResponseDTO addJobById(String skillId, String jobId);
	StringIdResponseDTO addJobByName(String skillName, String jobName);

	void deleteJobById(String skillId, String jobId);
	void deleteJobByName(String skillName, String jobName);
}

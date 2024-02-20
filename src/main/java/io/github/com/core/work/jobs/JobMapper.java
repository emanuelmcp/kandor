package io.github.com.core.work.jobs;

import io.github.com.core.work.jobs.dto.input.CreateJobDTO;
import io.github.com.entities.skills.Job;
import org.jetbrains.annotations.NotNull;

public class JobMapper {
	public Job createJobDTOToEntity(@NotNull CreateJobDTO dto){
		Job job = new Job();
		if (dto.getName() != null) job.setName(dto.getName());
		if (dto.getDescription() != null) job.setDescription(dto.getDescription());
		return job;
	}
}

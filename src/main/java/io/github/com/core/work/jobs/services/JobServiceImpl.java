package io.github.com.core.work.jobs.services;

import io.github.com.common.dto.output.StringIdResponseDTO;
import io.github.com.core.work.jobs.JobMapper;
import io.github.com.core.work.jobs.dto.input.CreateJobDTO;
import io.github.com.core.work.jobs.dto.input.UpdateJobDTO;
import io.github.com.core.work.skills.dto.output.SkillDTO;
import io.github.com.entities.skills.Job;
import io.github.com.exceptions.errors.EntityAlreadyExistsException;
import io.github.com.repositories.skills.JobRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JobServiceImpl implements JobService {
	private final JobRepository jobRepository;
	private final JobMapper jobMapper;

	@Autowired
	public JobServiceImpl(JobRepository jobRepository, JobMapper jobMapper) {
		this.jobRepository = jobRepository;
		this.jobMapper = jobMapper;
	}

	@Override
	public StringIdResponseDTO create(@NotNull CreateJobDTO dto) {
		jobRepository.findByName(dto.getName()).ifPresent((s) -> {
			throw new EntityAlreadyExistsException("Ya existe un trabajo con el nombre: " + dto.getName());
		});
		Job skill = jobMapper.createJobDTOToEntity(dto);
		Job savedSkill = jobRepository.save(skill);
		return new StringIdResponseDTO(
			skill.getId(),
			"El trabajo " + savedSkill.getName() + " ha sido creado"
		);
	}

	@Override
	public List<SkillDTO> findAll() {
		return null;
	}

	@Override
	public SkillDTO findById(String id) {
		return null;
	}

	@Override
	public SkillDTO findByName(String jobName) {
		return null;
	}

	@Override
	public StringIdResponseDTO updateById(String id, UpdateJobDTO dto) {
		return null;
	}

	@Override
	public StringIdResponseDTO updateByName(String jobName, UpdateJobDTO dto) {
		return null;
	}

	@Override
	public void deleteById(String id) {

	}

	@Override
	public void deleteByName(String jobName) {

	}
}

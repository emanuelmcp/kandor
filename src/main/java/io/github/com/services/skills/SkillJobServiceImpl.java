package io.github.com.services.skills;

import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.entities.skills.Job;
import io.github.com.entities.skills.Skill;
import io.github.com.exceptions.EntityAssociationException;
import io.github.com.repositories.skills.JobRepository;
import io.github.com.repositories.skills.SkillRepository;
import io.github.com.services.interfaces.SkillJobService;
import org.springframework.stereotype.Service;

@Service
public class SkillJobServiceImpl implements SkillJobService {
	private final SkillRepository skillRepository;
	private final JobRepository jobRepository;

	public SkillJobServiceImpl(SkillRepository skillRepository, JobRepository jobRepository) {
		this.skillRepository = skillRepository;
		this.jobRepository = jobRepository;
	}

	@Override
	public ApiResponseDTO addJobById(String skillId, String jobId) {
		Skill skill = skillRepository
			.findById(skillId)
			.orElseThrow(() -> new EntityAssociationException("La habilidad con el id " + skillId + " no existe"));
		Job job = jobRepository
			.findById(jobId)
			.orElseThrow(() -> new EntityAssociationException("El trabajo con el id " + jobId + " no existe"));
		skill.getJobs().add(job.getId());
		skillRepository.save(skill);
		return new ApiResponseDTO(
			skill.getId(),
			"A la habilidad " + skill.getName() + " se le ha añadido el trabajo " + job.getName()
		);
	}

	@Override
	public ApiResponseDTO addJobByName(String skillName, String jobName) {
		Skill skill = skillRepository
			.findByName(skillName)
			.orElseThrow(() -> new EntityAssociationException("La habilidad con el nombre " + skillName + " no existe"));
		Job job = jobRepository
			.findById(jobName)
			.orElseThrow(() -> new EntityAssociationException("El trabajo con el nombre " + jobName + " no existe"));
		skill.getJobs().add(job.getId());
		skillRepository.save(skill);
		return new ApiResponseDTO(
			skill.getId(),
			"A la habilidad " + skill.getName() + " se le ha añadido el trabajo " + job.getName()
		);
	}

	@Override
	public void deleteJobById(String skillId, String jobId) {
		Skill skill = skillRepository
			.findById(skillId)
			.orElseThrow(() -> new EntityAssociationException("La habilidad con el id " + skillId + " no existe"));
		Job job = jobRepository
			.findById(jobId)
			.orElseThrow(() -> new EntityAssociationException("El trabajo con el id " + jobId + " no existe"));
		skill.getJobs().remove(job.getId());
		skillRepository.save(skill);
	}

	@Override
	public void deleteJobByName(String skillName, String jobName) {
		Skill skill = skillRepository
			.findByName(skillName)
			.orElseThrow(() -> new EntityAssociationException("La habilidad con el nombre " + skillName + " no existe"));
		Job job = jobRepository
			.findById(jobName)
			.orElseThrow(() -> new EntityAssociationException("El trabajo con el nombre " + jobName + " no existe"));
		skill.getJobs().remove(job.getId());
		skillRepository.save(skill);
	}
}

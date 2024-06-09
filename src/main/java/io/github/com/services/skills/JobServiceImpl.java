package io.github.com.services.skills;

import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.dto.work.CreateJobDTO;
import io.github.com.dto.work.JobDTO;
import io.github.com.entities.skills.Job;
import io.github.com.exceptions.EntityAlreadyExistsException;
import io.github.com.exceptions.EntityNotFoundException;
import io.github.com.mappers.work.CreateJobDTOToJobMapper;
import io.github.com.mappers.work.JobToJobDTOMapper;
import io.github.com.mappers.work.ListOfJobsToListOfJobsDTOMapper;
import io.github.com.mappers.work.UpdateJobDTOToJobMapper;
import io.github.com.repositories.skills.JobRepository;
import io.github.com.services.interfaces.JobService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
	private final JobRepository jobRepository;
	private final CreateJobDTOToJobMapper createJobDTOToJobMapper;
	private final ListOfJobsToListOfJobsDTOMapper listOfJobsToListOfJobsDTOMapper;
	private final JobToJobDTOMapper jobToJobDTOMapper;
	private final UpdateJobDTOToJobMapper updateJobDTOToJobMapper;

	@Autowired
	public JobServiceImpl(
		JobRepository jobRepository,
		CreateJobDTOToJobMapper createJobDTOToJobMapper,
		ListOfJobsToListOfJobsDTOMapper listOfJobsToListOfJobsDTOMapper,
		JobToJobDTOMapper jobToJobDTOMapper, UpdateJobDTOToJobMapper updateJobDTOToJobMapper
	) {
		this.jobRepository = jobRepository;
		this.createJobDTOToJobMapper = createJobDTOToJobMapper;
		this.listOfJobsToListOfJobsDTOMapper = listOfJobsToListOfJobsDTOMapper;
		this.jobToJobDTOMapper = jobToJobDTOMapper;
		this.updateJobDTOToJobMapper = updateJobDTOToJobMapper;
	}

	@Override
	public ApiResponseDTO create(@NotNull CreateJobDTO dto) {
		jobRepository.findByName(dto.getName()).ifPresent((s) -> {
			throw new EntityAlreadyExistsException("Ya existe un trabajo con el nombre: " + dto.getName());
		});
		Job mappedJob = createJobDTOToJobMapper.map(dto);
		Job savedJob = jobRepository.save(mappedJob);
		return new ApiResponseDTO(
			savedJob.getId(),
			"El trabajo " + savedJob.getName() + " ha sido creado"
		);
	}

	@Override
	public List<JobDTO> findAll() {
		List<Job> jobs = jobRepository.findAll();
		return listOfJobsToListOfJobsDTOMapper.map(jobs);
	}

	@Override
	public JobDTO findById(String id) {
		Job job = jobRepository
			.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("El trabajo con el id " + id + " no existe"));
		return jobToJobDTOMapper.map(job);
	}

	@Override
	public JobDTO findByName(String jobName) {
		Job job = jobRepository
			.findByName(jobName)
			.orElseThrow(() -> new EntityNotFoundException("El trabajo con el nombre " + jobName + " no existe"));
		return jobToJobDTOMapper.map(job);
	}

	@Override
	public ApiResponseDTO updateById(String id, JobDTO dto) {
		Job job = jobRepository
			.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("El trabajo con el id " + id + " no existe"));
		updateJobDTOToJobMapper.map(dto, job);
		Job updatedJob = jobRepository.save(job);
		return new ApiResponseDTO(
			updatedJob.getId(),
			"El trabajo " + updatedJob.getName() + " ha sido actualizado"
		);
	}

	@Override
	public ApiResponseDTO updateByName(String jobName, JobDTO dto) {
		Job job = jobRepository
			.findById(jobName)
			.orElseThrow(() -> new EntityNotFoundException("El trabajo con el nombre " + jobName + " no existe"));
		updateJobDTOToJobMapper.map(dto, job);
		Job updatedJob = jobRepository.save(job);
		return new ApiResponseDTO(
			updatedJob.getId(),
			"El trabajo " + updatedJob.getName() + " ha sido actualizado"
		);
	}

	@Override
	public void deleteById(String id) {
		jobRepository.deleteById(id);
	}

	@Override
	public void deleteByName(String jobName) {
		jobRepository.deleteByName(jobName);
	}
}

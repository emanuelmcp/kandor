package io.github.com.controllers;

import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.dto.work.CreateJobDTO;
import io.github.com.dto.work.JobDTO;
import io.github.com.services.interfaces.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
	private final JobService jobService;

	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@PostMapping
	public ResponseEntity<ApiResponseDTO> createJob(@RequestBody CreateJobDTO dto) {
		return ResponseEntity.ok(jobService.create(dto));
	}

	@GetMapping
	public ResponseEntity<List<JobDTO>> findAllJobs() {
		return ResponseEntity.ok(jobService.findAll());
	}

}

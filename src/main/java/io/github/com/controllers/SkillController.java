package io.github.com.controllers;

import io.github.com.dto.work.CreateSkillDTO;
import io.github.com.dto.work.SkillDTO;
import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.services.interfaces.SkillJobService;
import io.github.com.services.interfaces.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/skills")
public class SkillController {
	private final SkillService skillService;
	private final SkillJobService skillJobService;

	@Autowired
	public SkillController(SkillService skillService, SkillJobService skillJobService) {
		this.skillService = skillService;
		this.skillJobService = skillJobService;
	}

	@PostMapping
	public ResponseEntity<ApiResponseDTO> createSkill(@RequestBody CreateSkillDTO dto) {
		return ResponseEntity.ok(skillService.create(dto));
	}

	@GetMapping
	public ResponseEntity<List<SkillDTO>> findAllSkills() {
		return ResponseEntity.ok(skillService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<SkillDTO> findSkillById(@PathVariable String id) {
		return ResponseEntity.ok(skillService.findById(id));
	}

	@GetMapping("/name/{skillName}")
	public ResponseEntity<SkillDTO> findSkillByName(@PathVariable String skillName) {
		return ResponseEntity.ok(skillService.findByName(skillName));
	}

	@DeleteMapping("/{id}")
	public void deleteSkillById(@PathVariable String id) {
		skillService.findById(id);
	}

	@DeleteMapping("/name/{skillName}")
	public void deleteSkillByName(@PathVariable String skillName) {
		skillService.findByName(skillName);
	}

	@PutMapping("/{skillId}/job/{jobId}")
	public ResponseEntity<ApiResponseDTO> addJobToSkillById(@PathVariable String skillId, @PathVariable String jobId) {
		return ResponseEntity.ok(skillJobService.addJobById(skillId, jobId));
	}

	@PutMapping("/{skillName}/job/{jobName}/name")
	public ResponseEntity<ApiResponseDTO> addJobToSkillByName(@PathVariable String skillName, @PathVariable String jobName) {
		return ResponseEntity.ok(skillJobService.addJobByName(skillName, jobName));
	}

	@DeleteMapping("/{skillId}/job/{jobId}")
	public void deleteJobToSkillById(@PathVariable String skillId, @PathVariable String jobId) {
		skillJobService.deleteJobById(skillId, jobId);
	}

	@DeleteMapping("/{skillName}/job/{jobName}/name")
	public void deleteJobToSkillByName(@PathVariable String skillName, @PathVariable String jobName) {
		skillJobService.deleteJobByName(skillName, jobName);
	}
}

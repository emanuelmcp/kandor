package io.github.com.core.work.skills;

import io.github.com.common.dto.output.StringIdResponseDTO;
import io.github.com.core.work.skills.dto.input.CreateSkillDTO;
import io.github.com.core.work.skills.dto.output.SkillDTO;
import io.github.com.core.work.skills.services.SkillService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/skills")
public class SkillController {
	private final SkillService skillService;

	@Autowired
	public SkillController(SkillService skillService) {
		this.skillService = skillService;
	}

	@PostMapping	@Operation(operationId = "create")
	public ResponseEntity<StringIdResponseDTO> createSkill(@RequestBody CreateSkillDTO dto) {
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
}

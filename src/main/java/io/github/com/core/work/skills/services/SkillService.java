package io.github.com.core.work.skills.services;

import io.github.com.common.dto.output.StringIdResponseDTO;
import io.github.com.core.work.skills.dto.input.CreateSkillDTO;
import io.github.com.core.work.skills.dto.input.UpdateSkillDTO;
import io.github.com.core.work.skills.dto.output.SkillDTO;

import java.util.List;

public interface SkillService {
	// Create
	StringIdResponseDTO create(CreateSkillDTO dto);

	// Read
	List<SkillDTO> findAll();
	SkillDTO findById(String id);
	SkillDTO findByName(String name);

	// Update
	StringIdResponseDTO updateById(String id, UpdateSkillDTO dto);
	StringIdResponseDTO updateByName(String skillName, UpdateSkillDTO dto);

	// Delete
	void deleteById(String id);
	void deleteByName(String name);
}

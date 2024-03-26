package io.github.com.services.interfaces;

import io.github.com.dto.work.CreateSkillDTO;
import io.github.com.dto.work.UpdateSkillDTO;
import io.github.com.dto.work.SkillDTO;
import io.github.com.dto.common.StringIdResponseDTO;

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

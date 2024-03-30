package io.github.com.services.interfaces;

import io.github.com.dto.work.CreateSkillDTO;
import io.github.com.dto.work.UpdateSkillDTO;
import io.github.com.dto.work.SkillDTO;
import io.github.com.dto.common.ApiResponseDTO;

import java.util.List;

public interface SkillService {
	// Create
	ApiResponseDTO create(CreateSkillDTO dto);

	// Read
	List<SkillDTO> findAll();
	SkillDTO findById(String id);
	SkillDTO findByName(String name);

	// Update
	ApiResponseDTO updateById(String id, UpdateSkillDTO dto);
	ApiResponseDTO updateByName(String skillName, UpdateSkillDTO dto);

	// Delete
	void deleteById(String id);
	void deleteByName(String name);
}

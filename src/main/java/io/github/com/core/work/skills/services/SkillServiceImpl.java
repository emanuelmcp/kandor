package io.github.com.core.work.skills.services;

import io.github.com.common.dto.output.StringIdResponseDTO;
import io.github.com.core.work.skills.mappers.SkillMapper;
import io.github.com.core.work.skills.dto.input.CreateSkillDTO;
import io.github.com.core.work.skills.dto.input.UpdateSkillDTO;
import io.github.com.core.work.skills.dto.output.SkillDTO;
import io.github.com.entities.skills.Skill;
import io.github.com.exceptions.errors.EntityAlreadyExistsException;
import io.github.com.exceptions.errors.EntityNotFoundException;
import io.github.com.repositories.skills.SkillRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("unused")
@Service
public class SkillServiceImpl implements SkillService {
	private final SkillRepository skillRepository;
	private final SkillMapper skillMapper;
	@Autowired
	public SkillServiceImpl(SkillRepository skillRepository, SkillMapper skillMapper) {
		this.skillRepository = skillRepository;
		this.skillMapper = skillMapper;
	}

	@Override
	public StringIdResponseDTO create(@NotNull CreateSkillDTO dto) {
		skillRepository.findByName(dto.getName()).ifPresent((s) -> {
			throw new EntityAlreadyExistsException("Ya existe una habilidad con el nombre: " + dto.getName());
		});
		Skill skill = skillMapper.createSkillDtoToEntity(dto);
		Skill savedSkill = skillRepository.save(skill);
		return new StringIdResponseDTO(
			skill.getId(),
			"La habilidad " + savedSkill.getName() + " ha sido creada"
		);
	}

	@Override
	public List<SkillDTO> findAll() {
		List<Skill> skills = skillRepository.findAll();
		return skillMapper.listSkillToListSkillDTO(skills);
	}

	@Override
	public SkillDTO findById(String id) {
		Skill skill = skillRepository
			.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("La habilidad con el id " + id + " no existe"));
		return skillMapper.entityToSkillDTO(skill);
	}

	@Override
	public SkillDTO findByName(String name) {
		Skill skill = skillRepository
			.findByName(name)
			.orElseThrow(() -> new EntityNotFoundException("La habilidad con el nombre " + name + " no existe"));
		return skillMapper.entityToSkillDTO(skill);
	}

	@Override
	public StringIdResponseDTO updateById(String id, UpdateSkillDTO dto) {
		Skill skill = skillRepository
			.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("La habilidad con el id " + id + " no existe"));
		skillMapper.updateSkillDTOToEntity(skill, dto);
		Skill updatedSkill = skillRepository.save(skill);
		return new StringIdResponseDTO(
			skill.getId(),
			"La habilidad " + skill.getName() + " ha sido actualizada"
		);
	}

	@Override
	public StringIdResponseDTO updateByName(String skillName, UpdateSkillDTO dto) {
		Skill skill = skillRepository
			.findByName(skillName)
			.orElseThrow(() -> new EntityNotFoundException("La habilidad con el nombre " + skillName + " no existe"));
		skillMapper.updateSkillDTOToEntity(skill, dto);
		Skill updatedSkill = skillRepository.save(skill);
		return new StringIdResponseDTO(
			skill.getId(),
			"La habilidad " + skill.getName() + " ha sido actualizada"
		);
	}

	@Override
	public void deleteById(String id) {
		skillRepository.deleteById(id);
	}

	@Override
	public void deleteByName(String name) {
		skillRepository.deleteByName(name);
	}
}
package io.github.com.services;

import io.github.com.dto.common.IntegerIdResponseDTO;
import io.github.com.dto.common.StringIdResponseDTO;
import io.github.com.dto.work.CreateSkillDTO;
import io.github.com.dto.work.SkillDTO;
import io.github.com.dto.work.UpdateSkillDTO;
import io.github.com.entities.skills.Skill;
import io.github.com.exceptions.EntityAlreadyExistsException;
import io.github.com.exceptions.EntityNotFoundException;
import io.github.com.mappers.work.CreateSkillDTOToSkillMapper;
import io.github.com.mappers.work.ListOfSkillsToSkillDTOMapper;
import io.github.com.mappers.work.SkillToSkillDTOMapper;
import io.github.com.mappers.work.UpdateSkillDTOToSkillMapper;
import io.github.com.repositories.SkillRepository;
import io.github.com.services.interfaces.SkillService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService{
	private final SkillRepository skillRepository;
	private final CreateSkillDTOToSkillMapper createSkillDTOToSkillMapper;
	private final ListOfSkillsToSkillDTOMapper listOfSkillsToSkillDTOMapper;
	private final SkillToSkillDTOMapper skillToSkillDTOMapper;
	private final UpdateSkillDTOToSkillMapper updateSkillDTOToSkillMapper;

	public SkillServiceImpl(
		SkillRepository skillRepository,
		CreateSkillDTOToSkillMapper createSkillDTOToSkillMapper,
		ListOfSkillsToSkillDTOMapper listOfSkillsToSkillDTOMapper,
		SkillToSkillDTOMapper skillToSkillDTOMapper, UpdateSkillDTOToSkillMapper updateSkillDTOToSkillMapper
	) {
		this.skillRepository = skillRepository;
		this.createSkillDTOToSkillMapper = createSkillDTOToSkillMapper;
		this.listOfSkillsToSkillDTOMapper = listOfSkillsToSkillDTOMapper;
		this.skillToSkillDTOMapper = skillToSkillDTOMapper;
		this.updateSkillDTOToSkillMapper = updateSkillDTOToSkillMapper;
	}

	@Override
	public StringIdResponseDTO create(@NotNull CreateSkillDTO dto) {
		skillRepository.findByName(dto.getName()).ifPresent((s) -> {
			throw new EntityAlreadyExistsException("Ya existe una habilidad con el nombre: " + dto.getName());
		});
		Skill mappedSkill = createSkillDTOToSkillMapper.map(dto);
		Skill savedSkill = skillRepository.save(mappedSkill);
		return new StringIdResponseDTO(
			savedSkill.getId(),
			"El grupo " + savedSkill.getName() + " ha sido creado"
		);
	}

	@Override
	public List<SkillDTO> findAll() {
		List<Skill> skills = skillRepository.findAll();
		return listOfSkillsToSkillDTOMapper.map(skills);
	}

	@Override
	public SkillDTO findById(String id) {
		Skill skill = skillRepository
			.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("La habilidad con el id " + id + " no existe"));
		return skillToSkillDTOMapper.map(skill);
	}

	@Override
	public SkillDTO findByName(String name) {
		Skill skill = skillRepository
			.findByName(name)
			.orElseThrow(() -> new EntityNotFoundException("La habilidad con el nombre " + name + " no existe"));
		return skillToSkillDTOMapper.map(skill);
	}

	@Override
	public StringIdResponseDTO updateById(String id, UpdateSkillDTO dto) {
		Skill skill = skillRepository
			.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("La habilidad con el id " + id + " no existe"));
		updateSkillDTOToSkillMapper.map(dto, skill);
		Skill updatedSkill = skillRepository.save(skill);
		return new StringIdResponseDTO(
			skill.getId(),
			"La habilidad " + skill.getName() + " ha sido actualizada"
		);
	}

	@Override
	public StringIdResponseDTO updateByName(String skillName, UpdateSkillDTO dto) {
		Skill skill = skillRepository
			.findById(skillName)
			.orElseThrow(() -> new EntityNotFoundException("La habilidad con el nombre " + skillName + " no existe"));
		updateSkillDTOToSkillMapper.map(dto, skill);
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
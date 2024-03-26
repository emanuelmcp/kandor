package io.github.com.services;

import io.github.com.dto.common.StringIdResponseDTO;
import io.github.com.dto.work.CreateSkillDTO;
import io.github.com.dto.work.UpdateSkillDTO;
import io.github.com.dto.work.SkillDTO;
import io.github.com.entities.skills.Skill;
import io.github.com.exceptions.EntityAlreadyExistsException;
import io.github.com.exceptions.EntityNotFoundException;
import io.github.com.repositories.SkillRepository;
import io.github.com.services.interfaces.CreateSkillDTOToSkillMapper;
import io.github.com.services.interfaces.SkillService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SkillServiceImpl implements SkillService{
	@Override
	public StringIdResponseDTO create(CreateSkillDTO dto) {
		return null;
	}

	@Override
	public List<SkillDTO> findAll() {
		return null;
	}

	@Override
	public SkillDTO findById(String id) {
		return null;
	}

	@Override
	public SkillDTO findByName(String name) {
		return null;
	}

	@Override
	public StringIdResponseDTO updateById(String id, UpdateSkillDTO dto) {
		return null;
	}

	@Override
	public StringIdResponseDTO updateByName(String skillName, UpdateSkillDTO dto) {
		return null;
	}

	@Override
	public void deleteById(String id) {

	}

	@Override
	public void deleteByName(String name) {

	}
	// TODO: implementar SkillService
//	private final SkillRepository skillRepository;
//	private final CreateSkillDTOToSkillMapper createSkillDTOToSkillMapper;
//	@Autowired
//	public SkillServiceImpl(SkillRepository skillRepository, CreateSkillDTOToSkillMapper createSkillDTOToSkillMapper) {
//		this.skillRepository = skillRepository;
//		this.createSkillDTOToSkillMapper = createSkillDTOToSkillMapper;
//	}
//
//	@Override
//	public StringIdResponseDTO create(@NotNull CreateSkillDTO dto) {
//		skillRepository.findByName(dto.getName()).ifPresent((s) -> {
//			throw new EntityAlreadyExistsException("Ya existe una habilidad con el nombre: " + dto.getName());
//		});
//		Skill skill = createSkillDTOToSkillMapper.map(dto);
//		Skill savedSkill = skillRepository.save(skill);
//		return new StringIdResponseDTO(
//			skill.getId(),
//			"La habilidad " + savedSkill.getName() + " ha sido creada"
//		);
//	}
//
//	@Override
//	public List<SkillDTO> findAll() {
//		List<Skill> skills = skillRepository.findAll();
//		return createSkillDTOToSkillMapper.listSkillToListSkillDTO(skills);
//	}
//
//	@Override
//	public SkillDTO findById(String id) {
//		Skill skill = skillRepository
//			.findById(id)
//			.orElseThrow(() -> new EntityNotFoundException("La habilidad con el id " + id + " no existe"));
//		return createSkillDTOToSkillMapper.entityToSkillDTO(skill);
//	}
//
//	@Override
//	public SkillDTO findByName(String name) {
//		Skill skill = skillRepository
//			.findByName(name)
//			.orElseThrow(() -> new EntityNotFoundException("La habilidad con el nombre " + name + " no existe"));
//		return createSkillDTOToSkillMapper.entityToSkillDTO(skill);
//	}
//
//	@Override
//	public StringIdResponseDTO updateById(String id, UpdateSkillDTO dto) {
//		Skill skill = skillRepository
//			.findById(id)
//			.orElseThrow(() -> new EntityNotFoundException("La habilidad con el id " + id + " no existe"));
//		createSkillDTOToSkillMapper.updateSkillDTOToEntity(skill, dto);
//		Skill updatedSkill = skillRepository.save(skill);
//		return new StringIdResponseDTO(
//			skill.getId(),
//			"La habilidad " + skill.getName() + " ha sido actualizada"
//		);
//	}
//
//	@Override
//	public StringIdResponseDTO updateByName(String skillName, UpdateSkillDTO dto) {
//		Skill skill = skillRepository
//			.findByName(skillName)
//			.orElseThrow(() -> new EntityNotFoundException("La habilidad con el nombre " + skillName + " no existe"));
//		createSkillDTOToSkillMapper.updateSkillDTOToEntity(skill, dto);
//		Skill updatedSkill = skillRepository.save(skill);
//		return new StringIdResponseDTO(
//			skill.getId(),
//			"La habilidad " + skill.getName() + " ha sido actualizada"
//		);
//	}
//
//	@Override
//	public void deleteById(String id) {
//		skillRepository.deleteById(id);
//	}
//
//	@Override
//	public void deleteByName(String name) {
//		skillRepository.deleteByName(name);
//	}
}
package io.github.com.core.work.skills.mappers;

import io.github.com.core.work.skills.dto.input.CreateSkillDTO;
import io.github.com.core.work.skills.dto.input.UpdateSkillDTO;
import io.github.com.core.work.skills.dto.output.SkillDTO;
import io.github.com.entities.skills.Skill;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SkillMapper {
	public Skill createSkillDtoToEntity(@NotNull CreateSkillDTO dto) {
		Skill skill = new Skill();
		if (dto.getName() != null) skill.setName(dto.getName());
		if (dto.getDescription() != null) skill.setDescription(dto.getDescription());
		if (dto.getHealth() != null) skill.setHealth(dto.getHealth());
		if (dto.getBackpack() != null) skill.setBackpack(dto.getBackpack());
		if (dto.getMovementSpeed() != null) skill.setMovementSpeed(dto.getMovementSpeed());
		return skill;
	}

	public SkillDTO entityToSkillDTO(@NotNull Skill entities) {
		return SkillDTO
			.builder()
			.id(entities.getId())
			.name(entities.getName())
			.description(entities.getDescription())
			.health(entities.getHealth())
			.backpack(entities.getBackpack())
			.movementSpeed(entities.getMovementSpeed())
			.build();
	}

	public List<SkillDTO> listSkillToListSkillDTO(@NotNull List<Skill> entities) {
		return entities.stream().map(item -> SkillDTO.builder()
				.id(item.getId())
				.name(item.getName())
				.description(item.getDescription())
				.health(item.getHealth())
				.backpack(item.getBackpack())
				.movementSpeed(item.getMovementSpeed())
				.build())
			.collect(Collectors.toList());
	}

	public void updateSkillDTOToEntity(Skill target, @NotNull UpdateSkillDTO source) {
		if (source.getName() != null) target.setName(source.getName());
		if (source.getDescription() != null) target.setDescription(source.getDescription());
		if (source.getHealth() != null) target.setHealth(source.getHealth());
		if (source.getBackpack() != null) target.setBackpack(source.getBackpack());
		if (source.getMovementSpeed() != null) target.setMovementSpeed(source.getMovementSpeed());
	}
}

package io.github.com.services.interfaces;

import io.github.com.dto.work.CreateSkillDTO;
import io.github.com.entities.skills.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreateSkillDTOToSkillMapper {
	CreateSkillDTOToSkillMapper INSTANCE = Mappers.getMapper(CreateSkillDTOToSkillMapper.class);
	Skill map(CreateSkillDTO dto);
}

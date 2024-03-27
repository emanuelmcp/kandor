package io.github.com.mappers.work;

import io.github.com.dto.work.SkillDTO;
import io.github.com.entities.skills.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SkillToSkillDTOMapper {
	SkillToSkillDTOMapper INSTANCE = Mappers.getMapper(SkillToSkillDTOMapper.class);
	SkillDTO map(Skill entity);
}

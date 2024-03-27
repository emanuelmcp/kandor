package io.github.com.mappers.work;

import io.github.com.dto.work.UpdateSkillDTO;
import io.github.com.entities.skills.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UpdateSkillDTOToSkillMapper {
	void map(UpdateSkillDTO dto, @MappingTarget Skill entity);
}

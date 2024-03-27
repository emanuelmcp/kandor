package io.github.com.mappers.work;

import io.github.com.dto.work.SkillDTO;
import io.github.com.entities.skills.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ListOfSkillsToSkillDTOMapper {
	ListOfSkillsToSkillDTOMapper INSTANCE = Mappers.getMapper(ListOfSkillsToSkillDTOMapper.class);
	List<SkillDTO> map(List<Skill> entities);
}

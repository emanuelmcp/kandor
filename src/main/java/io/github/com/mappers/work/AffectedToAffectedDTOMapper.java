package io.github.com.mappers.work;

import io.github.com.dto.work.AffectedDTO;
import io.github.com.entities.skills.Affected;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = RewardToRewardDTOMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AffectedToAffectedDTOMapper {
	AffectedToAffectedDTOMapper INSTANCE = Mappers.getMapper(AffectedToAffectedDTOMapper.class);
	AffectedDTO map(Affected dto);
}

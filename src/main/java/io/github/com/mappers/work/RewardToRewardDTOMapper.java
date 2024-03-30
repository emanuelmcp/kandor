package io.github.com.mappers.work;

import io.github.com.dto.work.RewardDTO;
import io.github.com.entities.skills.Reward;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {MoneyToMoneyDTOMapper.class, DropToDropDTOMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RewardToRewardDTOMapper {
	RewardToRewardDTOMapper INSTANCE = Mappers.getMapper(RewardToRewardDTOMapper.class);
	RewardDTO map(Reward dto);
}

package io.github.com.mappers.work;

import io.github.com.dto.work.RewardDTO;
import io.github.com.entities.skills.Reward;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {MoneyDTOToMoneyMapper.class, DropDTOToDropMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RewardDTOToRewardMapper {
	RewardDTOToRewardMapper INSTANCE = Mappers.getMapper(RewardDTOToRewardMapper.class);
	Reward map(RewardDTO dto);
}

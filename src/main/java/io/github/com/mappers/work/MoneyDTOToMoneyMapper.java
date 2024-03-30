package io.github.com.mappers.work;

import io.github.com.dto.work.MoneyDTO;
import io.github.com.entities.skills.Money;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MoneyDTOToMoneyMapper {
	MoneyDTOToMoneyMapper INSTANCE = Mappers.getMapper(MoneyDTOToMoneyMapper.class);
	Money map(MoneyDTO dto);
}

package io.github.com.mappers.work;

import io.github.com.dto.work.ActionDTO;
import io.github.com.entities.skills.Action;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActionDTOToActionMapper {
	ActionDTOToActionMapper INSTANCE = Mappers.getMapper(ActionDTOToActionMapper.class);
	Action map(ActionDTO dto);
}

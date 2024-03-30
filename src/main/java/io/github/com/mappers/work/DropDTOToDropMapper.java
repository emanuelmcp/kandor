package io.github.com.mappers.work;

import io.github.com.dto.work.DropDTO;
import io.github.com.entities.skills.Drop;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DropDTOToDropMapper {
	DropDTOToDropMapper INSTANCE = Mappers.getMapper(DropDTOToDropMapper.class);
	Drop map(DropDTO dto);
}

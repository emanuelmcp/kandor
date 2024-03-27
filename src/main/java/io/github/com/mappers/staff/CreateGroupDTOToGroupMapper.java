package io.github.com.mappers.staff;

import io.github.com.dto.staff.CreateGroupDTO;
import io.github.com.entities.staff.Group;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreateGroupDTOToGroupMapper {
	CreateGroupDTOToGroupMapper INSTANCE = Mappers.getMapper(CreateGroupDTOToGroupMapper.class);
	Group map(CreateGroupDTO dto);
}

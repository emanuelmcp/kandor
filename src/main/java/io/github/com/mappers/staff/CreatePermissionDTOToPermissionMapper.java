package io.github.com.mappers.staff;

import io.github.com.dto.staff.CreatePermissionDTO;
import io.github.com.entities.staff.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreatePermissionDTOToPermissionMapper {
	CreatePermissionDTOToPermissionMapper INSTANCE = Mappers.getMapper(CreatePermissionDTOToPermissionMapper.class);

	Permission map(CreatePermissionDTO dto);
}

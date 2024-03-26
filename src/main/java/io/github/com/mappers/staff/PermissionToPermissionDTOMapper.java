package io.github.com.mappers.staff;

import io.github.com.dto.staff.PermissionDTO;
import io.github.com.entities.staff.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionToPermissionDTOMapper {
	PermissionToPermissionDTOMapper INSTANCE = Mappers.getMapper(PermissionToPermissionDTOMapper.class);

	PermissionDTO map(Permission entity);

}

package io.github.com.mappers.staff;

import io.github.com.dto.staff.UpdatePermissionDTO;
import io.github.com.entities.staff.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UpdatePermissionDTOToPermissionMapper {
	void map(UpdatePermissionDTO dto, @MappingTarget Permission entity);
}

package io.github.com.mappers.staff;

import io.github.com.dto.staff.RelatedPermissionDTO;
import io.github.com.entities.staff.GroupPermission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GroupPermissionToRelatedPermissionDTOMapper {
	GroupPermissionToRelatedPermissionDTOMapper INSTANCE = Mappers.getMapper(GroupPermissionToRelatedPermissionDTOMapper.class);

	@Mapping(source = "permission.id", target = "id")
	@Mapping(source = "permission.name", target = "name")
	@Mapping(source = "permission.description", target = "description")
	RelatedPermissionDTO map(GroupPermission entity);
}

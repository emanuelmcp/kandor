package io.github.com.mappers.staff;

import io.github.com.dto.staff.FullGroupDTO;
import io.github.com.entities.staff.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = GroupPermissionToRelatedPermissionDTOMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GroupToFullGroupDTOMapper {
	GroupToFullGroupDTOMapper INSTANCE = Mappers.getMapper(GroupToFullGroupDTOMapper.class);
	@Mapping(source = "groupPermissions", target = "permissions")
	FullGroupDTO map(Group entity);
}

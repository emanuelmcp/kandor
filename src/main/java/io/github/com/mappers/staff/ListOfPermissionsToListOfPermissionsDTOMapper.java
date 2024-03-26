package io.github.com.mappers.staff;

import io.github.com.dto.staff.PermissionDTO;
import io.github.com.entities.staff.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ListOfPermissionsToListOfPermissionsDTOMapper {
	ListOfPermissionsToListOfPermissionsDTOMapper INSTANCE = Mappers.getMapper(ListOfPermissionsToListOfPermissionsDTOMapper.class);
	List<PermissionDTO> map(List<Permission> entities);

}

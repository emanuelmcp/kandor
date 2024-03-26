package io.github.com.mappers.staff;

import io.github.com.dto.staff.UpdateGroupDTO;
import io.github.com.entities.staff.Group;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UpdateGroupDTOToGroupMapper {
	void map(UpdateGroupDTO dto, @MappingTarget Group entity);
}

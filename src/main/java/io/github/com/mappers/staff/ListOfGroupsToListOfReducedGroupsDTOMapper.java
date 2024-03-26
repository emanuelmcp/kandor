package io.github.com.mappers.staff;

import io.github.com.dto.staff.FullGroupDTO;
import io.github.com.dto.staff.ReducedGroupDTO;
import io.github.com.entities.staff.Group;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface ListOfGroupsToListOfReducedGroupsDTOMapper {
	ListOfGroupsToListOfReducedGroupsDTOMapper INSTANCE = Mappers.getMapper(ListOfGroupsToListOfReducedGroupsDTOMapper.class);
	List<ReducedGroupDTO> map(List<Group> entities);
}

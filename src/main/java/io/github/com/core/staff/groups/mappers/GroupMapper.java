package io.github.com.core.staff.groups.mappers;

import io.github.com.core.staff.groups.dto.input.CreateGroupDTO;
import io.github.com.core.staff.groups.dto.input.UpdateGroupDTO;
import io.github.com.core.staff.groups.dto.output.FullGroupDTO;
import io.github.com.core.staff.groups.dto.output.ReducedGroupDTO;
import io.github.com.core.staff.groups.dto.output.types.RelatedPermissionsDTO;
import io.github.com.entities.staff.Group;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {
	public ReducedGroupDTO entityToGroupDTO(@NotNull Group entity) {
		return ReducedGroupDTO
			.builder()
			.id(entity.getId())
			.name(entity.getName())
			.description(entity.getDescription())
			.prefix(entity.getPrefix())
			.suffix(entity.getPrefix())
			.build();
	}
	public FullGroupDTO entityToFullGroupDTO(@NotNull Group entity) {
		List < RelatedPermissionsDTO> permissionListDTO = entity.getGroupPermissions()
			.stream()
			.map(item -> RelatedPermissionsDTO
				.builder()
				.idPermission(item.getId().getPermissionId())
				.name(item.getPermission().getName())
				.description(item.getPermission().getDescription())
				.isNegated(item.getIsNegated())
				.world(item.getWorld())
				.expiresAt(item.getExpiresAt())
				.build()
			).toList();
		return FullGroupDTO
			.builder()
			.id(entity.getId())
			.name(entity.getName())
			.description(entity.getDescription())
			.prefix(entity.getPrefix())
			.suffix(entity.getPrefix())
			.permissions(permissionListDTO)
			.build();
	}

	public Group createGroupDTOToEntity(@NotNull CreateGroupDTO dto) {
		Group group = new Group();
		if (dto.getName() != null) group.setName(dto.getName());
		if (dto.getDescription() != null) group.setDescription(dto.getDescription());
		if (dto.getPrefix() != null) group.setPrefix(dto.getPrefix());
		if (dto.getSuffix() != null) group.setSuffix(dto.getSuffix());
		return group;
	}

	public List<ReducedGroupDTO> listOfEntitiesToListReducedGroupDTO(@NotNull List<Group> entities) {
		return entities.stream().map(item -> ReducedGroupDTO.builder()
				.id(item.getId())
				.name(item.getName())
				.description(item.getDescription())
				.prefix(item.getPrefix())
				.suffix(item.getSuffix())
				.build())
			.collect(Collectors.toList());
	}

	public void updateGroupDTOToEntity(Group target, @NotNull UpdateGroupDTO source) {
		if (source.getName() != null) target.setName(source.getName());
		if (source.getDescription() != null) target.setDescription(source.getDescription());
		if (source.getPrefix() != null) target.setPrefix(source.getPrefix());
		if (source.getSuffix() != null) target.setSuffix(source.getSuffix());
	}
}

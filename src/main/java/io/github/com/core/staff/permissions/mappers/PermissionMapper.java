package io.github.com.core.staff.permissions.mappers;

import io.github.com.core.staff.permissions.dto.input.CreatePermissionDTO;
import io.github.com.core.staff.permissions.dto.input.UpdatePermissionDTO;
import io.github.com.core.staff.permissions.dto.output.PermissionDTO;
import io.github.com.entities.staff.Permission;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PermissionMapper {
    public PermissionDTO entityToPermissionDTO(@NotNull Permission permission) {
        return PermissionDTO
            .builder()
            .id(permission.getId())
            .name(permission.getName())
            .description(permission.getDescription())
            .build();
    }
    public Permission createPermissionDtoToPermission(@NotNull CreatePermissionDTO dto) {
        Permission permission = new Permission();
        if (dto.getName() != null) permission.setName(dto.getName());
        if (dto.getDescription() != null) permission.setDescription(dto.getDescription());
        return permission;
    }
    public List<PermissionDTO> listOfEntitiesToListPermissionDTO(@NotNull List<Permission> entities) {
        return entities.stream().map(item -> PermissionDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .build())
            .collect(Collectors.toList());
    }
    public void updatePermissionDTOToPermission(Permission target, @NotNull UpdatePermissionDTO source) {
        if (source.getName() != null) target.setName(source.getName());
        if (source.getDescription() != null) target.setDescription(source.getDescription());
    }
}

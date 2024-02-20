package io.github.com.core.staff.groups.services;

import io.github.com.common.dto.output.IntegerIdResponseDTO;
import io.github.com.core.staff.groups.dto.input.PermissionRelationsMetadataDTO;

public interface GroupPermissionService {

    // Create
    IntegerIdResponseDTO addPermissionById(Integer idGroup, Integer idPermission, PermissionRelationsMetadataDTO dto);
    IntegerIdResponseDTO addPermissionByName(String groupName, String permissionName, PermissionRelationsMetadataDTO dto);

    // Delete
    void deletePermissionById(Integer idGroup, Integer idPermission);
    void deletePermissionByName(String groupName, String permissionName);
}

package io.github.com.services.interfaces;

import io.github.com.dto.common.IntegerIdResponseDTO;
import io.github.com.dto.staff.PermissionRelationsMetadataDTO;

public interface GroupPermissionService {

    // Create
    IntegerIdResponseDTO addPermissionById(Integer idGroup, Integer idPermission, PermissionRelationsMetadataDTO dto);
    IntegerIdResponseDTO addPermissionByName(String groupName, String permissionName, PermissionRelationsMetadataDTO dto);

    // Delete
    void deletePermissionById(Integer idGroup, Integer idPermission);
    void deletePermissionByName(String groupName, String permissionName);
}

package io.github.com.services.interfaces;

import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.dto.staff.PermissionRelationsMetadataDTO;

public interface GroupPermissionService {

    // Create
    ApiResponseDTO addPermissionById(Integer idGroup, Integer idPermission, PermissionRelationsMetadataDTO dto);
    ApiResponseDTO addPermissionByName(String groupName, String permissionName, PermissionRelationsMetadataDTO dto);

    // Delete
    void deletePermissionById(Integer idGroup, Integer idPermission);
    void deletePermissionByName(String groupName, String permissionName);
}

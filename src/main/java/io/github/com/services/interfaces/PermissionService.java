package io.github.com.services.interfaces;

import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.dto.staff.CreatePermissionDTO;
import io.github.com.dto.staff.PermissionDTO;
import io.github.com.dto.staff.UpdatePermissionDTO;

import java.util.List;

public interface PermissionService {
    // Create
    ApiResponseDTO create(CreatePermissionDTO permission);

    // Read
    List<PermissionDTO> findAll();
    PermissionDTO findById(Integer id);
    PermissionDTO findByName(String permissionName);

    // Update
    ApiResponseDTO updateById(Integer id, UpdatePermissionDTO dto);
    ApiResponseDTO updateByName(String permissionName, UpdatePermissionDTO dto);
}

package io.github.com.core.staff.permissions.services;

import io.github.com.common.dto.output.IntegerIdResponseDTO;
import io.github.com.core.staff.permissions.dto.input.CreatePermissionDTO;
import io.github.com.core.staff.permissions.dto.input.UpdatePermissionDTO;
import io.github.com.core.staff.permissions.dto.output.PermissionDTO;

import java.util.List;

public interface PermissionService {
    // Create
    IntegerIdResponseDTO create(CreatePermissionDTO permission);

    // Read
    List<PermissionDTO> findAll();
    PermissionDTO findById(Integer id);
    PermissionDTO findByName(String permissionName);

    // Update
    IntegerIdResponseDTO updateById(Integer id, UpdatePermissionDTO dto);
    IntegerIdResponseDTO updateByName(String permissionName, UpdatePermissionDTO dto);
}

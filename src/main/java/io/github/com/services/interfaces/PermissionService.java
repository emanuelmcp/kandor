package io.github.com.services.interfaces;

import io.github.com.dto.common.IntegerIdResponseDTO;
import io.github.com.dto.staff.CreatePermissionDTO;
import io.github.com.dto.staff.UpdatePermissionDTO;
import io.github.com.dto.staff.PermissionDTO;

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

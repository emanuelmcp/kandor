package io.github.com.services.interfaces;

import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.dto.staff.PermissionRelationsMetadataDTO;

public interface AccountPermissionService {
    ApiResponseDTO addPermissionToAccountById(String uuid, Integer idPermission, PermissionRelationsMetadataDTO dto);
    void deletePermissionFromAccountById(String uuid, Integer idPermission);
    ApiResponseDTO addPermissionToAccountByNick(String nick, String permissionName, PermissionRelationsMetadataDTO dto);
    void deletePermissionFromAccountByNick(String nick, String permissionName);
}

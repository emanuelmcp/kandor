package io.github.com.services.interfaces;

import io.github.com.dto.common.StringIdResponseDTO;
import io.github.com.dto.staff.PermissionRelationsMetadataDTO;

public interface AccountPermissionService {
    StringIdResponseDTO addPermissionToAccountById(String uuid, Integer idPermission, PermissionRelationsMetadataDTO dto);
    void deletePermissionFromAccountById(String uuid, Integer idPermission);
    StringIdResponseDTO addPermissionToAccountByNick(String nick, String permissionName, PermissionRelationsMetadataDTO dto);
    void deletePermissionFromAccountByNick(String nick, String permissionName);
}

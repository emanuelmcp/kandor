package io.github.com.core.accounts.services;

import io.github.com.common.dto.output.StringIdResponseDTO;
import io.github.com.core.staff.groups.dto.input.PermissionRelationsMetadataDTO;

public interface AccountPermissionService {
    StringIdResponseDTO addPermissionToAccountById(String uuid, Integer idPermission, PermissionRelationsMetadataDTO dto);
    void deletePermissionFromAccountById(String uuid, Integer idPermission);
    StringIdResponseDTO addPermissionToAccountByNick(String nick, String permissionName, PermissionRelationsMetadataDTO dto);
    void deletePermissionFromAccountByNick(String nick, String permissionName);
}

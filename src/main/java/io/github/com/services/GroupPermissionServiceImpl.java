package io.github.com.services;

import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.dto.staff.PermissionRelationsMetadataDTO;
import io.github.com.entities.staff.Group;
import io.github.com.entities.staff.GroupPermission;
import io.github.com.entities.staff.Permission;
import io.github.com.entities.staff.keys.GroupPermissionPK;
import io.github.com.exceptions.EntityAlreadyExistsException;
import io.github.com.exceptions.EntityAssociationException;
import io.github.com.repositories.staff.GroupPermissionRepository;
import io.github.com.repositories.staff.GroupRepository;
import io.github.com.repositories.staff.PermissionRepository;
import io.github.com.services.interfaces.GroupPermissionService;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupPermissionServiceImpl implements GroupPermissionService {
    private final GroupRepository groupRepository;
    private final PermissionRepository permissionRepository;
    private final GroupPermissionRepository groupPermissionRepository;

    @Autowired
    public GroupPermissionServiceImpl(
            GroupRepository groupRepository,
            PermissionRepository permissionRepository,
            GroupPermissionRepository groupPermissionRepository
    ) {
        this.groupRepository = groupRepository;
        this.permissionRepository = permissionRepository;
        this.groupPermissionRepository = groupPermissionRepository;
    }

    // TODO: OPTIMIZAR (metodo exists)!!!!
    @Override
    @Transactional
    public ApiResponseDTO addPermissionById(Integer idGroup, Integer idPermission, @NotNull PermissionRelationsMetadataDTO dto) {
        Group group = groupRepository
                .findById(idGroup)
                .orElseThrow(() -> new EntityAssociationException("El grupo con el id " + idGroup + " no existe"));
        Permission permission = permissionRepository
                .findById(idPermission)
                .orElseThrow(() -> new EntityAssociationException("El permiso con el id " + idPermission + " no existe"));
        GroupPermissionPK groupPermissionPK = new GroupPermissionPK(group.getId(), permission.getId());
        groupPermissionRepository
                .findById(groupPermissionPK)
                .ifPresent((groupPermission -> {
                    System.out.println("Esta asociacion existe");
                    throw new EntityAlreadyExistsException("El grupo " + group.getName() + " ya tiene el permiso " + permission.getName() + " asociado");
                }));
        groupPermissionRepository.save(
                GroupPermission
                        .builder()
                        .id(groupPermissionPK)
                        .permission(permission)
                        .group(group)
                        .world(dto.getWorld())
                        .isNegated(dto.getIsNegated())
                        .expiresAt(dto.getExpiresAt())
                        .build());
        return new ApiResponseDTO(
                group.getId().toString(),
                "Al grupo " + group.getName() + " se le ha añadido el permiso " + permission.getName()
        );
    }

    @Override
    @Transactional
    public void deletePermissionById(Integer idGroup, Integer idPermission) {
        Group group = groupRepository
                .findById(idGroup)
                .orElseThrow(() -> new EntityAssociationException("El grupo con el id " + idGroup + " no existe"));
        Permission permission = permissionRepository
                .findById(idPermission)
                .orElseThrow(() -> new EntityAssociationException("El permiso con el id " + idPermission + " no existe"));
        groupPermissionRepository.deleteById(new GroupPermissionPK(group.getId(), permission.getId()));
    }

    @Override
    @Transactional
    public ApiResponseDTO addPermissionByName(String groupName, String permissionName, @NotNull PermissionRelationsMetadataDTO dto) {
        Group group = groupRepository
                .findByName(groupName)
                .orElseThrow(() -> new EntityAssociationException("El grupo con el nombre " + groupName + " no existe"));
        Permission permission = permissionRepository
                .findByName(permissionName)
                .orElseThrow(() -> new EntityAssociationException("El permiso con el nombre " + permissionName + " no existe"));
        GroupPermissionPK groupPermissionPK = new GroupPermissionPK(group.getId(), permission.getId());
        groupPermissionRepository
                .findById(groupPermissionPK)
                .ifPresent((groupPermission -> {
                    throw new EntityAlreadyExistsException("El grupo " + group.getName() + " ya tiene el permiso " + permission.getName() + " asociado");
                }));
        groupPermissionRepository.save(
                GroupPermission
                        .builder()
                        .id(groupPermissionPK)
                        .permission(permission)
                        .group(group)
                        .world(dto.getWorld())
                        .isNegated(dto.getIsNegated())
                        .expiresAt(dto.getExpiresAt())
                        .build()
        );
        return new ApiResponseDTO(
                group.getId().toString(),
                "Al grupo " + group.getName() + " se le ha añadido el permiso " + permission.getName()
        );
    }

    @Override
    @Transactional
    public void deletePermissionByName(String groupName, String permissionName) {
        Group group = groupRepository
                .findByName(groupName)
                .orElseThrow(() -> new EntityAssociationException("El grupo con el nombre " + groupName + " no existe"));
        Permission permission = permissionRepository
                .findByName(permissionName)
                .orElseThrow(() -> new EntityAssociationException("El permiso con el nombre " + permissionName + " no existe"));
        groupPermissionRepository.deleteById(new GroupPermissionPK(group.getId(), permission.getId()));
    }
}

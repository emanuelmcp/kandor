package io.github.com.core.staff.permissions.services;

import io.github.com.common.dto.output.IntegerIdResponseDTO;
import io.github.com.core.staff.permissions.mappers.PermissionMapper;
import io.github.com.core.staff.permissions.dto.input.CreatePermissionDTO;
import io.github.com.core.staff.permissions.dto.input.UpdatePermissionDTO;
import io.github.com.core.staff.permissions.dto.output.PermissionDTO;
import io.github.com.entities.staff.Permission;
import io.github.com.exceptions.errors.EntityAlreadyExistsException;
import io.github.com.exceptions.errors.EntityNotFoundException;
import io.github.com.exceptions.errors.EntityUpdateException;
import io.github.com.repositories.staff.PermissionRepository;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("unused")
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    @Autowired
    public PermissionServiceImpl(PermissionRepository permissionRepository, PermissionMapper permissionMapper) {
        this.permissionRepository = permissionRepository;
        this.permissionMapper = permissionMapper;
    }

    @Override
    @Transactional
    public IntegerIdResponseDTO create(@NotNull CreatePermissionDTO dto) {
        String permissionName = dto.getName();
        permissionRepository
            .findByName(permissionName)
            .ifPresent(existingPermission -> {
                throw new EntityAlreadyExistsException("Este permiso ya existe");
            });
        Permission mappedPermission = permissionMapper.createPermissionDtoToPermission(dto);
        Permission savedPermission = permissionRepository.save(mappedPermission);
        return new IntegerIdResponseDTO(
                savedPermission.getId(),
                "El permiso " + savedPermission.getName() + " ha sido creado"
        );
    }

    @Override
    @Transactional
    public List<PermissionDTO> findAll() {
        List<Permission> permissions = permissionRepository.findAll();
        return permissionMapper.listOfEntitiesToListPermissionDTO(permissions);
    }

    @Override
    @Transactional
    public PermissionDTO findById(Integer id) {
        Permission permission = permissionRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("El permiso con el id " + id + " no existe"));
        return permissionMapper.entityToPermissionDTO(permission);
    }

    @Override
    @Transactional
    public PermissionDTO findByName(String permissionName) {
        Permission permission = permissionRepository
                .findByName(permissionName)
                .orElseThrow(() -> new EntityNotFoundException("El permiso con el nombre " + permissionName + " no existe"));
        return permissionMapper.entityToPermissionDTO(permission);
    }

    @Override
    @Transactional
    public IntegerIdResponseDTO updateById(Integer id, UpdatePermissionDTO dto) {
        Permission permission = permissionRepository
                .findById(id)
                .orElseThrow(() -> new EntityUpdateException("El permiso con el id " + id + " no existe"));
        permissionMapper.updatePermissionDTOToPermission(permission, dto);
        Permission updatedPermission = permissionRepository.save(permission);
        return new IntegerIdResponseDTO(
                permission.getId(),
                "El permiso " + permission.getName() + " ha sido actualizado"
        );
    }

    @Override
    @Transactional
    public IntegerIdResponseDTO updateByName(String permissionName, UpdatePermissionDTO dto) {
        Permission permission = permissionRepository
                .findByName(permissionName)
                .orElseThrow(() -> new EntityUpdateException("El permiso con el nombre " + permissionName + " no existe"));
        permissionMapper.updatePermissionDTOToPermission(permission, dto);
        Permission updatedPermission = permissionRepository.save(permission);
        return new IntegerIdResponseDTO(
                permission.getId(),
                "El permiso " + permission.getName() + " ha sido actualizado"
        );
    }
}

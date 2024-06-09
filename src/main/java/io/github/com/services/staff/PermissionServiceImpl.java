package io.github.com.services.staff;

import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.dto.staff.CreatePermissionDTO;
import io.github.com.dto.staff.PermissionDTO;
import io.github.com.dto.staff.UpdatePermissionDTO;
import io.github.com.entities.staff.Permission;
import io.github.com.exceptions.EntityAlreadyExistsException;
import io.github.com.exceptions.EntityNotFoundException;
import io.github.com.exceptions.EntityUpdateException;
import io.github.com.mappers.staff.CreatePermissionDTOToPermissionMapper;
import io.github.com.mappers.staff.ListOfPermissionsToListOfPermissionsDTOMapper;
import io.github.com.mappers.staff.PermissionToPermissionDTOMapper;
import io.github.com.mappers.staff.UpdatePermissionDTOToPermissionMapper;
import io.github.com.repositories.staff.PermissionRepository;
import io.github.com.services.interfaces.PermissionService;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;
    private final CreatePermissionDTOToPermissionMapper createPermissionDtoToPermission;
    private final PermissionToPermissionDTOMapper permissionToPermissionDTOMapper;
    private final ListOfPermissionsToListOfPermissionsDTOMapper listOfEntitiesToListPermissionDTO;
    private final UpdatePermissionDTOToPermissionMapper updatePermissionDTOToPermissionMapper;

    @Autowired
    public PermissionServiceImpl(
		PermissionRepository permissionRepository,
		CreatePermissionDTOToPermissionMapper createPermissionDtoToPermission, PermissionToPermissionDTOMapper permissionToPermissionDTOMapper, ListOfPermissionsToListOfPermissionsDTOMapper listOfEntitiesToListPermissionDTO, UpdatePermissionDTOToPermissionMapper updatePermissionDTOToPermissionMapper
	) {
        this.permissionRepository = permissionRepository;
        this.createPermissionDtoToPermission = createPermissionDtoToPermission;
		this.permissionToPermissionDTOMapper = permissionToPermissionDTOMapper;
		this.listOfEntitiesToListPermissionDTO = listOfEntitiesToListPermissionDTO;
		this.updatePermissionDTOToPermissionMapper = updatePermissionDTOToPermissionMapper;
	}

    @Override
    @Transactional
    public ApiResponseDTO create(@NotNull CreatePermissionDTO dto) {
        String permissionName = dto.getName();
        permissionRepository
            .findByName(permissionName)
            .ifPresent(existingPermission -> {
                throw new EntityAlreadyExistsException("Este permiso ya existe");
            });
        Permission mappedPermission = createPermissionDtoToPermission.map(dto);
        Permission savedPermission = permissionRepository.save(mappedPermission);
        return new ApiResponseDTO(
                savedPermission.getId().toString(),
                "El permiso " + savedPermission.getName() + " ha sido creado"
        );
    }

    @Override
    @Transactional
    public List<PermissionDTO> findAll() {
        List<Permission> permissions = permissionRepository.findAll();
        return listOfEntitiesToListPermissionDTO.map(permissions);
    }

    @Override
    @Transactional
    public PermissionDTO findById(Integer id) {
        Permission permission = permissionRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("El permiso con el id " + id + " no existe"));
        return permissionToPermissionDTOMapper.map(permission);
    }

    @Override
    @Transactional
    public PermissionDTO findByName(String permissionName) {
        Permission permission = permissionRepository
                .findByName(permissionName)
                .orElseThrow(() -> new EntityNotFoundException("El permiso con el nombre " + permissionName + " no existe"));
        return permissionToPermissionDTOMapper.map(permission);
    }

    @Override
    @Transactional
    public ApiResponseDTO updateById(Integer id, UpdatePermissionDTO dto) {
        Permission permission = permissionRepository
                .findById(id)
                .orElseThrow(() -> new EntityUpdateException("El permiso con el id " + id + " no existe"));
        updatePermissionDTOToPermissionMapper.map(dto, permission);
        Permission updatedPermission = permissionRepository.save(permission);
        return new ApiResponseDTO(
            updatedPermission.getId().toString(),
                "El permiso " + updatedPermission.getName() + " ha sido actualizado"
        );
    }

    @Override
    @Transactional
    public ApiResponseDTO updateByName(String permissionName, UpdatePermissionDTO dto) {
        Permission permission = permissionRepository
                .findByName(permissionName)
                .orElseThrow(() -> new EntityUpdateException("El permiso con el nombre " + permissionName + " no existe"));
        updatePermissionDTOToPermissionMapper.map(dto, permission);
        Permission updatedPermission = permissionRepository.save(permission);
        return new ApiResponseDTO(
            updatedPermission.getId().toString(),
                "El permiso " + updatedPermission.getName() + " ha sido actualizado"
        );
    }
}

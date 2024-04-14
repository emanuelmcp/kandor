package io.github.com.services;

import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.dto.staff.CreateGroupDTO;
import io.github.com.dto.staff.FullGroupDTO;
import io.github.com.dto.staff.ReducedGroupDTO;
import io.github.com.dto.staff.UpdateGroupDTO;
import io.github.com.entities.staff.Group;
import io.github.com.exceptions.DuplicatedAttributesException;
import io.github.com.exceptions.EntityAlreadyExistsException;
import io.github.com.exceptions.EntityNotFoundException;
import io.github.com.exceptions.EntityUpdateException;
import io.github.com.mappers.staff.CreateGroupDTOToGroupMapper;
import io.github.com.mappers.staff.GroupToFullGroupDTOMapper;
import io.github.com.mappers.staff.ListOfGroupsToListOfReducedGroupsDTOMapper;
import io.github.com.mappers.staff.UpdateGroupDTOToGroupMapper;
import io.github.com.repositories.GroupRepository;
import io.github.com.services.interfaces.GroupService;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final CreateGroupDTOToGroupMapper createGroupDTOToGroupMapper;
    private final ListOfGroupsToListOfReducedGroupsDTOMapper listOfGroupsToListOfReducedGroupsDTOMapper;
    private final GroupToFullGroupDTOMapper groupToFullGroupDTOMapper;
    private final UpdateGroupDTOToGroupMapper updateGroupDTOToGroupMapper;

    @Autowired
    public GroupServiceImpl(
		GroupRepository groupRepository,
		CreateGroupDTOToGroupMapper createGroupDTOToGroupMapper,
		ListOfGroupsToListOfReducedGroupsDTOMapper listOfGroupsToListOfReducedGroupsDTOMapper,
		GroupToFullGroupDTOMapper groupToFullGroupDTOMapper, UpdateGroupDTOToGroupMapper updateGroupDTOToGroupMapper
	) {
        this.groupRepository = groupRepository;
        this.createGroupDTOToGroupMapper = createGroupDTOToGroupMapper;
		this.listOfGroupsToListOfReducedGroupsDTOMapper = listOfGroupsToListOfReducedGroupsDTOMapper;
		this.groupToFullGroupDTOMapper = groupToFullGroupDTOMapper;
		this.updateGroupDTOToGroupMapper = updateGroupDTOToGroupMapper;
	}

    @Override
    @Transactional
    public ApiResponseDTO create(@NotNull CreateGroupDTO dto) {
        groupRepository.findByName(dto.getName()).ifPresent(existingGroup -> {
            throw new EntityAlreadyExistsException("Este grupo ya existe");
        });
        if (dto.getPrefix() != null)
            groupRepository.findByPrefix(dto.getPrefix()).ifPresent(existingGroup -> {
                throw new DuplicatedAttributesException("Ya existe un grupo con el prefijo: " + dto.getPrefix());
            });
        if (dto.getSuffix() != null)
            groupRepository.findBySuffix(dto.getSuffix()).ifPresent(existingGroup -> {
            throw new DuplicatedAttributesException("Ya existe un grupo con el sufijo: " + dto.getSuffix());
        });
        Group mappedGroup = createGroupDTOToGroupMapper.map(dto);
        Group savedGroup = groupRepository.save(mappedGroup);
        return new ApiResponseDTO(
                savedGroup.getId().toString(),
                "El grupo " + savedGroup.getName() + " ha sido creado"
        );
    }

    @Override
    @Transactional
    public List<ReducedGroupDTO> findAll() {
        List<Group> groups = groupRepository.findAll();
        return listOfGroupsToListOfReducedGroupsDTOMapper.map(groups);
    }

    @Override
    @Transactional
    public FullGroupDTO findById(Integer id) {
        Group group = groupRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("El grupo con el id " + id + " no existe"));
        return groupToFullGroupDTOMapper.map(group);
    }

    @Override
    @Transactional
    public FullGroupDTO findByName(String groupName) {
        Group group = groupRepository
                .findByName(groupName)
                .orElseThrow(() -> new EntityNotFoundException("El grupo con el nombre " + groupName + " no existe"));
        return groupToFullGroupDTOMapper.map(group);
    }

    @Override
    public ApiResponseDTO updateGroupById(Integer id, UpdateGroupDTO dto) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new EntityUpdateException("El grupo con el id " + id + " no existe"));
        updateGroupDTOToGroupMapper.map(dto, group);
        Group updatedGroup = groupRepository.save(group);
        return new ApiResponseDTO(
                group.getId().toString(),
                "El grupo " + updatedGroup.getName() + " ha sido actualizado"
        );
    }

    @Override
    public ApiResponseDTO updateGroupByName(String groupName, UpdateGroupDTO dto) {
        Group group = groupRepository.findByName(groupName)
                .orElseThrow(() -> new EntityUpdateException("El grupo con el nombre " + groupName + " no existe"));
        updateGroupDTOToGroupMapper.map(dto, group);
        Group updatedGroup = groupRepository.save(group);
        return new ApiResponseDTO(
                group.getId().toString(),
                "El grupo " + updatedGroup.getName() + " ha sido actualizado"
        );
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        groupRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByName(String groupName) {
        groupRepository.deleteByName(groupName);
    }
}

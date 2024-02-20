package io.github.com.core.staff.groups.services;

import io.github.com.common.dto.output.IntegerIdResponseDTO;
import io.github.com.core.staff.groups.dto.input.CreateGroupDTO;
import io.github.com.core.staff.groups.dto.input.UpdateGroupDTO;
import io.github.com.core.staff.groups.dto.output.FullGroupDTO;
import io.github.com.core.staff.groups.dto.output.ReducedGroupDTO;
import io.github.com.core.staff.groups.mappers.GroupMapper;
import io.github.com.entities.staff.Group;
import io.github.com.exceptions.errors.DuplicatedAttributesException;
import io.github.com.exceptions.errors.EntityAlreadyExistsException;
import io.github.com.exceptions.errors.EntityNotFoundException;
import io.github.com.exceptions.errors.EntityUpdateException;
import io.github.com.repositories.staff.GroupRepository;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@SuppressWarnings("unused")
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Autowired
    public GroupServiceImpl(
        GroupRepository groupRepository,
        GroupMapper groupMapper
	) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
	}

    @Override
    @Transactional
    public IntegerIdResponseDTO create(@NotNull CreateGroupDTO dto) {
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
        Group mappedGroup = groupMapper.createGroupDTOToEntity(dto);
        Group savedGroup = groupRepository.save(mappedGroup);
        return new IntegerIdResponseDTO(
                savedGroup.getId(),
                "El grupo " + savedGroup.getName() + " ha sido creado"
        );
    }

    @Override
    @Transactional
    public List<ReducedGroupDTO> findAll() {
        List<Group> groups = groupRepository.findAll();
        return groupMapper.listOfEntitiesToListReducedGroupDTO(groups);
    }

    @Override
    @Transactional
    public FullGroupDTO findById(Integer id) {
        Group group = groupRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("El grupo con el id " + id + " no existe"));
        return groupMapper.entityToFullGroupDTO(group);
    }

    @Override
    @Transactional
    public FullGroupDTO findByName(String groupName) {
        Group group = groupRepository
                .findByName(groupName)
                .orElseThrow(() -> new EntityNotFoundException("El grupo con el nombre " + groupName + " no existe"));
        return groupMapper.entityToFullGroupDTO(group);
    }

    @Override
    public IntegerIdResponseDTO updateGroupById(Integer id, UpdateGroupDTO dto) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new EntityUpdateException("El grupo con el id " + id + " no existe"));
        groupMapper.updateGroupDTOToEntity(group, dto);
        Group updatedGroup = groupRepository.save(group);
        return new IntegerIdResponseDTO(
                group.getId(),
                "El grupo " + group.getName() + " ha sido actualizado"
        );
    }

    @Override
    public IntegerIdResponseDTO updateGroupByName(String groupName, UpdateGroupDTO dto) {
        Group group = groupRepository.findByName(groupName)
                .orElseThrow(() -> new EntityUpdateException("El grupo con el nombre " + groupName + " no existe"));
        groupMapper.updateGroupDTOToEntity(group, dto);
        Group updatedGroup = groupRepository.save(group);
        return new IntegerIdResponseDTO(
                group.getId(),
                "El grupo " + group.getName() + " ha sido actualizado"
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

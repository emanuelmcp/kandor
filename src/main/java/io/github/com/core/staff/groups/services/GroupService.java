package io.github.com.core.staff.groups.services;

import io.github.com.common.dto.output.IntegerIdResponseDTO;
import io.github.com.core.staff.groups.dto.input.CreateGroupDTO;
import io.github.com.core.staff.groups.dto.input.UpdateGroupDTO;
import io.github.com.core.staff.groups.dto.output.FullGroupDTO;
import io.github.com.core.staff.groups.dto.output.ReducedGroupDTO;

import java.util.List;


public interface GroupService {

    // Create
    IntegerIdResponseDTO create(CreateGroupDTO dto);

    // Read
    List<ReducedGroupDTO> findAll();
    FullGroupDTO findById(Integer id);
    FullGroupDTO findByName(String groupName);

    // Update
    IntegerIdResponseDTO updateGroupById(Integer id, UpdateGroupDTO dto);
    IntegerIdResponseDTO updateGroupByName(String groupName, UpdateGroupDTO dto);

    // Delete
    void deleteById(Integer id);
    void deleteByName(String groupName);
}

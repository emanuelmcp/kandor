package io.github.com.services.interfaces;

import io.github.com.dto.common.IntegerIdResponseDTO;
import io.github.com.dto.staff.CreateGroupDTO;
import io.github.com.dto.staff.UpdateGroupDTO;
import io.github.com.dto.staff.FullGroupDTO;
import io.github.com.dto.staff.ReducedGroupDTO;

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

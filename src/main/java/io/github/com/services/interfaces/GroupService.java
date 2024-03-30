package io.github.com.services.interfaces;

import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.dto.staff.CreateGroupDTO;
import io.github.com.dto.staff.FullGroupDTO;
import io.github.com.dto.staff.ReducedGroupDTO;
import io.github.com.dto.staff.UpdateGroupDTO;

import java.util.List;


public interface GroupService {

    // Create
    ApiResponseDTO create(CreateGroupDTO dto);

    // Read
    List<ReducedGroupDTO> findAll();
    FullGroupDTO findById(Integer id);
    FullGroupDTO findByName(String groupName);

    // Update
    ApiResponseDTO updateGroupById(Integer id, UpdateGroupDTO dto);
    ApiResponseDTO updateGroupByName(String groupName, UpdateGroupDTO dto);

    // Delete
    void deleteById(Integer id);
    void deleteByName(String groupName);
}

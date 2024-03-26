package io.github.com.controllers;

import io.github.com.dto.common.IntegerIdResponseDTO;
import io.github.com.dto.staff.PermissionRelationsMetadataDTO;
import io.github.com.dto.staff.CreateGroupDTO;
import io.github.com.dto.staff.UpdateGroupDTO;
import io.github.com.dto.staff.FullGroupDTO;
import io.github.com.dto.staff.ReducedGroupDTO;
import io.github.com.services.interfaces.GroupPermissionService;
import io.github.com.services.interfaces.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/groups")
public class GroupController {
	private final GroupService groupService;
	private final GroupPermissionService groupPermissionService;

	@Autowired
	public GroupController(GroupService groupService, GroupPermissionService groupPermissionService) {
		this.groupService = groupService;
		this.groupPermissionService = groupPermissionService;
	}

	// CREATE
	@PostMapping
	public ResponseEntity<IntegerIdResponseDTO> createGroup(@RequestBody CreateGroupDTO dto) {
		return ResponseEntity.ok(groupService.create(dto));
	}

	// READ
	@GetMapping
	public ResponseEntity<List<ReducedGroupDTO>> findAllGroups() {
		return ResponseEntity.ok(groupService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<FullGroupDTO> findGroupById(@PathVariable Integer id) {
		return ResponseEntity.ok(groupService.findById(id));
	}

	@GetMapping("/name/{groupName}")
	public ResponseEntity<FullGroupDTO> findGroupByName(@PathVariable String groupName) {
		return ResponseEntity.ok(groupService.findByName(groupName));
	}

	// Update
	@PatchMapping("/{id}")
	public ResponseEntity<IntegerIdResponseDTO> updateGroupById(@PathVariable Integer id, @RequestBody UpdateGroupDTO dto) {
		return ResponseEntity.ok(groupService.updateGroupById(id, dto));
	}

	@PatchMapping("/name/{groupName}")
	public ResponseEntity<IntegerIdResponseDTO> updateGroupByName(@PathVariable String groupName, @RequestBody UpdateGroupDTO dto) {
		return ResponseEntity.ok(groupService.updateGroupByName(groupName, dto));
	}
	@DeleteMapping("/{id}")
	public void deleteGroupById(@PathVariable Integer id) {
		groupService.deleteById(id);
	}

	@DeleteMapping("/name/{groupName}")
	public void deleteGroupByName(@PathVariable String groupName) {
		groupService.deleteByName(groupName);
	}

	@PutMapping("/{idGroup}/permission/{idPermission}")
	public ResponseEntity<IntegerIdResponseDTO> addPermissionToGroupById(
		@PathVariable Integer idGroup,
		@PathVariable Integer idPermission,
		@RequestBody PermissionRelationsMetadataDTO dto
	) {
		return ResponseEntity.ok(groupPermissionService.addPermissionById(idGroup, idPermission, dto));
	}

	@DeleteMapping("/{idGroup}/permission/{idPermission}")
	public void deletePermissionFromGroupById(
		@PathVariable Integer idGroup,
		@PathVariable Integer idPermission
	) {
		groupPermissionService.deletePermissionById(idGroup, idPermission);
	}

	@PutMapping("/{groupName}/permission/{permissionName}/name")
	public ResponseEntity<IntegerIdResponseDTO> addPermissionToGroupByName(
		@PathVariable String groupName,
		@PathVariable String permissionName,
		@RequestBody PermissionRelationsMetadataDTO dto
	) {
		return ResponseEntity.ok(groupPermissionService.addPermissionByName(groupName, permissionName, dto));
	}

	@DeleteMapping("/{groupName}/permission/{permissionName}/name")
	public void deletePermissionFromGroupByName(
		@PathVariable String groupName,
		@PathVariable String permissionName
	) {
		groupPermissionService.deletePermissionByName(groupName, permissionName);
	}
}

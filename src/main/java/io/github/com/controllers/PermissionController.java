package io.github.com.controllers;

import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.dto.staff.CreatePermissionDTO;
import io.github.com.dto.staff.PermissionDTO;
import io.github.com.dto.staff.UpdatePermissionDTO;
import io.github.com.services.interfaces.PermissionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/permissions")
public class PermissionController {
    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO> createPermission(@Valid @RequestBody CreatePermissionDTO dto) {
        return ResponseEntity.ok(permissionService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<PermissionDTO>> findAllPermissions() {
        return ResponseEntity.ok(permissionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionDTO> findPermissionById(@PathVariable Integer id) {
        return ResponseEntity.ok(permissionService.findById(id));
    }

    @GetMapping("/name/{permissionName}")
    public ResponseEntity<PermissionDTO> findPermissionByName(@PathVariable String permissionName) {
        return ResponseEntity.ok(permissionService.findByName(permissionName));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> updatePermissionById(
            @PathVariable Integer id,
            @RequestBody UpdatePermissionDTO dto
    ) {
        return ResponseEntity.ok(permissionService.updateById(id, dto));
    }

    @PatchMapping("/{permissionName}/name")
    public ResponseEntity<ApiResponseDTO> updatePermissionByName(
            @PathVariable String permissionName,
            @RequestBody UpdatePermissionDTO dto
    ) {
        return ResponseEntity.ok(permissionService.updateByName(permissionName, dto));
    }
}

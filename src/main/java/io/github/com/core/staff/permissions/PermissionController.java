package io.github.com.core.staff.permissions;

import io.github.com.common.dto.output.IntegerIdResponseDTO;
import io.github.com.core.staff.permissions.dto.input.CreatePermissionDTO;
import io.github.com.core.staff.permissions.dto.input.UpdatePermissionDTO;
import io.github.com.core.staff.permissions.dto.output.PermissionDTO;
import io.github.com.core.staff.permissions.services.PermissionService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/permissions")
public class PermissionController {
    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping
    public ResponseEntity<IntegerIdResponseDTO> createPermission(@Valid @RequestBody CreatePermissionDTO dto) {
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
    public ResponseEntity<IntegerIdResponseDTO> updatePermissionById(
            @PathVariable Integer id,
            @RequestBody UpdatePermissionDTO dto
    ) {
        return ResponseEntity.ok(permissionService.updateById(id, dto));
    }

    @PatchMapping("/{permissionName}/name")
    public ResponseEntity<IntegerIdResponseDTO> updatePermissionByName(
            @PathVariable String permissionName,
            @RequestBody UpdatePermissionDTO dto
    ) {
        return ResponseEntity.ok(permissionService.updateByName(permissionName, dto));
    }
}

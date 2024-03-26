package io.github.com.repositories;

import io.github.com.entities.staff.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    Optional<Permission> findByName(String name);
    void deleteByName(String name);
}

package io.github.com.repositories.staff;

import io.github.com.entities.staff.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    Optional<Group> findByName(String name);
    Optional<Group> findByPrefix(String prefix);
    Optional<Group> findBySuffix(String suffix);
    void deleteByName(String name);
}

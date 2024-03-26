package io.github.com.repositories;

import io.github.com.entities.staff.GroupPermission;
import io.github.com.entities.staff.keys.GroupPermissionPK;
import org.springframework.data.repository.CrudRepository;

public interface GroupPermissionRepository extends CrudRepository<GroupPermission, GroupPermissionPK> {
}

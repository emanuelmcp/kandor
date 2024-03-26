package io.github.com.repositories;

import io.github.com.entities.staff.AccountPermission;
import io.github.com.entities.staff.keys.AccountPermissionPK;
import org.springframework.data.repository.CrudRepository;

public interface AccountPermissionRepository extends CrudRepository<AccountPermission, AccountPermissionPK> {
}

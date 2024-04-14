package io.github.com.repositories.staff;

import io.github.com.entities.staff.AccountGroup;
import io.github.com.entities.staff.keys.AccountGroupPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountGroupRepository extends JpaRepository<AccountGroup, AccountGroupPK> {
}

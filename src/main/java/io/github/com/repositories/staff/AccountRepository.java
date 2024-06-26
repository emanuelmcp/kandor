package io.github.com.repositories.staff;

import io.github.com.entities.staff.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByNick(String nick);
}

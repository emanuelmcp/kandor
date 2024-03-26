package io.github.com.entities.staff;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Column(name = "uuid")
    @Id
    String uuid;

    @Column(name = "password")
    String password;

    @Column(name = "nick")
    String nick;

    // Relations
    @OneToMany(mappedBy = "account")
    @Builder.Default
    Set<AccountGroup> accountGroups = new HashSet<>();

    @OneToMany(mappedBy = "account")
    @Builder.Default
    Set<AccountPermission> accountPermissions = new HashSet<>();

    // Register auditor
    @Embedded
    Audit audit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return Objects.equals(getUuid(), account.getUuid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid());
    }
}

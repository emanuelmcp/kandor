package io.github.com.entities.staff;

import io.github.com.entities.staff.keys.AccountPermissionPK;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@Setter
@Getter
@Entity(name = "account_permission")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountPermission {
    @EmbeddedId
    AccountPermissionPK id;

    @Column(name = "is_negated")
    Boolean isNegated;

    @Column
    String world;

    @Column(name = "expires_at", columnDefinition= "TIMESTAMP WITH TIME ZONE")
    Date expiresAt;

    @ManyToOne
    @MapsId("uuid")
    @JoinColumn(name = "uuid")
    Account account;

    @ManyToOne
    @MapsId("permissionId")
    @JoinColumn(name = "id_permission")
    Permission permission;

    @Embedded
    Audit audit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountPermission that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

package io.github.com.entities.staff.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AccountPermissionPK {
    @Column(name = "uuid")
    String uuid;

    @Column(name = "permission_id")
    Integer permissionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountPermissionPK that)) return false;
        return Objects.equals(getUuid(), that.getUuid()) && Objects.equals(getPermissionId(), that.getPermissionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getPermissionId());
    }
}

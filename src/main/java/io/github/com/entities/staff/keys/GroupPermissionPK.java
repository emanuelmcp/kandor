package io.github.com.entities.staff.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class GroupPermissionPK {
    @Column(name = "group_id", nullable = false)
    Integer groupId;

    @Column(name = "permission_id", nullable = false)
    Integer permissionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupPermissionPK that)) return false;
        return Objects.equals(
                getGroupId(), that.getGroupId()) &&
                Objects.equals(getPermissionId(), that.getPermissionId()
                );
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGroupId(), getPermissionId());
    }
}

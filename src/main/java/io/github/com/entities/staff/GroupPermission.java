package io.github.com.entities.staff;

import io.github.com.entities.staff.keys.GroupPermissionPK;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@Setter
@Getter
@Entity(name = "group_permission")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupPermission {

    @EmbeddedId
    GroupPermissionPK id;

    @Column(name = "is_negated")
    Boolean isNegated;

    @Column
    String world;

    @Column(name = "expires_at")
    Date expiresAt;

    @ManyToOne
    @MapsId("permissionId")
    @JoinColumn(name = "permission_id")
    Permission permission;

    @ManyToOne()
    @MapsId("groupId")
    @JoinColumn(name = "group_id")
    Group group;

    @Embedded
    Audit audit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupPermission that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

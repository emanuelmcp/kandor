package io.github.com.entities.staff;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@Entity(name = "permission")
@AllArgsConstructor
@NoArgsConstructor
public class Permission {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissions_id_seq")
    Integer id;

    @Column(name = "name", unique = true, nullable = false)
    String name;

    @Column(name = "description")
    String description;

    @OneToMany(mappedBy = "permission")
    Set<GroupPermission> groupPermissions = new HashSet<>();

    @OneToMany(mappedBy = "permission")
    Set<AccountPermission> accountPermissions = new HashSet<>();

    @Embedded
    Audit audit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permission that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

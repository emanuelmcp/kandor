package io.github.com.entities.staff;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Setter
@Getter
@Entity(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Group {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groups_id_seq")
    Integer id;

    @Column(name = "name", unique = true, nullable = false)
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "prefix")
    String prefix;

    @Column(name = "suffix")
    String suffix;

    @OneToMany(mappedBy = "group")
    Set<AccountGroup> accountGroups = new HashSet<>();

    @OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE)
    Set<GroupPermission> groupPermissions = new HashSet<>();

    @Embedded
    Audit audit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group group)) return false;
        return Objects.equals(getId(), group.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

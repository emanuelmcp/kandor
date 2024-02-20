package io.github.com.entities.staff;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Entity(name = "account_group")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountGroup {
    //TODO: crear equals and hashcode
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "uuid")
    Account account;

    @ManyToOne()
    @JoinColumn(name = "id_group")
    Group group;

    @Column(name = "expires_at", columnDefinition= "TIMESTAMP WITH TIME ZONE")
    Date expiresAt;

    @Embedded
    Audit audit;
}

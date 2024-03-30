package io.github.com.entities.staff;

import io.github.com.entities.staff.keys.AccountGroupPK;
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
    @EmbeddedId
    private AccountGroupPK id;

    @ManyToOne
    @JoinColumn(name = "uuid")
    Account account;

    @ManyToOne()
    @JoinColumn(name = "group_id")
    Group group;

    @Column(name = "expires_at", columnDefinition= "TIMESTAMP WITH TIME ZONE")
    Date expiresAt;

    @Embedded
    Audit audit;
}

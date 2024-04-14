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
    //TODO: crear equals and hashcode
    @EmbeddedId
    private AccountGroupPK id;

    @ManyToOne
    @JoinColumn(name = "uuid", insertable=false, updatable=false)
    Account account;

    @ManyToOne()
    @JoinColumn(name = "group_id", insertable=false, updatable=false)
    Group group;

    @Column(name = "expires_at", columnDefinition= "TIMESTAMP WITH TIME ZONE")
    Date expiresAt;

    @Embedded
    Audit audit;
}

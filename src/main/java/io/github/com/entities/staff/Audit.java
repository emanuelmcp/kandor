package io.github.com.entities.staff;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Embeddable
@Getter
@Setter
public class Audit {
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at", columnDefinition= "TIMESTAMP WITH TIME ZONE", nullable = false, updatable = false)
    Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "updated_at", columnDefinition= "TIMESTAMP WITH TIME ZONE")
    Date updatedAt;
}

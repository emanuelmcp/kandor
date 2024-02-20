package io.github.com.core.staff.groups.dto.input;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PermissionRelationsMetadataDTO implements Serializable {
    Boolean isNegated;
    @Size(max = 10)
    String world;
    Date expiresAt;
}

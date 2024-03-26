package io.github.com.dto.staff;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PermissionRelationsMetadataDTO implements Serializable {
    Boolean isNegated;
    String world;
    Date expiresAt;
}

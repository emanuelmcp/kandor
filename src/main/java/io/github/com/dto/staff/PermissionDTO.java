package io.github.com.dto.staff;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class PermissionDTO implements Serializable {
    Integer id;
    String name;
    String description;
}

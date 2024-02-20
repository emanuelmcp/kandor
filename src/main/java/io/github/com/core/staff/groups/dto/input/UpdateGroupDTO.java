package io.github.com.core.staff.groups.dto.input;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateGroupDTO implements Serializable {
    @Size(max = 10)
    String name;

    @Size(max = 100)
    String description;

    @Size(max = 3)
    String prefix;

    @Size(max = 3)
    String suffix;
}

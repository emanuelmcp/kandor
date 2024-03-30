package io.github.com.dto.staff;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CreateGroupDTO implements Serializable {
    String name;
    String description;
    String prefix;
    String suffix;
}

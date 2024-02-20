package io.github.com.core.staff.groups.dto.output;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
public class ReducedGroupDTO {
    Integer id;
    String name;
    String description;
    String prefix;
    String suffix;
}

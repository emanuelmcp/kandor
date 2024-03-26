package io.github.com.dto.staff;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateGroupDTO implements Serializable {
    String name;
    String description;
    String prefix;
    String suffix;
}

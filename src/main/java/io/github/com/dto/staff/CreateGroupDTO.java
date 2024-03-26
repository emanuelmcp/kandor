package io.github.com.dto.staff;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CreateGroupDTO implements Serializable {
    @NotNull
    @NotBlank
    @Size(max = 10)
    @Pattern(regexp = "^\\S*$", message = "El campo no debe contener espacios.")
    String name;

    @Size(max = 100)
    String description;

    @Size(max = 3)
    String prefix;

    @Size(max = 3)
    String suffix;
}

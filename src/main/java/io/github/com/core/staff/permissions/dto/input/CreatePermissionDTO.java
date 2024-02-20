package io.github.com.core.staff.permissions.dto.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class CreatePermissionDTO implements Serializable {
/*    @NotNull(message = "Este campo es obligatorio")
    @NotBlank(message = "El campo no puede estar vacio")
    @Max(message = "El nombre no puede tener mas de 5 caracteres", value = 5)
    @Schema*/
    String name;
    String description;
}

package io.github.com.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ApiResponseDTO implements Serializable {
    String id;
    String message;
}

package io.github.com.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class StringIdResponseDTO implements Serializable {
    String id;
    String message;
}

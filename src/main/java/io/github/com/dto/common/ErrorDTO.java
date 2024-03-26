package io.github.com.dto.common;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDTO implements Serializable {
    private String message;
    private Date date;
}

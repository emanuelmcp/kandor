package io.github.com.exceptions;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Error implements Serializable {
    private String message;
    private String errorCode;
    private int status;
    private Date date;
}

package io.github.com.dto.management;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class BanDTO implements Serializable {
	private String uuid;
	private String reason;
	private Integer expires;
}

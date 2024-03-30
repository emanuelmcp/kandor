package io.github.com.dto.work;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MoneyDTO {
	private int min;
	private int max;
	private double probability;
}

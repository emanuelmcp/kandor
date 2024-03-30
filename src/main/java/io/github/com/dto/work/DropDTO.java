package io.github.com.dto.work;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DropDTO {
	private String nbtTag;
	private int minQuantity;
	private int maxQuantity;
	private double probability;
}

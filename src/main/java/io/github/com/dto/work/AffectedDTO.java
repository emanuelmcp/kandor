package io.github.com.dto.work;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AffectedDTO {
	private String nbtTag;
	private RewardDTO reward;
}

package io.github.com.dto.work;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RewardDTO {
	private MoneyDTO money;
	private DropDTO drop;
}

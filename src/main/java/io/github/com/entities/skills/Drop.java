package io.github.com.entities.skills;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Drop {
	@Field("nbtTag")
	private String nbtTag;
	private int minQuantity;
	private int maxQuantity;
	private double probability;
}

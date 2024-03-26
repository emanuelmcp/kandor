package io.github.com.dto.staff;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class RelatedPermissionDTO implements Serializable {
	Integer id;
	String name;
	String description;
}

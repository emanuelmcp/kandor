package io.github.com.core.staff.groups.dto.output;

import io.github.com.core.staff.groups.dto.output.types.RelatedPermissionsDTO;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class FullGroupDTO implements Serializable {
	Integer id;
	String name;
	String description;
	String prefix;
	String suffix;
	List<RelatedPermissionsDTO> permissions;
}

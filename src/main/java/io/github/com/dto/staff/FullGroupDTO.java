package io.github.com.dto.staff;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class FullGroupDTO implements Serializable {
	Integer id;
	String name;
	String description;
	String prefix;
	String suffix;
	List<RelatedPermissionDTO> permissions;
}

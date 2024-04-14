package io.github.com.dto.staff;

import java.io.Serializable;
import java.util.List;

public class AccountDTO implements Serializable {
	String uuid;
	String password;
	String nick;
	List<RelatedPermissionDTO> permissions;
}

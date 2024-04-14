package io.github.com.services.interfaces;

import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.dto.staff.AccountDTO;

public interface AccountService {
	AccountDTO findByUUID(String UUID);
	AccountDTO findByNick(String nick);
	ApiResponseDTO addGroupToAccountByUUID(String UUID, Integer groupId);
	void deleteGroupToAccountByUUID(String UUID, Integer groupId);
	ApiResponseDTO addGroupToAccountByName(String nick, String groupName);
	void deleteGroupToAccountByName(String nick, String groupName);
	ApiResponseDTO addPermissionToAccountByUUID(String UUID, Integer permissionId);
	void deletePermissionToAccountByUUID(String UUID, Integer permissionId);
	ApiResponseDTO addPermissionToAccountByName(String nick, String permissionName);
	void deletePermissionToAccountByName(String nick, String permissionName);
	ApiResponseDTO addSkillToAccountByUUID(String UUID, String mongoId);
	void deleteSkillToAccountByUUID(String UUID, String mongoId);
	ApiResponseDTO addSkillToAccountByName(String nick, String skillName);
	void deleteSkillToAccountByName(String nick, String skillName);

}

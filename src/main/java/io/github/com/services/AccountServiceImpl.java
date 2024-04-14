package io.github.com.services;

import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.dto.staff.AccountDTO;
import io.github.com.repositories.staff.AccountRepository;
import io.github.com.repositories.staff.GroupRepository;
import io.github.com.repositories.staff.PermissionRepository;
import io.github.com.repositories.skills.SkillRepository;
import io.github.com.services.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountService {
	private final AccountRepository accountRepository;
	private final GroupRepository groupRepository;
	private final PermissionRepository permissionRepository;
	private final SkillRepository skillRepository;

	@Autowired
	public AccountServiceImpl(
		AccountRepository accountRepository,
		GroupRepository groupRepository,
		PermissionRepository permissionRepository,
		SkillRepository skillRepository
	) {
		this.accountRepository = accountRepository;
		this.groupRepository = groupRepository;
		this.permissionRepository = permissionRepository;
		this.skillRepository = skillRepository;
	}

	@Override
	public AccountDTO findByUUID(String UUID) {
		return null;
	}

	@Override
	public AccountDTO findByNick(String nick) {
		return null;
	}

	@Override
	public ApiResponseDTO addGroupToAccountByUUID(String UUID, Integer groupId) {
		return null;
	}

	@Override
	public void deleteGroupToAccountByUUID(String UUID, Integer groupId) {

	}

	@Override
	public ApiResponseDTO addGroupToAccountByName(String nick, String groupName) {
		return null;
	}

	@Override
	public void deleteGroupToAccountByName(String nick, String groupName) {

	}

	@Override
	public ApiResponseDTO addPermissionToAccountByUUID(String UUID, Integer permissionId) {
		return null;
	}

	@Override
	public void deletePermissionToAccountByUUID(String UUID, Integer permissionId) {

	}

	@Override
	public ApiResponseDTO addPermissionToAccountByName(String nick, String permissionName) {
		return null;
	}

	@Override
	public void deletePermissionToAccountByName(String nick, String permissionName) {

	}

	@Override
	public ApiResponseDTO addSkillToAccountByUUID(String UUID, String mongoId) {
		return null;
	}

	@Override
	public void deleteSkillToAccountByUUID(String UUID, String mongoId) {

	}

	@Override
	public ApiResponseDTO addSkillToAccountByName(String nick, String skillName) {
		return null;
	}

	@Override
	public void deleteSkillToAccountByName(String nick, String skillName) {

	}
}

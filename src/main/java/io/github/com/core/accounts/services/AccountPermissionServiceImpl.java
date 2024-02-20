package io.github.com.core.accounts.services;

import io.github.com.common.dto.output.StringIdResponseDTO;
import io.github.com.core.staff.groups.dto.input.PermissionRelationsMetadataDTO;
import io.github.com.entities.staff.keys.AccountPermissionPK;
import io.github.com.entities.staff.Account;
import io.github.com.entities.staff.AccountPermission;
import io.github.com.entities.staff.Permission;
import io.github.com.exceptions.errors.EntityAlreadyExistsException;
import io.github.com.exceptions.errors.EntityAssociationException;
import io.github.com.repositories.staff.AccountPermissionRepository;
import io.github.com.repositories.staff.AccountRepository;
import io.github.com.repositories.staff.PermissionRepository;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("unused")
@Service
public class AccountPermissionServiceImpl implements AccountPermissionService {

    private final AccountRepository accountRepository;
    private final PermissionRepository permissionRepository;
    private final AccountPermissionRepository accountPermissionRepository;

    @Autowired
    public AccountPermissionServiceImpl(AccountRepository accountRepository, PermissionRepository permissionRepository, AccountPermissionRepository accountPermissionRepository) {
        this.accountRepository = accountRepository;
        this.permissionRepository = permissionRepository;
        this.accountPermissionRepository = accountPermissionRepository;
    }

    @Override
    @Transactional
    public StringIdResponseDTO addPermissionToAccountById(String uuid, Integer idPermission, @NotNull PermissionRelationsMetadataDTO dto) {
        Account account = accountRepository
                .findById(uuid)
                .orElseThrow(() -> new EntityAssociationException("El jugador con el uuid " + uuid + " no existe"));
        Permission permission = permissionRepository
                .findById(idPermission)
                .orElseThrow(() -> new EntityAssociationException("El permiso con el id " + idPermission + " no existe"));
        AccountPermissionPK accountPermissionPK = new AccountPermissionPK(account.getUuid(), permission.getId());
        accountPermissionRepository
                .findById(accountPermissionPK)
                .ifPresent((groupPermission -> {
                    throw new EntityAlreadyExistsException("El jugador " + account.getNick() + " ya tiene el permiso " + permission.getName() + " asociado");
                }));
        accountPermissionRepository.save(
                AccountPermission
                        .builder()
                        .id(accountPermissionPK)
                        .permission(permission)
                        .account(account)
                        .world(dto.getWorld())
                        .isNegated(dto.getIsNegated())
                        .expiresAt(dto.getExpiresAt())
                        .build());
        return new StringIdResponseDTO(
                account.getUuid(),
                "Al jugador " + account.getNick() + " se le ha añadido el permiso " + permission.getName()
        );
    }

    @Override
    @Transactional
    public void deletePermissionFromAccountById(String uuid, Integer idPermission) {
        Account group = accountRepository
                .findById(uuid)
                .orElseThrow(() -> new EntityAssociationException("El jugador con el uuid " + uuid + " no existe"));
        Permission permission = permissionRepository
                .findById(idPermission)
                .orElseThrow(() -> new EntityAssociationException("El permiso con el id " + idPermission + " no existe"));
        accountPermissionRepository.deleteById(new AccountPermissionPK(group.getUuid(), permission.getId()));
    }

    @Override
    @Transactional
    public StringIdResponseDTO addPermissionToAccountByNick(String nick, String permissionName, @NotNull PermissionRelationsMetadataDTO dto) {
        Account account = accountRepository
                .findByNick(nick)
                .orElseThrow(() -> new EntityAssociationException("El jugador con el nick " + nick + " no existe"));
        Permission permission = permissionRepository
                .findByName(permissionName)
                .orElseThrow(() -> new EntityAssociationException("El permiso con el nombre " + permissionName + " no existe"));
        AccountPermissionPK accountPermissionPK = new AccountPermissionPK(account.getUuid(), permission.getId());
        accountPermissionRepository
                .findById(accountPermissionPK)
                .ifPresent((groupPermission -> {
                    throw new EntityAlreadyExistsException("El jugador " + account.getNick() + " ya tiene el permiso " + permission.getName() + " asociado");
                }));
        accountPermissionRepository.save(
                AccountPermission
                        .builder()
                        .id(accountPermissionPK)
                        .permission(permission)
                        .account(account)
                        .world(dto.getWorld())
                        .isNegated(dto.getIsNegated())
                        .expiresAt(dto.getExpiresAt())
                        .build()
        );
        return new StringIdResponseDTO(
                account.getUuid(),
                "Al jugador " + account.getNick() + " se le ha añadido el permiso " + permission.getName()
        );
    }

    @Override
    @Transactional
    public void deletePermissionFromAccountByNick(String nick, String permissionName) {
        Account account = accountRepository
                .findByNick(nick)
                .orElseThrow(() -> new EntityAssociationException("El jugador con el nick " + nick + " no existe"));
        Permission permission = permissionRepository
                .findByName(permissionName)
                .orElseThrow(() -> new EntityAssociationException("El permiso con el nombre " + permissionName + " no existe"));
        accountPermissionRepository.deleteById(new AccountPermissionPK(account.getUuid(), permission.getId()));
    }
}

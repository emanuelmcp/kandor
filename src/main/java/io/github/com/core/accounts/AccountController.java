package io.github.com.core.accounts;

import io.github.com.core.accounts.services.AccountGroupService;
import io.github.com.core.accounts.services.AccountPermissionService;
import io.github.com.core.accounts.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;
    private final AccountGroupService accountGroupService;
    private final AccountPermissionService accountPermissionService;

    @Autowired
    public AccountController(AccountService accountService, AccountGroupService accountGroupService, AccountPermissionService accountPermissionService) {
        this.accountService = accountService;
        this.accountGroupService = accountGroupService;
        this.accountPermissionService = accountPermissionService;
    }
}

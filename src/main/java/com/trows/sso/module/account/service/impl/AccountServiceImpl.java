package com.trows.sso.module.account.service.impl;

import com.trows.sso.common.baseService.AbstractBaseServiceImpl;
import com.trows.sso.model.Account;
import com.trows.sso.module.account.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * Created by trows on 17-3-20.
 * 账户信息服务
 */
@Service
public class AccountServiceImpl extends AbstractBaseServiceImpl<Account, Long> implements AccountService {
}

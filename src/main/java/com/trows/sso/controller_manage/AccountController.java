package com.trows.sso.controller_manage;

import com.trows.sso.module.account.service.AccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



/**
 * Created by trows on 17-3-20.
 * 管理端account 控制器
 */
@Controller
@RequestMapping(value = "/manage/account")
public class AccountController {

    private static final Logger logger = LogManager.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/index")
    public ModelAndView toIndex(){
        ModelAndView modelAndView = new ModelAndView("/index");
        logger.error("trows get it");
        accountService.get(0L);
        return modelAndView;
    }

}

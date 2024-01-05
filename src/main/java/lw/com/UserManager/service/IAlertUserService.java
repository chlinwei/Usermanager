package lw.com.UserManager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import lw.com.UserManager.domain.login.dto.LoginParams;
import lw.com.UserManager.domain.login.entity.User;

public interface IAlertUserService extends IService<User> {
    String login(LoginParams loginParams);

}
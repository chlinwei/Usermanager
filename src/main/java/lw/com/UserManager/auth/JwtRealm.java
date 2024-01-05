package lw.com.UserManager.auth;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.jsonwebtoken.Claims;
import lw.com.UserManager.domain.login.entity.User;
import lw.com.UserManager.service.IAlertUserService;
import lw.com.UserManager.service.impl.AlertUserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class JwtRealm extends AuthorizingRealm  {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AlertUserServiceImpl alertUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        var jwt_token = (String)authenticationToken.getCredentials();
        var username = jwtUtil.getClaimsByToken(jwt_token);
        User user = alertUserService.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername,username));
        if (Objects.isNull(user)) {
            throw new AuthenticationException("用户不存在");
        }
        if(user.getStatus()==1) {
            throw new AuthenticationException("用户被锁定");
        }
        Claims claims = jwtUtil.getClaimsByToken(jwt_token);
        if (jwtUtil.isTokenExpired(claims.getExpiration())) {
            throw new AuthenticationException("token过期，请重新登录");
        }
        return new SimpleAuthenticationInfo(user,jwt_token,getName());
    }
}

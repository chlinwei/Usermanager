package lw.com.UserManager.auth;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;


@Data
public class JwtToken implements AuthenticationToken {
    private String username;
    private String token;

    @Autowired
    private  JwtUtil jwtUtil;
    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
    public JwtToken(String token){
        this.token = token;
        this.username = jwtUtil.getClaimFiled(token, "username");
    }
}

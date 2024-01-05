package lw.com.UserManager.domain.login.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;



@Data
@TableName("alert_user")
public class User implements Serializable {
        @TableId
        private Long id;
        private String username;
        private String nickname;
        private String email;
        private Integer sex;
        private String avatar;
        private String password;
        private Integer status;
        private Long creator;
        private Long updater;
        private LocalDateTime createTime;
        private LocalDateTime updateTime;
        @TableLogic
        private Integer deleted;
        private String remark;
}


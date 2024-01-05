package lw.com.UserManager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lw.com.UserManager.domain.login.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface RoleMapper extends BaseMapper<UserRole> {
}
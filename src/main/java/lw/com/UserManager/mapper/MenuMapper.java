package lw.com.UserManager.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import lw.com.UserManager.domain.login.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    Set<Menu> selectMenuByRoleId(@Param("roleIds") Set<Long> roleIds);
}
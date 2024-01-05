package lw.com.UserManager.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lw.com.UserManager.domain.login.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
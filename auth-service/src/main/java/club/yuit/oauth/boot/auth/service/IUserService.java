package club.yuit.oauth.boot.auth.service;

import club.yuit.oauth.boot.auth.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author yuit
 * @date 2018/10/9  16:55
 *
 **/
public interface IUserService  extends IService<User> {

    /**
     * 获取所有用户
     * @return
     */
    public List<User> getUsers();


    User findByUserName(String userName);

}

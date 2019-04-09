package club.yuit.oauth.boot.auth.support;


import club.yuit.oauth.boot.auth.entity.User;
import club.yuit.oauth.boot.auth.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuit
 * @date time 2018/10/11  9:13
 *
 **/
@Service
public final class BootUserDetailService implements UserDetailsService {


    private IUserService userService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public BootUserDetailService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user= this.userService.findByUserName(username);

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");

        List <GrantedAuthority>authorities = new ArrayList<>();
        authorities.add(authority);
        user.setAuthorities(authorities);

        if(user==null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        return user;
    }
}

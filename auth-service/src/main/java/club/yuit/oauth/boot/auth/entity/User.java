package club.yuit.oauth.boot.auth.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @author yuit
 * @date 2018/10/9  15:43
 *
 **/
@Data
@TableName("user")
public class User implements UserDetails {
    @TableId
    private String id;
    private String username;
    private String email;
    @TableField("isEnable")
    private Boolean isEnable;
    @TableField("isExpired")
    private Boolean isExpired;
    @TableField("isLocked")
    private Boolean isLocked;
    private String password;
    private String gender;

    @TableField(exist = false)
    private List<GrantedAuthority> authorities;


    public List<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    public boolean isAccountNonExpired() {
        return true;
    }


    public boolean isAccountNonLocked() {
        return this.isLocked;
    }


    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return this.isEnable;
    }
}

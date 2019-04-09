package club.yuit.oauth.boot;

import club.yuit.oauth.boot.support.common.TokenStoreType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author yuit
 * @date 2019/4/8 17:09
 */
@SpringBootApplication
@MapperScan("club.yuit.oauth.boot.auth.mapper")
public class AuthServiceApplication {

    public static void main(String[] args){
        SpringApplication.run(AuthServiceApplication.class,args);
    }

}

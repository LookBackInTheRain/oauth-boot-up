package club.yuit.oauth.boot.support.common;

import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author yuit
 * @date 2018/10/19 10:57
 */
public enum TokenStoreType {
    /*
        内存
     */
    memory("memory"),
    /*
        redis
     */
    redis("redis"),
    /*
        json web token
     */
    jwt("jwt"),
    /*
        SQL数据库
     */
    jdbc("jdbc");

    public String value;

    TokenStoreType(String value){
            this.value=value;
    }

}

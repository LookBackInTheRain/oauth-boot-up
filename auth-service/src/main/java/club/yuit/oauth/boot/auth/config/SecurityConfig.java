package club.yuit.oauth.boot.auth.config;

import club.yuit.oauth.boot.auth.filter.BootPictureCodeAuthenticationFilter;
import club.yuit.oauth.boot.auth.support.BootUserDetailService;
import club.yuit.oauth.boot.support.BootLoginFailureHandler;
import club.yuit.oauth.boot.support.BootSecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author yuit
 * @date 2018/10/10  11:48
 **/
@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private BootUserDetailService userDetailService;


    private BootSecurityProperties properties;


    private BootLoginFailureHandler handler;

    private BootPictureCodeAuthenticationFilter pictureCodeAuthenticationFilter;


    public SecurityConfig(BootUserDetailService userDetailService, BootSecurityProperties properties, BootLoginFailureHandler handler, BootPictureCodeAuthenticationFilter pictureCodeAuthenticationFilter) {
        this.userDetailService = userDetailService;
        this.properties = properties;
        this.handler = handler;
        this.pictureCodeAuthenticationFilter = pictureCodeAuthenticationFilter;
    }

    /**
     * 让Security 忽略这些url，不做拦截处理
     *
     * @param
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers
                ("/swagger-ui.html/**", "/webjars/**",
                        "/swagger-resources/**", "/v2/api-docs/**",
                        "/swagger-resources/configuration/ui/**", "/swagger-resources/configuration/security/**",
                        "/images/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .authorizeRequests()
                // 自定义页面或处理url是，如果不配置全局允许，浏览器会提示服务器将页面转发多次
                .antMatchers(properties.getLoginPage(), properties.getLoginProcessUrl(),"/favicon.ico","/statics/**","/picture_code")
                .permitAll()
                .anyRequest()
                .authenticated();

        // 表单登录
        http.formLogin()
                //.failureHandler(handler)
                // 页面
                .loginPage(properties.getLoginPage())
                // 登录处理url
                .loginProcessingUrl(properties.getLoginProcessUrl());

        // 用户密码验证之前校验验证码
        http.addFilterBefore(pictureCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        http.httpBasic().disable();
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}

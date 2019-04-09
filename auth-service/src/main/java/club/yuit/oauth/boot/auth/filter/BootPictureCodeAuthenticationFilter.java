package club.yuit.oauth.boot.auth.filter;

import club.yuit.oauth.boot.support.BootSecurityProperties;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.PathMatcher;

/**
 * @author yuit
 * @date 2019/4/9 16:10
 */
public class BootPictureCodeAuthenticationFilter extends OncePerRequestFilter {


    private PathMatcher pathMatcher;
    private BootSecurityProperties properties;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //本次请求url
        String path = request.getRequestURI();
        // 图片验证码值
        String pCode = request.getParameter(properties.getPictureCodeParameterName());

        if (path.trim().equals(properties.getLoginProcessUrl())
                && pCode != null) {

        }
    }


}

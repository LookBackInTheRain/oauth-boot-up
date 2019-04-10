package club.yuit.oauth.boot.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**
 * @author yuit
 * @date  2018/10/9  15:08
 **/
@Configuration
public class CoreConfig extends WebMvcConfigurationSupport {



    /**
     * Could not resolve view with name 'forward:/oauth/confirm_access' in servlet with name 'dispatcherServlet'
     *
     */
    /*@Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(new InternalResourceViewResolver());
    }*/

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics/**")
                .addResourceLocations("classpath:/statics/");
    }
}

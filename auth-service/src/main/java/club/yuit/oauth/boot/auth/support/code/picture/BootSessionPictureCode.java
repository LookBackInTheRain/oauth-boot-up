package club.yuit.oauth.boot.auth.support.code.picture;

import club.yuit.oauth.boot.auth.support.code.BootCode;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author yuit
 * @date 2019/4/9 18:09
 */
public class BootSessionPictureCode implements BootCode<String> {



    public BootSessionPictureCode() {


    }

    @Override
    public String getCodeValue(String key) {
        HttpServletRequest request = ((ServletRequestAttributes)
                Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        HttpSession session = request.getSession();
        return (String) session.getAttribute(key);
    }

    @Override
    public void setCodeValue(String key, String value) {
        HttpServletRequest request = ((ServletRequestAttributes)
                Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        HttpSession session = request.getSession();
        session.setAttribute(key,value);
    }

}

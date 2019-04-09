package club.yuit.oauth.boot.auth.support.code;

import javax.servlet.http.HttpSession;

/**
 * @author yuit
 * @date 2019/4/9 18:09
 */
public class BootSessionPictureCode implements BootCode<String> {

    private HttpSession session;


    public BootSessionPictureCode() {
        session.setMaxInactiveInterval(10000);
    }

    @Override
    public String getCodeValue(String key) {
        return (String) this.session.getAttribute(key);
    }

    @Override
    public void setCodeValue(String key, String value) {
        this.session.setAttribute(key,value);
    }

}

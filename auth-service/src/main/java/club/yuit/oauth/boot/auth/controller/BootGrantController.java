package club.yuit.oauth.boot.auth.controller;

import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author yuit
 * @date 2018/11/1 11:44
 *
 */
@Controller
@SessionAttributes("authorizationRequest")
public class BootGrantController {

    @RequestMapping("/custom/confirm_access")
    public ModelAndView getAccessConfirmation(Map<String, Object> model, HttpServletRequest request) throws Exception {

        AuthorizationRequest authorizationRequest = (AuthorizationRequest) model.get("authorizationRequest");


        ModelAndView view = new ModelAndView();
        view.setViewName("base-grant");

        view.addObject("clientId", authorizationRequest.getClientId());
        view.addObject("scopes",authorizationRequest.getScope());

        return view;
    }

}

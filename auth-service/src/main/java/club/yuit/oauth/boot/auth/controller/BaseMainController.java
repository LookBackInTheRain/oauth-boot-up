package club.yuit.oauth.boot.auth.controller;

import club.yuit.oauth.boot.auth.support.code.picture.BootSessionPictureCode;
import club.yuit.oauth.boot.auth.support.code.picture.PictureCodeGenerator;
import club.yuit.oauth.boot.support.BootSecurityProperties;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author yuit
 * @date  2018/10/9  15:09
 *
 **/
@Controller
public class BaseMainController {


    @Autowired
    private BootSecurityProperties properties;

    @GetMapping("/auth/login")
    public String loginPage(Model model){

        model.addAttribute("loginProcessUrl",properties.getLoginProcessUrl());

        return "base-login";
    }

    @GetMapping("/")
    @ResponseBody
    public String index(HttpSession session){

        BootSessionPictureCode pictureCode = new BootSessionPictureCode();

        String code= pictureCode.getCodeValue("p_code");

        return "index";
    }

    @GetMapping("/picture_code")
    public void pictureCodeGenerate(HttpServletResponse response) throws IOException {
        PictureCodeGenerator.generate(response);
    }





}

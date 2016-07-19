package com.bova.services.controllers.example;

import com.bova.services.controllers.AbstractController;
import com.bova.services.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Myko Bova
 */
@Controller
@RequestMapping("example/login")
public class LoginController extends AbstractController {

    @RequestMapping(path = "/oauth/token", method = RequestMethod.GET)
    @ResponseBody
    public String getToken(@RequestParam("grant_type") String grant_type, @RequestParam("client_id") String client_id, @RequestParam("client_secret") String client_secret, @RequestParam(value = "refresh_token", required = false) String refresh_token ){
        return FileUtil.readJsonFile("repositories/example/login/loginTokenResponse");
    }
}

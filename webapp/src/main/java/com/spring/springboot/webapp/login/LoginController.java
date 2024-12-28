package com.spring.springboot.webapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String goToLogin(){
        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model){
        if(authenticationService.authenticate(name,password)) {
            model.put("name", name);
//            model.put("password", password);
            return "welcome";
        }
        model.put("errorMessage","Invalid Credentials!");
        return "login";
    }
}

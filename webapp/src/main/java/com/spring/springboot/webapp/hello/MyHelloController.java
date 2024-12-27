package com.spring.springboot.webapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyHelloController {

    @RequestMapping("/say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello! What are u learning today?";
    }

    @RequestMapping("/say-hello-html")
    @ResponseBody                               // to return directly
    public String sayHelloHtml(){
        StringBuffer st = new StringBuffer();
        st.append("<html>");
        st.append("<head>");
        st.append("<title>This is first page </title>");
        st.append("</head>");
        st.append("<body> This is body</body>");
        st.append("</html>");
        return st.toString();
    }

    // say-hello-jsp => sayHello.jsp
    //src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    @RequestMapping("/say-hello-jsp")
    public String sayHelloJsp(){
        return "sayHello";
    }
}

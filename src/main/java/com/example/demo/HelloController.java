package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String index(){
        return "Hello World";
    }

    @GetMapping(value = "/")
    public String index(ModelMap map){
        map.addAttribute("host","www.baidu.com");
        return "index";
    }
}

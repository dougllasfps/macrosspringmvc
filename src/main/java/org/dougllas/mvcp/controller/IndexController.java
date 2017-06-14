package org.dougllas.mvcp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Criado por dougllas.sousa em 05/06/2017.
 */

@Controller
public class IndexController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(Model model){
        model.addAttribute("nome", "Dougllas");
        return "hello";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String sayHelloNome( @ModelAttribute("nome") String nome){
        System.out.println(nome);
        return "hello";
    }
}

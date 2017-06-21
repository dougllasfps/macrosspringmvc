package org.dougllas.mvcp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Criado por dougllas.sousa em 21/06/2017.
 */

@Controller
@RequestMapping("/")
public class ApplicationController {

    @RequestMapping("/alimentos")
    public String alimentos(Model model){
        return "alimentos/list";
    }
}

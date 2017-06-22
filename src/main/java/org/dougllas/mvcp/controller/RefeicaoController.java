package org.dougllas.mvcp.controller;

import org.dougllas.mvcp.model.Refeicao;
import org.dougllas.mvcp.service.RefeicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;

/**
 * Criado por dougllas.sousa em 22/06/2017.
 */

@Controller
public class RefeicaoController implements Serializable{

    @Autowired
    private RefeicaoService refeicaoService;

    @RequestMapping(value = "/refeicoes", method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("refeicoes/list");
        model.addObject("filtro", new Refeicao());
        return model;
    }
}
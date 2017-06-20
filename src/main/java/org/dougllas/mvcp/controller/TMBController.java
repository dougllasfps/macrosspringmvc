package org.dougllas.mvcp.controller;

import org.dougllas.mvcp.model.TMB;
import org.dougllas.mvcp.service.TMBService;
import org.dougllas.mvcp.view.converter.CalendarConverter;
import org.dougllas.mvcp.view.converter.MoneyConverter;
import org.dougllas.mvcp.view.messages.ViewMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Criado por dougllas.sousa em 20/06/2017.
 */

@Controller
public class TMBController implements Serializable{

    @Autowired
    private TMBService tmbService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor( Calendar.class, new CalendarConverter() );
        binder.registerCustomEditor( Double.class, new MoneyConverter() );
    }

    @RequestMapping(value = "/tmb", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("tmb", new TMB());
        model.addAttribute("list", tmbService.findAll());
        return "tmb/list";
    }

    @RequestMapping(value = "/tmb/add",method = RequestMethod.POST)
    public String add( @ModelAttribute("tmb") TMB tmb, RedirectAttributes attributes ){
        tmbService.save(tmb);
        attributes.addFlashAttribute("msg", ViewMessage.infoMessage("Salvo com sucesso!"));
        return "redirect:/tmb";
    }

    @RequestMapping(value = "/tmb/remove/{id}", method = RequestMethod.GET)
    public String remove( @PathVariable("id") Integer id, RedirectAttributes attributes){
        TMB deleted = tmbService.findById(id);
        tmbService.delete(deleted);
        attributes.addFlashAttribute("msg", ViewMessage.infoMessage("Deletado com sucesso!"));
        return "redirect:/tmb";
    }

    @RequestMapping(value = "/tmb/editar/{id}", method = RequestMethod.GET)
    public String prepareUpdate( @PathVariable("id") Integer id, Model model){
        TMB tmb = tmbService.findById(id);
        model.addAttribute("tmb", tmb);
        return "tmb/list";
    }
}
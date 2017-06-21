package org.dougllas.mvcp.controller;

import org.dougllas.mvcp.model.TMB;
import org.dougllas.mvcp.service.TMBService;
import org.dougllas.mvcp.view.converter.CalendarPropertyEditor;
import org.dougllas.mvcp.view.converter.DecimalPropertyEditor;
import org.dougllas.mvcp.view.messages.ViewMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
        binder.registerCustomEditor( Calendar.class, new CalendarPropertyEditor() );
        binder.registerCustomEditor( Double.class, new DecimalPropertyEditor(3) );
    }

    @RequestMapping(value = "/tmb", method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("tmb/list");
        model.addObject("tmb", new TMB());
        model.addObject("list", tmbService.findAll());
        return model;
    }

    @RequestMapping(value = "/tmb/add",method = {RequestMethod.POST, RequestMethod.PUT})
    public String add(@Valid @ModelAttribute("tmb") TMB tmb, RedirectAttributes attributes ){
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
    public ModelAndView prepareUpdate( @PathVariable("id") Integer id){
        TMB tmb = tmbService.findById(id);
        ModelAndView model = new ModelAndView( "tmb/list");
        model.addObject("tmb", tmb);
        return model;
    }
}
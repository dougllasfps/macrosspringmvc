package org.dougllas.mvcp.controller;

import org.dougllas.mvcp.model.Alimento;
import org.dougllas.mvcp.service.AlimentoService;
import org.dougllas.mvcp.view.ViewMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.Serializable;
import java.util.List;

/**
 * Criado por dougllas.sousa em 07/06/2017.
 */

@Controller
public class AlimentoController implements Serializable {

    @Autowired
    private AlimentoService alimentoService;

    private void inicializaFiltroConsulta(Model model) {
        model.addAttribute("filtro", new Alimento());
    }

    @RequestMapping(value = "/alimentos", method = RequestMethod.GET)
    public String list( Model model ){
        inicializaFiltroConsulta(model);
        listAll(model);
        return "alimentos/list";
    }

    private void listAll(Model model) {
        model.addAttribute("list", alimentoService.findAll());
    }

    @RequestMapping(value = "/alimentos", method = RequestMethod.POST)
    public String find( @ModelAttribute("filtro") Alimento filtro, Model model ){
        model.addAttribute("filtro", filtro);
        List<Alimento> result = alimentoService.filter(filtro);
        model.addAttribute("list", result);

        if(CollectionUtils.isEmpty(result)){
            model.addAttribute("msg", ViewMessage.warnMessage("Nenhum Resultado."));
        }

        return "/alimentos/list";
    }

    @RequestMapping(value = "/alimentos/novo", method = RequestMethod.GET)
    public String prepareInsert( Model model ){
        model.addAttribute("bean", new Alimento());
        return "/alimentos/form";
    }

    @RequestMapping(value = "/alimentos/editar/{id}", method = RequestMethod.GET)
    public String prepareUpdate( @PathVariable("id") Integer id, Model model ){
        model.addAttribute("bean", alimentoService.findById(id));
        return "/alimentos/form";
    }

    @RequestMapping(value = "/alimentos/remove/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id, Model model){
        Alimento deleted = alimentoService.findById(id);
        alimentoService.delete(deleted);
        model.addAttribute("msg", ViewMessage.infoMessage("Deletado com sucesso!"));
        inicializaFiltroConsulta(model);
        listAll(model);
        return "redirect:/alimentos";
    }

    @RequestMapping(value = "/alimentos/add", method = RequestMethod.POST)
    public String saveOrUpdate(@ModelAttribute("bean") Alimento alimento, Model model, RedirectAttributes redirectAttributes){
        alimentoService.save(alimento);
        redirectAttributes.addFlashAttribute("msg", ViewMessage.infoMessage("Salvo com sucesso!"));
        inicializaFiltroConsulta(model);
        return "redirect:/alimentos";
    }
}
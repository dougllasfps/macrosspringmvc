package org.dougllas.mvcp.controller;

import org.dougllas.mvcp.model.Alimento;
import org.dougllas.mvcp.model.UnidadeMedida;
import org.dougllas.mvcp.service.AlimentoService;
import org.dougllas.mvcp.view.messages.ViewMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Criado por dougllas.sousa em 07/06/2017.
 */

@Controller
public class AlimentoController implements Serializable {

    @Autowired
    private AlimentoService alimentoService;

    @RequestMapping(value = "/alimentos", method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("alimentos/list");
        model.addObject("filtro", new Alimento());
        model.addObject("list", alimentoService.findAll());
        return model;
    }

    @RequestMapping(value = "/alimentos", method = RequestMethod.POST)
    public ModelAndView find( @ModelAttribute("descricao") String descricao ){
        Alimento filtro = new Alimento();
        filtro.setDescricao(descricao);
        List<Alimento> result = alimentoService.filter(filtro);

        ModelAndView model = new ModelAndView("/alimentos/list");
        model.addObject("list", result);

        if(CollectionUtils.isEmpty(result)){
            model.addObject("msg", ViewMessage.warnMessage("Nenhum Resultado."));
        }

        return model;
    }

    @RequestMapping(value = "/alimentos/novo", method = RequestMethod.GET)
    public ModelAndView prepareInsert(){
        ModelAndView model = new ModelAndView("/alimentos/form");
        model.addObject("bean", new Alimento());
        model.addObject("unidadesMedida", getUnidadesMedida());
        model.addObject("unidadeMedidaSelecionada", null);
        return model;
    }

    @RequestMapping(value = "/alimentos/editar/{id}", method = RequestMethod.GET)
    public ModelAndView prepareUpdate( @PathVariable("id") Integer id ){
        Alimento itemSelecionado = alimentoService.findById(id);

        ModelAndView model = new ModelAndView("/alimentos/form");
        model.addObject("bean", itemSelecionado);
        model.addObject("unidadesMedida", getUnidadesMedida());

        return model;
    }

    @RequestMapping(value = "/alimentos/remove/{id}", method = RequestMethod.POST)
    public ModelAndView delete( @PathVariable("id") Integer id ){
        if(id != null) {
            final Alimento deleted = alimentoService.findById(id);
            if(deleted != null)
                alimentoService.delete(deleted);
        }
        ModelAndView model = new ModelAndView("/alimentos");
        model.addObject("msg", ViewMessage.infoMessage("Deletado com sucesso!"));
        model.addObject("list", alimentoService.findAll());

        return model;
    }

    @RequestMapping(value = "/alimentos/add", method = {RequestMethod.POST, RequestMethod.PUT})
    public String saveOrUpdate(
            @Valid
            @ModelAttribute("bean")
            Alimento alimento,
            RedirectAttributes redirectAttributes){

        alimentoService.save(alimento);
        redirectAttributes.addFlashAttribute("msg", ViewMessage.infoMessage("Salvo com sucesso!"));

        ModelAndView model = new ModelAndView("redirect:/alimentos");
        model.addObject("filtro", new Alimento());
        return "redirect:/alimentos";
    }

    private Map getUnidadesMedida(){
        Map<UnidadeMedida, String> unidades = new LinkedHashMap(UnidadeMedida.values().length);
        unidades.put(null, "Selecione...");

        for (UnidadeMedida unidadeMedida : UnidadeMedida.values()) {
            unidades.put(unidadeMedida, unidadeMedida.getDesc());
        }

        return unidades;
    }
}
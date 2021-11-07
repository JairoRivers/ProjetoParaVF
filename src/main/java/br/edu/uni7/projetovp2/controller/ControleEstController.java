package br.edu.uni7.projetovp2.controller;

import br.edu.uni7.projetovp2.model.ControleEst;
import br.edu.uni7.projetovp2.repository.ControleEstRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ControleEstController {

    private final ControleEstRepository repository;

    @Autowired
    public ControleEstController(ControleEstRepository repository){
        this.repository = repository;
    }

    @ResponseBody
    @RequestMapping(value = "controle", method = RequestMethod.GET)
    public List<ControleEst> list (){
        return repository.list();
    }

    @ResponseBody
    @RequestMapping(value = "controle/{id}", method = RequestMethod.GET)
    public ControleEst findById (@PathVariable Integer id){
        return repository.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "controle", method = RequestMethod.POST)
    public ControleEst create (@RequestBody ControleEst controle){
        repository.create(controle);
        return controle;
    }

    @ResponseBody
    @RequestMapping(value = "controle/{id}", method = RequestMethod.PUT)
    public void update (@PathVariable Integer id, @RequestBody ControleEst controle){
        repository.update(id, controle);
    }

    @ResponseBody
    @RequestMapping(value = "controle/{id}")
    public void remove (@PathVariable Integer id){
        repository.remove(id);
    }
}

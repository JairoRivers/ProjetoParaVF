package br.edu.uni7.projetovp2.controller;

import br.edu.uni7.projetovp2.model.RegistroDeServ;
import br.edu.uni7.projetovp2.repository.RegistroDeServRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RegistroDeServController {

    private final RegistroDeServRepository repository;

    @Autowired
    public RegistroDeServController(RegistroDeServRepository repository){
        this.repository = repository;
    }

    @ResponseBody
    @RequestMapping(value = "registro", method = RequestMethod.GET)
    public List<RegistroDeServ> list (){
        return repository.list();
    }

    @ResponseBody
    @RequestMapping(value = "registro/{idReg}", method = RequestMethod.GET)
    public RegistroDeServ findByIdReg (@PathVariable Integer idReg){
        return repository.findByIdReg(idReg);
    }

    @ResponseBody
    @RequestMapping(value = "registro", method = RequestMethod.POST)
    public RegistroDeServ create (@RequestBody RegistroDeServ registro){
        repository.create(registro);
        return registro;
    }

    @ResponseBody
    @RequestMapping(value = "registro/{idReg}", method = RequestMethod.PUT)
    public void update (@PathVariable Integer idReg, @RequestBody RegistroDeServ registro){
        repository.update(idReg, registro);
    }

    @ResponseBody
    @RequestMapping(value = "registro/{idReg}")
    public void remove (@PathVariable Integer idReg){
        repository.remove(idReg);
    }
}

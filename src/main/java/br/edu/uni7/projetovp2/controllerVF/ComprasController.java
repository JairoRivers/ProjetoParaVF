package br.edu.uni7.projetovp2.controllerVF;

import br.edu.uni7.projetovp2.modelVF.Compras;
import br.edu.uni7.projetovp2.modelVF.Produto;
import br.edu.uni7.projetovp2.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ComprasController {
    private final ComprasService service;

    @Autowired
    public ComprasController(ComprasService service) {
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "compras", method = RequestMethod.GET)
    public List<Compras> list() {
        return service.list();
    }

    @ResponseBody
    @RequestMapping(value = "compras/{id}", method = RequestMethod.GET)
    public Compras findById(@PathVariable String id) {
        return service.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "compras", method = RequestMethod.POST)
    public Compras create(@RequestBody Compras compras) {
        return service.create(compras);
    }

    @ResponseBody
    @RequestMapping(value = "compras/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Integer id, @RequestBody Compras compras) {
        service.update(compras);
    }

    @ResponseBody
    @RequestMapping("compras/{id}")
    public void remove(@PathVariable String id) {
        service.remove(id);
    }
}

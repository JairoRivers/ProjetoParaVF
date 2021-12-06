package br.edu.uni7.projetovp2.controllerVF;

import br.edu.uni7.projetovp2.modelVF.Produto;
import br.edu.uni7.projetovp2.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProdutoController {

    private final ProdutoService service;

    @Autowired
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "produto", method = RequestMethod.GET)
    public List<Produto> list() {
        return service.list();
    }

    @ResponseBody
    @RequestMapping(value = "produto/{id}", method = RequestMethod.GET)
    public Produto findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "produto/semEstoque/{id}", method = RequestMethod.GET)
    public List<Produto> findByQuantidade(@PathVariable Integer id) {
        return service.findByQuantidade(id);
    }

    @ResponseBody
    @RequestMapping(value = "produto/codigo/{codigo}", method = RequestMethod.GET)
    public Produto findByCodigo(@PathVariable Integer codigo) {
        return service.findByCodigo(codigo);
    }

    @ResponseBody
    @RequestMapping(value = "produto/categoria/{categoria}", method = RequestMethod.GET)
    public List<Produto> findByCategoria(@PathVariable String categoria) {
        return service.findByCategoria(categoria);
    }

    @ResponseBody
    @RequestMapping(value = "produto", method = RequestMethod.POST)
    public Produto create(@RequestBody Produto produto) {
        return service.create(produto);
    }

    @ResponseBody
    @RequestMapping(value = "produto/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Integer id, @RequestBody Produto produto) {
        service.update(produto);
    }

    @ResponseBody
    @RequestMapping("produto/{id}")
    public void remove(@PathVariable Integer id) {
        service.remove(id);
    }
}

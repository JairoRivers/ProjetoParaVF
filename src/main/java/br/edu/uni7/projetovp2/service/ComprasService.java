package br.edu.uni7.projetovp2.service;

import br.edu.uni7.projetovp2.modelVF.Compras;
import br.edu.uni7.projetovp2.modelVF.Produto;
import br.edu.uni7.projetovp2.repositoryVF.ComprasRepository;
import br.edu.uni7.projetovp2.repositoryVF.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ComprasService {
    private final ComprasRepository comprasRepository;
    private final ProdutoRepository produtoRepository;


    @Autowired
    public ComprasService (ComprasRepository comprasRepository, ProdutoRepository produtoRepository){
        this.comprasRepository = comprasRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<Compras> list() {
        return comprasRepository.findAll();
    }

    public Compras findById(String id) {
        return comprasRepository.findById(id).get();
    }

    public Compras create (Compras compras){
        comprasRepository.save(compras);

        Produto produtos = new Produto();

        produtoRepository.save(produtos);


        return compras;
    }

    public Compras update(Compras compras) {
        comprasRepository.save(compras);
        return compras;
    }

    public void remove(String id) {
        comprasRepository.deleteById(id);
    }
}

package br.edu.uni7.projetovp2.service;

import br.edu.uni7.projetovp2.Exception.ExceptionCompras;
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

    public List<Compras> findByCPF (int cpf) {
        return comprasRepository.findAllByListagemPorCPF(cpf);
    }

    public List<Compras> findByNT (String chaveNT) {
        return comprasRepository.findAllByListagemPorNotaFiscal(chaveNT);
    }

    public Compras create (Compras compras){
        List <Produto> produtos = compras.getProdutos();
        if (produtos != null) {
            for (Produto produto : produtos) {
                Produto produtoC = produtoRepository.findById(produto.getId()).get();
                if (produtoC.getQuantidade() == 0) {
                    throw new ExceptionCompras();
                }
            }
        }
        comprasRepository.save(compras);
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

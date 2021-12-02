package br.edu.uni7.projetovp2.service;

import br.edu.uni7.projetovp2.modelVF.Produto;
import br.edu.uni7.projetovp2.modelVF.Compras;
import br.edu.uni7.projetovp2.repositoryVF.ProdutoRepository;
import br.edu.uni7.projetovp2.repositoryVF.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ComprasRepository registroComprasRepository;

    @Autowired
    public ProdutoService (ProdutoRepository produtoRepository, ComprasRepository registroComprasRepository){
        this.produtoRepository = produtoRepository;
        this.registroComprasRepository = registroComprasRepository;
    }

    public List<Produto> list() {
        return produtoRepository.findAll();
    }

    public Produto findById(Integer id) {
        return produtoRepository.findById(id).get();
    }

    public List<Produto> findByQuantidade (Integer id) {
        if (produtoRepository.getById(id).getQuantidade() == 0) {
            return produtoRepository.findAllByProdutoEmFalta(id);
        }else{
            return null;
        }
    }

    public Produto findByCodigo (Integer codigo) {
        return produtoRepository.findAllByPrecoPeloCodigoDeBarra(codigo);
    }

    public List<Produto> findByCategoria (String categoria) {
        return produtoRepository.findAllByListagemPorCategoria(categoria);
    }


    public Produto create (Produto produto){
        produtoRepository.save(produto);

        Compras registroCompras = new Compras();
        registroComprasRepository.save(registroCompras);

        return produto;
    }

    public Produto update(Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    public void remove(Integer id) {
        produtoRepository.deleteById(id);
    }

}

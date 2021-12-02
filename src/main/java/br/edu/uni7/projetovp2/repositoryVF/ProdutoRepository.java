package br.edu.uni7.projetovp2.repositoryVF;

import br.edu.uni7.projetovp2.modelVF.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    List<Produto> findAllByProdutoEmFalta (Integer id);

    Produto findAllByPrecoPeloCodigoDeBarra(Integer codigoDebarras);

    List<Produto> findAllByListagemPorCategoria(String categoria);
}

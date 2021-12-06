package br.edu.uni7.projetovp2.repositoryVF;

import br.edu.uni7.projetovp2.modelVF.Compras;
import br.edu.uni7.projetovp2.modelVF.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComprasRepository extends MongoRepository<Compras, String> {

    List<Compras> findAllByListagemPorCPF(int cpf);

    List<Compras> findAllByListagemPorNotaFiscal (String chaveNT);

}

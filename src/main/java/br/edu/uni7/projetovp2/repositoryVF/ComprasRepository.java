package br.edu.uni7.projetovp2.repositoryVF;

import br.edu.uni7.projetovp2.modelVF.Compras;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprasRepository extends MongoRepository<Compras, String> {

}

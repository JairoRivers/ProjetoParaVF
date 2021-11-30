package br.edu.uni7.projetovp2.repository;


import br.edu.uni7.projetovp2.model.Peca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PecaRepository extends JpaRepository <Peca, Integer> {

    List<Peca> findAllByFabricanteAndQuantidadeGreaterThan(String fabricante, Integer quantidade);

}

package br.edu.uni7.projetovp2.repositoryVF;

import br.edu.uni7.projetovp2.modelVF.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {




}

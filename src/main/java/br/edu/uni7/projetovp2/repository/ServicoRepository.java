package br.edu.uni7.projetovp2.repository;


import br.edu.uni7.projetovp2.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}
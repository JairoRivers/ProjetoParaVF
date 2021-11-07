package br.edu.uni7.projetovp2.repository;


import br.edu.uni7.projetovp2.model.ControleEst;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Repository
public class ControleEstRepository {

    private static int proximoId = 1;
    private final Map<Integer, ControleEst> controles;

    public ControleEstRepository(){
        this.controles = new HashMap<>();
    }

    public ControleEst findById (Integer id){
        return controles.get(id);
    }

    public List <ControleEst> list(){
        return new ArrayList<>(controles.values());
    }

    public void create (ControleEst controle){
        int id = proximoId++;
        controle.setId(id);

        controles.put(id, controle);
    }

    public void update (Integer id, ControleEst controle){
        controles.put(id, controle);
    }

    public void remove (Integer id){
        controles.remove(id);
    }

}

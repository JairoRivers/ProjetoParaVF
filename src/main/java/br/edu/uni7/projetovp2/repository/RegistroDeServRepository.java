package br.edu.uni7.projetovp2.repository;


import br.edu.uni7.projetovp2.model.RegistroDeServ;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


@Repository
public class RegistroDeServRepository {
    private final Map<Integer, RegistroDeServ> registros;
    private static int proximoIdReg = 1;

    public RegistroDeServRepository(){
        this.registros = new HashMap<>();
    }

    public RegistroDeServ findByIdReg (Integer idReg){
        return registros.get(idReg);
    }

    public List<RegistroDeServ> list(){
        return new ArrayList<>(registros.values());
    }

    public void create (RegistroDeServ registro){
        int idReg = proximoIdReg++;
        registro.setIdReg(idReg);

        registros.put(idReg, registro);
    }

    public void update (Integer idReg, RegistroDeServ registro){
        registros.put(idReg, registro);
    }

    public void remove (Integer idReg){
        registros.remove(idReg);
    }




}

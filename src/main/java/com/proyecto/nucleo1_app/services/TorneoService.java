package com.proyecto.nucleo1_app.services;

import com.proyecto.nucleo1_app.models.Torneo;
import com.proyecto.nucleo1_app.repository.TorneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TorneoService {

    @Autowired
    TorneoRepository torneoRepository;

    //Guardar productos
    public Torneo saveTorneo(Torneo torneo){
        return torneoRepository.save(torneo);
    }

    //listar torneos
    public List<Torneo> getallTorneos(){
        return torneoRepository.findAll();

    }

    //Obtener id  Torneo
    public Optional<Torneo> getTorneoById(Long id) {
        return torneoRepository.findById(id);
    }

    //eliminar

    public void deleteTorneo(Long id){
        torneoRepository.deleteById(id);
    }
}

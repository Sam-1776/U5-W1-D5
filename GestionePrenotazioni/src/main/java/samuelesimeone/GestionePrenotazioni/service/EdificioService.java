package samuelesimeone.GestionePrenotazioni.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelesimeone.GestionePrenotazioni.dao.EdificioDAO;
import samuelesimeone.GestionePrenotazioni.entities.Edificio;
import samuelesimeone.GestionePrenotazioni.entities.Postazione;

import java.util.List;

@Service
public class EdificioService {

    @Autowired
    EdificioDAO edificioDAO;

    public void save(Edificio edificio){
        edificioDAO.save(edificio);
    }

    public List<Edificio> findByCitta(String citta){
        return edificioDAO.findByCittaIgnoreCase(citta);
    }
}

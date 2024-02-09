package samuelesimeone.GestionePrenotazioni.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelesimeone.GestionePrenotazioni.dao.UtenteDAO;
import samuelesimeone.GestionePrenotazioni.entities.Utente;
import samuelesimeone.GestionePrenotazioni.exceptions.ItemNotFound;
import samuelesimeone.GestionePrenotazioni.exceptions.UtenteEsistente;

import java.util.Optional;

@Service
@Slf4j
public class UtenteService {

    @Autowired
    UtenteDAO utenteDAO;

    public void save(Utente user){
        if (utenteDAO.findByUsername(user.getUsername()).isEmpty()){
        utenteDAO.save(user);
        log.info("Utente salvato");
        }else {
            throw new UtenteEsistente(user.getUsername());
        }
    }

    public Utente findByUsername(String username) throws ItemNotFound{
        return utenteDAO.findByUsername(username).orElseThrow(() -> new ItemNotFound(username));
    }
}

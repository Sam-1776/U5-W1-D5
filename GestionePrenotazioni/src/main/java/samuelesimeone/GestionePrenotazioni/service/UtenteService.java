package samuelesimeone.GestionePrenotazioni.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelesimeone.GestionePrenotazioni.dao.UtenteDAO;
import samuelesimeone.GestionePrenotazioni.entities.Utente;

@Service
public class UtenteService {

    @Autowired
    UtenteDAO utenteDAO;

    public void save(Utente user){
        utenteDAO.save(user);
    }
}

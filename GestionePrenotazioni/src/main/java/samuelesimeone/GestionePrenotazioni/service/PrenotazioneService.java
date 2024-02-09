package samuelesimeone.GestionePrenotazioni.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelesimeone.GestionePrenotazioni.dao.PrenotazioneDAO;
import samuelesimeone.GestionePrenotazioni.entities.Prenotazione;
import samuelesimeone.GestionePrenotazioni.entities.Utente;
import samuelesimeone.GestionePrenotazioni.exceptions.UtenteEsistente;

@Service
public class PrenotazioneService {

    @Autowired
    PrenotazioneDAO prenotazioneDAO;

    public void save(Prenotazione prenotazione){
        prenotazioneDAO.save(prenotazione);
    }
}

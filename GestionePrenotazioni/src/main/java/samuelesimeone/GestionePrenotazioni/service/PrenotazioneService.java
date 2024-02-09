package samuelesimeone.GestionePrenotazioni.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelesimeone.GestionePrenotazioni.dao.PrenotazioneDAO;
import samuelesimeone.GestionePrenotazioni.entities.Postazione;
import samuelesimeone.GestionePrenotazioni.entities.Prenotazione;
import samuelesimeone.GestionePrenotazioni.entities.Utente;
import samuelesimeone.GestionePrenotazioni.exceptions.UtenteEsistente;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    PrenotazioneDAO prenotazioneDAO;

    public void save(Prenotazione prenotazione){
        prenotazioneDAO.save(prenotazione);

    }

    public List<Prenotazione> findByUtente(Utente utente, LocalDate data){
        return prenotazioneDAO.findByUtenteAndData(utente, data);
    }

    public List<Prenotazione> findByPostazione(Postazione postazione, LocalDate data){
        return prenotazioneDAO.findByPostazioneAndData(postazione, data);
    }
}

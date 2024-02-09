package samuelesimeone.GestionePrenotazioni.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelesimeone.GestionePrenotazioni.dao.PrenotazioneDAO;

@Service
public class PrenotazioneService {

    @Autowired
    PrenotazioneDAO prenotazioneDAO;
}

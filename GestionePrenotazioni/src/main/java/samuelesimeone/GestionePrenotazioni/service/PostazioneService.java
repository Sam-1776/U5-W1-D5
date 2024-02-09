package samuelesimeone.GestionePrenotazioni.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelesimeone.GestionePrenotazioni.dao.PostazioneDAO;
import samuelesimeone.GestionePrenotazioni.entities.Postazione;
import samuelesimeone.GestionePrenotazioni.entities.Prenotazione;

@Service
public class PostazioneService {

    @Autowired
    PostazioneDAO postazioneDAO;

    public void save(Postazione postazione){
        postazioneDAO.save(postazione);
    }
}

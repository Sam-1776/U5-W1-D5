package samuelesimeone.GestionePrenotazioni.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelesimeone.GestionePrenotazioni.dao.PostazioneDAO;
import samuelesimeone.GestionePrenotazioni.entities.Postazione;
import samuelesimeone.GestionePrenotazioni.entities.Prenotazione;
import samuelesimeone.GestionePrenotazioni.exceptions.ItemNotFound;
import samuelesimeone.GestionePrenotazioni.exceptions.ItemNotFoundId;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    PostazioneDAO postazioneDAO;

    public void save(Postazione postazione){
        postazioneDAO.save(postazione);
    }

    public void findByIdAndUpdate(long Id, Postazione postazione) {
        Postazione found = this.findById(Id);
        found.setLibero(false);
        found.setTipo(postazione.getTipo());
        found.setDescrizione(postazione.getDescrizione());
        found.setEdificio(postazione.getEdificio());
        found.setN_max(postazione.getN_max());
        postazioneDAO.save(found);
    }

    public Postazione findById(long id) throws ItemNotFoundId {
        return postazioneDAO.findById(id).orElseThrow(() -> new ItemNotFoundId(id));
    }

    public List<Postazione> findPostazioni(long id){
        return postazioneDAO.findByEdificioId(id);
    }
}

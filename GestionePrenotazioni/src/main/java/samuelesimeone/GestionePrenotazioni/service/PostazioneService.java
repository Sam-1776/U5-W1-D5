package samuelesimeone.GestionePrenotazioni.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelesimeone.GestionePrenotazioni.dao.PostazioneDAO;

@Service
public class PostazioneService {

    @Autowired
    PostazioneDAO postazioneDAO;
}

package samuelesimeone.GestionePrenotazioni.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelesimeone.GestionePrenotazioni.dao.EdificioDAO;

@Service
public class EdificioService {

    @Autowired
    EdificioDAO edificioDAO;
}

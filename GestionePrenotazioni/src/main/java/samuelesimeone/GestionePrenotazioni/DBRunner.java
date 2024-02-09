package samuelesimeone.GestionePrenotazioni;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import samuelesimeone.GestionePrenotazioni.entities.Utente;
import samuelesimeone.GestionePrenotazioni.service.UtenteService;

@Component
public class DBRunner implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;
    @Override
    public void run(String... args) throws Exception {
        utenteService.save(new Utente("Piero11", "Piero Fanelli", "piero11@gmail.com"));
    }
}

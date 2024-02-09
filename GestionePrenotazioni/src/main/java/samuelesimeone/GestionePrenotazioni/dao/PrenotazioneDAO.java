package samuelesimeone.GestionePrenotazioni.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samuelesimeone.GestionePrenotazioni.entities.Postazione;
import samuelesimeone.GestionePrenotazioni.entities.Prenotazione;
import samuelesimeone.GestionePrenotazioni.entities.Utente;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneDAO extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data);
    List<Prenotazione> findByPostazioneAndData(Postazione postazione, LocalDate data);

    List<Prenotazione> findByUtente(Utente utente);
    List<Prenotazione> findByData(LocalDate data);
}

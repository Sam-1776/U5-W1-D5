package samuelesimeone.GestionePrenotazioni.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samuelesimeone.GestionePrenotazioni.entities.Postazione;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostazioneDAO extends JpaRepository<Postazione, Long> {
    List<Postazione> findByEdificioId(long id);
}

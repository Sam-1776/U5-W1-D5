package samuelesimeone.GestionePrenotazioni.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samuelesimeone.GestionePrenotazioni.entities.Postazione;

@Repository
public interface PostazioneDAO extends JpaRepository<Postazione, Long> {
}

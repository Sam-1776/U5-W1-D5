package samuelesimeone.GestionePrenotazioni.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samuelesimeone.GestionePrenotazioni.entities.Utente;

@Repository
public interface UtenteDAO extends JpaRepository<Utente, String> {
}

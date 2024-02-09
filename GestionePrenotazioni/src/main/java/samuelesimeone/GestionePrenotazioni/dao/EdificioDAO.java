package samuelesimeone.GestionePrenotazioni.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samuelesimeone.GestionePrenotazioni.entities.Edificio;

@Repository
public interface EdificioDAO extends JpaRepository<Edificio, Long> {
}

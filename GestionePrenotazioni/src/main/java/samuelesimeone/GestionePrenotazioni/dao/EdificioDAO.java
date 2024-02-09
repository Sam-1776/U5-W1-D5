package samuelesimeone.GestionePrenotazioni.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samuelesimeone.GestionePrenotazioni.entities.Edificio;

import java.util.List;

@Repository
public interface EdificioDAO extends JpaRepository<Edificio, Long> {
    List<Edificio> findByCittaIgnoreCase(String citta);
}

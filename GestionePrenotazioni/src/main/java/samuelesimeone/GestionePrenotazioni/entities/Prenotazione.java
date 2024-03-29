package samuelesimeone.GestionePrenotazioni.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;
    @ManyToOne
    @JoinColumn(name = "utente_username")
    private Utente utente;
    private LocalDate data;

    public Prenotazione(Postazione postazione, Utente utente, LocalDate data) {
        this.postazione = postazione;
        this.utente = utente;
        this.data = data;
    }
}

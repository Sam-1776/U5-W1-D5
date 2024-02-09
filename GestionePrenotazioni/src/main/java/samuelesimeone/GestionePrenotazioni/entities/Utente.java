package samuelesimeone.GestionePrenotazioni.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "utenti")
public class Utente {
    @Id
    @Setter(AccessLevel.NONE)
    private String username;
    private String nomeCompleto;
    private String email;

    public Utente(String username, String nomeCompleto, String email) {
        this.username = username;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }
}

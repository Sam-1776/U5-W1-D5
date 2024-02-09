package samuelesimeone.GestionePrenotazioni.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "edifici")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String nome;
    private String indirizzo;
    private String citta;

    public Edificio(String nome, String indirizzo, String citta) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }
}

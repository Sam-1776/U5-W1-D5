package samuelesimeone.GestionePrenotazioni.entities;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import samuelesimeone.GestionePrenotazioni.enumerazione.Tipo;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String descrizione;
    private Tipo tipo;
    private int n_max;
    @OneToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
    private boolean libero;

    public Postazione(String descrizione, Tipo tipo, int n_max, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.n_max = n_max;
        this.edificio = edificio;
        this.libero = true;
    }
}

package samuelesimeone.GestionePrenotazioni.entities;


import jakarta.persistence.*;
import lombok.*;
import samuelesimeone.GestionePrenotazioni.enumerazione.Tipo;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "postazioni")
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private int n_max;
    @ManyToOne
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

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", tipo=" + tipo +
                ", n_max=" + n_max +
                ", edificio=" + edificio +
                '}';
    }
}

package samuelesimeone.GestionePrenotazioni;


import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import samuelesimeone.GestionePrenotazioni.entities.Edificio;
import samuelesimeone.GestionePrenotazioni.entities.Postazione;
import samuelesimeone.GestionePrenotazioni.enumerazione.Tipo;

import java.util.Locale;

@Configuration
@PropertySource("application.properties")
public class BeansConfig {
    @Bean(name = "Edificio1")
    public Edificio getEdificio(){
        return new Edificio("CoFoundry", "Via Thaon di Revel, 21 - 20159 Milano", "Milano");
    }

    @Bean(name = "Edificio2")
    public Edificio getEdificio2(){
        return new Edificio("Campus Coworking", "Via Friuli, 68 , 20135, Milano", "Milano");
    }
    @Bean(name = "Edificio3")
    public Edificio getEdificio3(){
        return new Edificio("Eur Trade Center", "Via del Casale Solaro, 119 – Roma", "Roma");
    }
    @Bean(name = "Edificio4")
    public Edificio getEdificio4(){
        return new Edificio("Forma Spazi", "Via Cavour, 181 – Roma", "Roma");
    }

    @Bean(name = "Postazione1")
    public Postazione getPostazione(){
        return new Postazione("Lorem ipsum dolor sit amet.", Tipo.PRIVATO, 1, getEdificio());
    }

    @Bean(name = "Postazione2")
    public Postazione getPostazione2(){
        return new Postazione("Lorem ipsum dolor sit amet.", Tipo.OPENSPACE, 5, getEdificio());
    }

    @Bean(name = "Postazione3")
    public Postazione getPostazione3(){
        return new Postazione("Lorem ipsum dolor sit amet.", Tipo.SALA_RIUNIONI, 10, getEdificio());
    }

    @Bean(name = "Postazione4")
    public Postazione getPostazione4(){
        return new Postazione("Lorem ipsum dolor sit amet.", Tipo.PRIVATO, 1, getEdificio2());
    }

    @Bean(name = "Postazione5")
    public Postazione getPostazione5(){
        return new Postazione("Lorem ipsum dolor sit amet.", Tipo.OPENSPACE, 7, getEdificio2());
    }
    @Bean(name = "Postazione6")
    public Postazione getPostazione6(){
        return new Postazione("Lorem ipsum dolor sit amet.", Tipo.SALA_RIUNIONI, 15, getEdificio2());
    }

    @Bean(name = "Postazione7")
    public Postazione getPostazione7(){
        return new Postazione("Lorem ipsum dolor sit amet.", Tipo.PRIVATO, 1, getEdificio3());
    }
    @Bean(name = "Postazione8")
    public Postazione getPostazione8(){
        return new Postazione("Lorem ipsum dolor sit amet.", Tipo.OPENSPACE, 10, getEdificio3());
    }
    @Bean(name = "Postazione9")
    public Postazione getPostazione9(){
        return new Postazione("Lorem ipsum dolor sit amet.", Tipo.SALA_RIUNIONI, 8, getEdificio3());
    }

    @Bean(name = "Postazione10")
    public Postazione getPostazione10(){
        return new Postazione("Lorem ipsum dolor sit amet.", Tipo.PRIVATO, 1, getEdificio4());
    }
    @Bean(name = "Postazione11")
    public Postazione getPostazione11(){
        return new Postazione("Lorem ipsum dolor sit amet.", Tipo.OPENSPACE, 17, getEdificio4());
    }
    @Bean(name = "Postazione12")
    public Postazione getPostazione12(){
        return new Postazione("Lorem ipsum dolor sit amet.", Tipo.SALA_RIUNIONI, 20, getEdificio4());
    }
}

package samuelesimeone.GestionePrenotazioni;


import com.github.javafaker.App;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import samuelesimeone.GestionePrenotazioni.entities.Edificio;
import samuelesimeone.GestionePrenotazioni.entities.Postazione;
import samuelesimeone.GestionePrenotazioni.entities.Utente;
import samuelesimeone.GestionePrenotazioni.service.EdificioService;
import samuelesimeone.GestionePrenotazioni.service.PostazioneService;
import samuelesimeone.GestionePrenotazioni.service.UtenteService;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

@Component
@Order(1)
public class DBRunner implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;
    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;

    private Faker faker = new Faker(Locale.ITALY);

    private Supplier<Utente> generateUser = ()-> new Utente(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());


    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleziona: \n" + "1- Generazione DB \n" + "0- Esci");
        int cmd = scanner.nextInt();
        switch (cmd){
            case 1:
                generateDB();
                break;
            default:
                System.out.println("Arrivederci");
                break;
        }




    }

    public void generateDB(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniApplication.class);

        try {

            for (int i = 0; i < 50; i++) {
                try {
                    utenteService.save(generateUser.get());
                }catch (Exception e){
                    System.err.println(e.getMessage());
                }
            }

            edificioService.save(ctx.getBean("Edificio1", Edificio.class));
            edificioService.save(ctx.getBean("Edificio2", Edificio.class));
            edificioService.save(ctx.getBean("Edificio3", Edificio.class));
            edificioService.save(ctx.getBean("Edificio4", Edificio.class));

            postazioneService.save(ctx.getBean("Postazione1", Postazione.class));
            postazioneService.save(ctx.getBean("Postazione2", Postazione.class));
            postazioneService.save(ctx.getBean("Postazione3", Postazione.class));
            postazioneService.save(ctx.getBean("Postazione4", Postazione.class));
            postazioneService.save(ctx.getBean("Postazione5", Postazione.class));
            postazioneService.save(ctx.getBean("Postazione6", Postazione.class));
            postazioneService.save(ctx.getBean("Postazione7", Postazione.class));
            postazioneService.save(ctx.getBean("Postazione8", Postazione.class));
            postazioneService.save(ctx.getBean("Postazione9", Postazione.class));
            postazioneService.save(ctx.getBean("Postazione10", Postazione.class));
            postazioneService.save(ctx.getBean("Postazione11", Postazione.class));
            postazioneService.save(ctx.getBean("Postazione12", Postazione.class));

        }catch (Exception e){
            System.err.println(e.getMessage());
        }finally {
            ctx.close();
        }
    }
}

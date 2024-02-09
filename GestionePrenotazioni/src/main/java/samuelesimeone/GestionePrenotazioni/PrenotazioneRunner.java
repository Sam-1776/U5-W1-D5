package samuelesimeone.GestionePrenotazioni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import samuelesimeone.GestionePrenotazioni.entities.Edificio;
import samuelesimeone.GestionePrenotazioni.entities.Postazione;
import samuelesimeone.GestionePrenotazioni.entities.Prenotazione;
import samuelesimeone.GestionePrenotazioni.entities.Utente;
import samuelesimeone.GestionePrenotazioni.exceptions.ItemNotFound;
import samuelesimeone.GestionePrenotazioni.exceptions.UtenteEsistente;
import samuelesimeone.GestionePrenotazioni.service.EdificioService;
import samuelesimeone.GestionePrenotazioni.service.PostazioneService;
import samuelesimeone.GestionePrenotazioni.service.PrenotazioneService;
import samuelesimeone.GestionePrenotazioni.service.UtenteService;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Component
public class PrenotazioneRunner implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PrenotazioneService prenotazioneService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private EdificioService edificioService;


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleziona: \n" + "1- registrazione \n" + "2- Fai una Prenotazione \n" + "3- Controlla le tue Prenotazioni \n" + "0- Esci");

        int cmd = scanner.nextInt();
        switch (cmd){
            case 1:
                registrazione();
                break;
            case 2:
                System.out.println("Inserire data per prenotazione");
                Scanner data = new Scanner(System.in);
                LocalDate day = LocalDate.parse(data.nextLine());
                makePrenotazioneOggi(day);
                break;
            default:
                System.out.println("Arrivederci");
                break;
        }
        scanner.close();
    }

    public void registrazione() throws UtenteEsistente{
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Inserire Username");
            String username = scanner.nextLine();
            System.out.println("Inserire nome completo");
            String nomeC = scanner.nextLine();
            System.out.println("Inserire E-mail");
            String email = scanner.nextLine();
            Utente newUtente = new Utente(username, nomeC, email);
            utenteService.save(newUtente);
            scanner.close();
        }catch (UtenteEsistente u){
            System.err.println(u.getMessage());
        }
    }


    public void makePrenotazioneOggi(LocalDate data){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire username");
        String str = scanner.nextLine();
        Utente user = utenteService.findByUsername(str);
        if (prenotazioneService.findByUtente(user,data).isEmpty()){
            System.out.println("Inserire Città desiderato \n" + "Milano o Roma");
            String citta = scanner.nextLine();
            List<Edificio> edificioList = edificioService.findByCitta(citta);
            edificioList.forEach(System.out::println);
            System.out.println("Inserire id edificio scelto");
            long id = scanner.nextLong();
            List<Postazione> postazioneList = postazioneService.findPostazioni(id);
            postazioneList.forEach(System.out::println);
            System.out.println("Inserire id postazione");
            long idP = scanner.nextLong();
            Postazione postazione = postazioneService.findById(idP);
            if (prenotazioneService.findByPostazione(postazione, data).size() == postazione.getN_max()){
                postazioneService.findByIdAndUpdate(idP,postazione);
                System.out.println("Non ci sono posti liberi per oggi");
            }else {
                prenotazioneService.save(new Prenotazione(postazione, user, data));
                System.out.println("Prenotazione Salvata");
            }
        } else {
            System.out.println("Hai già una prenotazione per oggi");
        }
    }


}

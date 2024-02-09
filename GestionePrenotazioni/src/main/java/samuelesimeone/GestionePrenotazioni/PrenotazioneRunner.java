package samuelesimeone.GestionePrenotazioni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import samuelesimeone.GestionePrenotazioni.entities.Utente;
import samuelesimeone.GestionePrenotazioni.exceptions.ItemNotFound;
import samuelesimeone.GestionePrenotazioni.exceptions.UtenteEsistente;
import samuelesimeone.GestionePrenotazioni.service.PostazioneService;
import samuelesimeone.GestionePrenotazioni.service.PrenotazioneService;
import samuelesimeone.GestionePrenotazioni.service.UtenteService;

import java.util.Scanner;

@Component
public class PrenotazioneRunner implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;
    @Autowired
    PrenotazioneService prenotazioneService;
    @Autowired
    PostazioneService postazioneService;


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleziona: \n" + "1- registrazione \n" + "2- login \n" + "0- Esci");
        Utente user = null;

        int cmd = scanner.nextInt();
        switch (cmd){
            case 1:
                user = registrazione();
                break;
            case 2:
                user = login();
                System.out.println("salve " + user.getNomeCompleto());
                break;
            default:
                System.out.println("Arrivederci");
                break;
        }
        scanner.close();
//        Scanner command = new Scanner(System.in);
//        int cmd1 = command.nextInt();
//        switch (cmd1){
//            case 1:
//                makePrenotazione();
//                break;
//                case 2:
//                    checkPrenotazioni();
//                    break;
//                default:
//                    System.out.println("Arrivederci ---- Logout");
//                    user = null;
//                    break;
//            }
    }

    public Utente registrazione() throws UtenteEsistente{
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
        return newUtente;
        }catch (UtenteEsistente u){
            System.err.println(u.getMessage());
        }
        return null;
    }

    public Utente login() throws ItemNotFound {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Inserire username");
            String str = scanner.nextLine();
            scanner.close();
            return utenteService.findByUsername(str);
        }catch (ItemNotFound i){
            System.err.println(i.getMessage());
        }
        return null;
    }
}

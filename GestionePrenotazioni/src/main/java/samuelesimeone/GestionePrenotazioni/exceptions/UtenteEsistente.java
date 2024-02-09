package samuelesimeone.GestionePrenotazioni.exceptions;


public class UtenteEsistente extends RuntimeException{
    public UtenteEsistente(String user) {
        super("Username:" + user + " è già esistente");
    }
}

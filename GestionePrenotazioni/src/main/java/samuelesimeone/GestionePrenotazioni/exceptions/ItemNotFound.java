package samuelesimeone.GestionePrenotazioni.exceptions;

public class ItemNotFound extends  RuntimeException{
    public ItemNotFound(String username) {
        super("Utente con username:" + username + " non trovato");
    }
}

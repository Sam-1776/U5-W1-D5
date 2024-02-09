package samuelesimeone.GestionePrenotazioni.exceptions;

public class ItemNotFoundId extends RuntimeException{
    public ItemNotFoundId(long id) {
        super("Elemento con id:" + id + " non trovato");
    }
}

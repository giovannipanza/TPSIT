package Server;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Sala {
    private static final int CAPIENZA = 50;
    // posto -> nomeCliente
    private final ConcurrentMap<Integer, String> prenotazioni = new ConcurrentHashMap<>();

    private void validaPosto(int numeroPosto) {
        if (numeroPosto < 1 || numeroPosto > CAPIENZA) {
            throw new IllegalArgumentException("Numero di posto non valido: " + numeroPosto);
        }
    }

    //metodo per prenotare un posto
    public boolean prenotaPosto(int numeroPosto, String nome) {
        validaPosto(numeroPosto);
        if(prenotazioni.containsKey(numeroPosto)) {
            return false;
        }
        prenotazioni.put(numeroPosto, nome);
        return true;
    }

    //metodo per cancellare un posto
    public boolean cancellaPrenotazione(int numeroPosto) {
        validaPosto(numeroPosto);
        if(prenotazioni.containsKey(numeroPosto)) {
            prenotazioni.remove(numeroPosto);
            return true;
        }
        return false;
    }

    public String mostraPostiLiberi() {
        StringBuilder sb = new StringBuilder("Posti liberi:");
        for (int i = 1; i <= 50; i++) {
            // Se il posto NON è presente nella mappa, vuol dire che è libero
            if (!prenotazioni.containsKey(i)) {
                sb.append("Posto ").append(i);
            }
        }
        sb.append("\n"); //il carattere di fine stringa

        // Se non ha trovato nessun posto libero
        if (sb.toString().equals("Posti liberi: ")) {
            sb.replace(0, sb.length()-1, "NON CI SONO POSTI LIBERI!\n");
        }
        return sb.toString();
    }




}

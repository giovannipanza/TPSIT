package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GestoreClient extends Thread{
    Socket s;
    Sala sala;
    public GestoreClient(Socket s, Sala sala) {
        this.s=s;
        this.sala=sala;
    }

    @Override
    public void run() {
        try (
                BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter out=new PrintWriter(s.getOutputStream(), true);
            )
        {
            //dobbiamo gestire il protocollo di comunicazione col client
            /*
            All'avvio, chiede all'utente il nome identificativo.
            Invia il comando di identificazione al server e attende la conferma.
            Entra in un ciclo in cui:
                a. Attende l'input dell'utente.
                b. Invia il comando al server.
                c. Attende e stampa la risposta.

             */
            out.println("[SERVER]: Inserisci il tuo nickname (identificativo): ");
            String app=in.readLine(); //ricevo il nickname da parte del client
            out.println("BOOK o DELETE o SHOW o EXIT");
            app=in.readLine();
            /*
                completate il codice ............
             */
            while(app.contains("BOOK")){

                switch (app){
                    case "BOOK":
                        //comunico al client i posti che può prenotare
                        out.println(sala.mostraPostiLiberi());
                        int numero_posto=Integer.parseInt(in.readLine());
                        sala.prenotaPosto(numero_posto,app);
                        break;
                }

            }

        } catch (Exception e) {
            System.out.println("Si è verificato un errore!");
        }

    }
}

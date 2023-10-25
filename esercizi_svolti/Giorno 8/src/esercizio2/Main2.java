package esercizio2;
import java.util.ArrayList;

/*
* Esercizio Mini Gestore prenotazioni 🛵
*
* Scrivere un programma in grado di modellare la gestione delle prenotazioni di un ristorante. Il ristorante può ricevere 2
*  tipi di prenotazione: singola o di gruppo.
* Progettare la classe GestorePrenotazioni a partire da due interi m e n che determinano rispettivamente il numero di posti disponibili
*  all’interno e all’esterno nel ristorante.
* Ad ogni Prenotazione sono associati un codice univoco. Una prenotazione singola può anche esprimere una preferenza tra interno
*  ed esterno, La prenotazione di gruppo, invece, ha anche un attributo che specifica il numero di posti da riservare.
*
* La classe prevede i seguenti metodi:

- prenota: data una Prenotazione p in input, se c’è posto nel ristorante viene accettata restituendo true (dando precedenza alla
*  preferenza indicata), altrimenti viene rifiutata restituendo false
- terminaPrenotazione: data una Prenotazione p in input, termina la prenotazione eliminandola e liberando i posti associati.
PLUS🏍: Se presenti prenotazioni singole la cui preferenza può ora essere soddisfatta in virtù dei nuovi posti liberi, modificare
*  la prenotazione di conseguenza.
*
Esempio: ci sono 2 posti disponibili all’esterno e 2 prenotazioni p1 e p2, entrambe da 2 persone all’esterno; nel momento in cui
* viene terminata la prenotazione p1, se p2 è ancora in corso, va spostata all’esterno.
- prenotazioniAttualiEsterno: ritorna un array con le attuali prenotazioni per l’esterno del ristorante
- prenotazioniAttualiInterno: ritorna un array con le attuali prenotazioni per l’interno del ristorante
* */

//NB MANCA SOLO IL CAMBIO DI PRENOTAZIONE NEL PUNTO PLUS

public class Main2 {

    public static void main(String[] args) {

        ArrayList<Prenotazione> prenotazioni = new ArrayList<>();
        ArrayList<Prenotazione> prenotatiInterni;
        ArrayList<Prenotazione> prenotatiEsterni;

        GestorePrenotazioni gestore = new GestorePrenotazioni(5, 3);

        Prenotazione p1 = new PrenotazioneSingola("12", Prenotazione.Postazione.ESTERNO);
        prenotazioni.add(p1);
        Prenotazione p2 = new PrenotazioneSingola("23", Prenotazione.Postazione.ESTERNO);
        prenotazioni.add(p2);
        Prenotazione p3 = new PrenotazioneSingola("34", Prenotazione.Postazione.INTERNO);
        prenotazioni.add(p3);
        Prenotazione p4 = new PrenotazioneSingola("56", Prenotazione.Postazione.ESTERNO);
        prenotazioni.add(p4);
        Prenotazione p5 = new PrenotazioneDiGruppo("89", Prenotazione.Postazione.INTERNO, 2);
        prenotazioni.add(p5);
        Prenotazione p6 = new PrenotazioneDiGruppo("01", Prenotazione.Postazione.ESTERNO, 8);
        prenotazioni.add(p6);

        gestore.prenota(p1);
        gestore.prenota(p2);
        gestore.prenota(p3);
        gestore.prenota(p4);
        gestore.prenota(p5);
        gestore.prenota(p6);

        System.out.println("-----------------------------");

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(p4.toString());
        System.out.println(p5.toString());
        System.out.println(p6.toString());
        System.out.println("\nPosti interni liberi: " + gestore.postiInterni + "\nPosti esterni liberi: " + gestore.postiEsterni);

        System.out.println("-----------------------------");

        prenotatiInterni = gestore.prenotazioniAttualiInterno(prenotazioni);
        System.out.println("Prenotazioni attuali all'interno: ");
        for(Prenotazione i : prenotatiInterni){
            System.out.println(i.toString());
        }

        System.out.println("-----------------------------");
        prenotatiEsterni = gestore.prenotazioniAttualiEsterno(prenotazioni);
        System.out.println("Prenotazioni attuali all'esterno: ");
        for(Prenotazione i : prenotatiEsterni){
            System.out.println(i.toString());
        }

        gestore.terminaPrenotazione(p1);
        gestore.terminaPrenotazione(p2);
        gestore.terminaPrenotazione(p3);
        gestore.terminaPrenotazione(p4);
        gestore.terminaPrenotazione(p6);

        System.out.println("-----------------------------");

        System.out.println("\nPosti interni liberi: " + gestore.postiInterni + "\nPosti esterni liberi: " + gestore.postiEsterni);

        System.out.println("-----------------------------");

        prenotatiInterni = gestore.prenotazioniAttualiInterno(prenotazioni);
        System.out.println("Prenotazioni attuali all'interno: ");
        for(Prenotazione i : prenotatiInterni){
            System.out.println(i.toString());
        }

        System.out.println("-----------------------------");
        prenotatiEsterni = gestore.prenotazioniAttualiEsterno(prenotazioni);
        System.out.println("Prenotazioni attuali all'esterno: ");
        for(Prenotazione i : prenotatiEsterni){
            System.out.println(i.toString());
        }
    }
}

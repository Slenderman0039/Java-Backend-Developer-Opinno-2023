package esercizio2;

/*Progettare una classe Classifica che permetta di gestire la classifica di Serie A costruita a partire da 20 squadre di calcio.
Ogni squadra di calcio ha i seguenti attributi:

        id
        nome
        rosa di giocatori
        punteggio
        gol fatti
        gol subiti
        Ogni giocatore ha un id, un nome e un cognome. In particolare, deve essere possibile gestire le seguenti operazioni:

        esitoPartita(squadraCasa, golCasa, squadraOspite, golOspite): gestisce il punteggio delle due squadre in base all'esito
        getClassifica(): ritorna la classifica attuale, ordinata per punteggio
        getMigliorAttacco(): ritorna la squadra che ha segnato più gol
        getPeggiorDifesa(): ritorna la squadra che ha concesso più gol
        */

public class Main2 {

    public static void main(String[] args) {

        Classifica classifica = new Classifica();
        classifica.aggiungiSquadra(0, "Napoli");
        classifica.aggiungiSquadra(1, "Juventus");
        classifica.aggiungiSquadra(2, "Milan");
        classifica.aggiungiSquadra(3, "Inter");

        classifica.esitoPartita(classifica.getSquadra(0), 3, classifica.getSquadra(1), 1);
        classifica.esitoPartita(classifica.getSquadra(2), 2, classifica.getSquadra(3), 2);
        System.out.println(classifica.getClassifica());
        System.out.println("La squadra che ha segnato più gol: " + classifica.getMigliorAttacco());
        System.out.println("La squadra che ha subito più gol: " + classifica.getPeggiorDifesa());
    }
}
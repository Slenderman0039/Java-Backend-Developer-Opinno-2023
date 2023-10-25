/*Scrivere un programma in grado di modellare la gestione di diversi tipi di veicoli: automobili e
autocarri. In particolare, create le classi Autocarro e Automobile entrambe con le seguenti
aratteristiche:
Ogni veicolo è caratterizzato da:
- Targa
- Numero di posti

Gli autocarri hanno una proprietà aggiuntiva: la capacità massima di carico (espressa in quintali). Le automobili, invece,
il numero di porte.
Il metodo toString degli oggetti Automobile deve ritornare il numero di targa e il numero di porte, separati dal carattere «:».
Il metodo toString degli oggetti Autocarro, invece, deve ritornare il numero di targa e la massima capacità in quintali,
separati dal carattere «:».
*/

package esercizio1;

public class Main1 {

    public static void main(String[] args) {
        Veicolo fiatPunto = new Veicolo("AA000AA", 5);
        System.out.println(fiatPunto.toString());
        Automobile tesla = new Automobile("AA001AB", 5, 5);
        System.out.println(tesla.toString());
        Autocarro scania = new Autocarro("CZ999PL", 3, 500);
        System.out.println(scania.toString());
    }
}
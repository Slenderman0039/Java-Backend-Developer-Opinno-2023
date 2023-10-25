import carsharing.CarSharing;
import users.Persona;
import veicoli.carburante.Automobile;
import veicoli.carburante.Scooter;
import veicoli.carburante.VeicoloACarburante;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        CarSharing carSharing = new CarSharing();

        //POPOLO IL DB DI VEICOLI

        carSharing.getDb().aggiungiVeicolo(new Scooter("SH", "FF000FF", 10, VeicoloACarburante.TipoMotore.BENZINA, 5));
        carSharing.getDb().aggiungiVeicolo(new Automobile("Fiat Punto", "AA000AA", 42, VeicoloACarburante.TipoMotore.GASOLIO, 15));
        carSharing.getDb().aggiungiVeicolo(new Automobile("Fiat Tipo", "AA000AB", 40, VeicoloACarburante.TipoMotore.METANO, 20));
        carSharing.getDb().aggiungiVeicolo(new Automobile("Fiat Panda", "AA000AC", 35, VeicoloACarburante.TipoMotore.GPL, 35));
        carSharing.getDb().aggiungiVeicolo(new Automobile("Alfa Romeo", "AA000AD", 41, VeicoloACarburante.TipoMotore.GASOLIO, 15));
        carSharing.getDb().aggiungiVeicolo(new Automobile("Mercedes GLC", "AA000AE", 50, VeicoloACarburante.TipoMotore.BENZINA, 15));

        //POPOLO IL DB DI PERSONE

        carSharing.getDb().aggiungiPersona(new Persona("Claudio", "Sottile", LocalDate.of(2002, 7, 25), "STTCLD", "claudiosottile@gmail.com", "ciaoatutti"));
        carSharing.getDb().aggiungiPersona(new Persona("Alessandro", "Macaluso", LocalDate.of(2002, 7, 25), "MCLALL", "alessandromacaluso@gmail.com", "ciaoatutti2"));
        carSharing.getDb().aggiungiPersona(new Persona("Pasquale", "La Gatta", LocalDate.of(2002, 7, 25), "PSQLGT", "pasqualelagatta@gmail.com", "ciaoatutti3"));
        carSharing.getDb().aggiungiPersona(new Persona("Jacopo", "Perna", LocalDate.of(2002, 7, 25), "PRNJCP", "jacopoperna@gmail.com", "ciaoatutti4"));
        carSharing.getDb().aggiungiPersona(new Persona("Sara", "Costantino", LocalDate.of(2002, 7, 25), "CSTSRR", "saracostantino@gmail.com", "ciaoatutti5"));
        carSharing.getDb().aggiungiPersona(new Persona("Giuseppe", "Profumo", LocalDate.of(2002, 7, 25), "PRFGSP", "giuseppeprofumo@gmail.com", "ciaoatutti6"));

        //System.out.println(carSharing.getDb().getPersoneString());
        //System.out.println(carSharing.getDb().getVeicoliString());
        //System.out.println(carSharing.getDb().getPrenotazioniString());

        //TEST

        carSharing.cercaVeicolo();
        carSharing.aggiungiPatente("claudiosottile@gmail.com", Persona.Patenti.B);

        carSharing.prenotaVeicolo("claudiosottile@gmail.com", "Fiat Punto");

        //TimeUnit.MINUTES.sleep(5);

        carSharing.terminaCorsa("claudiosottile@gmail.com", "Fiat Punto");
    }
}
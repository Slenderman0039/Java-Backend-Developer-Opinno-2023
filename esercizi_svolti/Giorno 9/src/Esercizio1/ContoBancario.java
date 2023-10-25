package Esercizio1;

import java.util.*;

public class ContoBancario implements Operazione{

    private double denaro;
    private String iban;
    private ArrayList<String> operazioni = new ArrayList<>();

    public ContoBancario(double denaro, String iban) {
        this.denaro = denaro;
        this.iban = iban;
    }

    public double getDenaro() {
        return denaro;
    }

    public void setDenaro(double denaro) {
        this.denaro = denaro;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double prelevaDenaro(double denaro){
        if(denaro > this.denaro) return -1;
        operazioni.add("Prelievo di " + denaro + "€");
        this.denaro -= denaro;
        return denaro;
    }

    public double svuotaConto(){
        double tmp = this.denaro;
        denaro = 0;
        operazioni.add("Conto svuotato");
        return tmp;
    }

    public void versaDenaro(double denaro){
        this.denaro += denaro;
        operazioni.add("Versamento di " + denaro + "€");
    }

    public String situazioneConto(){ return this.iban + ": " + this.denaro; }

    public void bonifico(String iban, double denaro){
        ContoBancario altro = DBContiBancari.ricercaConto(iban);
        this.prelevaDenaro(denaro);
        altro.versaDenaro(denaro);
        operazioni.add("Bonifico a " + altro.getIban() + " di " + denaro + "€");
    }

    public String stampaStorico(){

        String s = "";

        for(String i : operazioni){ s += i + "\n"; }
        return s;
    }

    public void esegui(){
        Scanner scanner = new Scanner(System.in);
        double denaro;
        String iban;

        while(true){
            System.out.println("1. Preleva\n2. Versa denaro\n3. Bonifico\n4. Svuota conto\n5. Situazione conto\n6. Storico operazioni\n7. Esci");
            int opzione = scanner.nextInt();
            switch (opzione){
                default:
                    System.out.println("Errore.");
                    break;
                case 1:
                    System.out.print("Denaro da prelevare: ");
                    denaro = scanner.nextDouble();
                    prelevaDenaro(denaro);
                    break;
                case 2:
                    System.out.print("Denaro da versare: ");
                    denaro = scanner.nextDouble();
                    prelevaDenaro(denaro);
                    break;
                case 3:
                    System.out.print("Denaro da versare: ");
                    denaro = scanner.nextDouble();
                    System.out.print("IBAN conto bancario: ");
                    iban = scanner.next();
                    bonifico(iban, denaro);
                    break;
                case 4:
                    svuotaConto();
                    break;
                case 5:
                    System.out.println(situazioneConto());
                    break;
                case 6:
                    System.out.println(stampaStorico());
                    break;
                case 7:
                    return;
            }
        }
    }
}
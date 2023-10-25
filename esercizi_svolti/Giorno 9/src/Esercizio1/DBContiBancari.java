package Esercizio1;

import java.util.ArrayList;

public class DBContiBancari {
    private static ArrayList<ContoBancario> conti;

    public DBContiBancari(){
        conti = new ArrayList<>();
    }

    public static ArrayList<ContoBancario> getConti() { return conti; }

    public static ContoBancario ricercaConto(String iban){
        for(ContoBancario i : conti){
            if(i.getIban().equals(iban))
                return i;
        }
        return null;
    }

    public void aggiungiConto(ContoBancario e){ conti.add(e); }

    public void rimuoviConto(String iban){ conti.remove(iban); }

    public String toString(){
        String s = "";
        for(ContoBancario i : conti)
            s += i.situazioneConto() + "\n";
        return s;
    }
}

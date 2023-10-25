package esercizio2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Classifica {
    private ArrayList<Squadra> squadre;

    public Classifica(){
        squadre = new ArrayList<>();
    }

    public void aggiungiSquadra(int id, String nome){
        squadre.add(new Squadra(id, nome));
    }

    public Squadra getSquadra(int i){
        return squadre.get(i);
    }

    public void esitoPartita(Squadra squadraCasa, int golCasa, Squadra squadraOspite, int golOspite){

        if(golCasa > golOspite){
            squadraCasa.setPunteggio(squadraCasa.getPunteggio() + 3);
        }

        else if(golCasa < golOspite)
            squadraOspite.setPunteggio(squadraOspite.getPunteggio() + 3);
        else{
            squadraCasa.setPunteggio(squadraCasa.getPunteggio() + 1);
            squadraOspite.setPunteggio(squadraOspite.getPunteggio() + 1);
        }
        squadraCasa.setGolFatti(squadraCasa.getGolFatti() + golCasa);
        squadraOspite.setGolFatti(squadraOspite.getGolFatti() + golOspite);
        squadraCasa.setGolSubiti(squadraCasa.getGolSubiti() + golOspite);
        squadraOspite.setGolSubiti((squadraOspite.getGolSubiti() + golCasa));
    }

    public void ordinaLista(){

        squadre.sort(Comparator.comparing(Squadra::getPunteggio).reversed());
    }

    public String getMigliorAttacco(){
        squadre.sort(Comparator.comparing(Squadra::getGolFatti).reversed());
        return squadre.get(0).getNome();
    }

    public String getPeggiorDifesa(){
        squadre.sort(Comparator.comparing(Squadra::getGolSubiti).reversed());
        return squadre.get(0).getNome();
    }

    public String getClassifica(){

        ordinaLista();
        String s = "";

        for(Squadra i : squadre){
            s += i.toString() + "\n";
        }
        return s;
    }
}
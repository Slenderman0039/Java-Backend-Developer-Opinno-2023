package esercizio2;
import java.util.ArrayList;

public class GestorePrenotazioni {
    int postiInterni, postiEsterni;

    public GestorePrenotazioni(int postiInterni, int postiEsterni){
        this.postiInterni = postiInterni;
        this.postiEsterni = postiEsterni;
    }

    public int getPostiInterni() {
        return postiInterni;
    }

    public void setPostiInterni(int postiInterni) {
        this.postiInterni = postiInterni;
    }

    public int getPostiEsterni() {
        return postiEsterni;
    }

    public void setPostiEsterni(int postiEsterni) {
        this.postiEsterni = postiEsterni;
    }

    public boolean prenota(Prenotazione p){

        if(p instanceof PrenotazioneSingola){
            PrenotazioneSingola p2 = (PrenotazioneSingola) p;
            if (p2.getPreferenza() == PrenotazioneSingola.Postazione.INTERNO){
                if(postiInterni > 0){
                    postiInterni--;
                    System.out.println("Posto prenotato all'interno come richiesto");
                    p2.setPostoAssegnato(Prenotazione.Postazione.INTERNO);
                    return true;
                }
                else{
                    if(postiEsterni > 0){
                        postiEsterni--;
                        System.out.println("Posto prenotato all'esterno");
                        p2.setPostoAssegnato(Prenotazione.Postazione.ESTERNO);
                        return true;
                    }
                }
            }
            else if(p2.getPreferenza() == PrenotazioneSingola.Postazione.ESTERNO){
                if(postiEsterni > 0){
                    postiEsterni--;
                    System.out.println("Posto prenotato all'esterno come richiesto");
                    p2.setPostoAssegnato(Prenotazione.Postazione.ESTERNO);
                    return true;
                }
                else{
                    if(postiInterni > 0){
                        postiInterni--;
                        System.out.println("Posto prenotato all'interno");
                        p2.setPostoAssegnato(Prenotazione.Postazione.INTERNO);
                        return true;
                    }
                }
            }
        }
        else if (p instanceof Prenotazione){        //Se non c'è preferenza, di default all'interno, se non c'è spazio all'esterno
            if(postiInterni > 0){
                postiInterni--;
                System.out.println("Posto prenotato all'interno");
                p.setPostoAssegnato(Prenotazione.Postazione.INTERNO);
                return true;
            }
            else if(postiEsterni > 0){
                postiEsterni--;
                System.out.println("Posto prenotato all'esterno");
                p.setPostoAssegnato(Prenotazione.Postazione.INTERNO);
            }
        }
        return false;
    }

    public void terminaPrenotazione(Prenotazione p){

        if(p instanceof PrenotazioneSingola) {
            if(((PrenotazioneSingola) p).getPreferenza() == Prenotazione.Postazione.INTERNO){
                postiInterni++;
                System.out.println("Posto interno liberato");
                p.setPostoAssegnato(null);
            }
            else{
                postiEsterni++;
                System.out.println("Posto esterno liberato");
                p.setPostoAssegnato(null);
            }
        }
        return;
    }

    public ArrayList<Prenotazione> prenotazioniAttualiEsterno(ArrayList<Prenotazione> prenotazioni){
        ArrayList<Prenotazione> prenotatiEsterno = new ArrayList<>();
        for(int i = 0; i < prenotazioni.size(); i++){
            if (prenotazioni.get(i).getPostoAssegnato() == Prenotazione.Postazione.ESTERNO){
                prenotatiEsterno.add(prenotazioni.get(i));
            }
        }
        return prenotatiEsterno;
    }

    public ArrayList<Prenotazione> prenotazioniAttualiInterno(ArrayList<Prenotazione> prenotazioni){
        ArrayList<Prenotazione> prenotatiInterno = new ArrayList<>();
        for(int i = 0; i < prenotazioni.size(); i++){
            if (prenotazioni.get(i).getPostoAssegnato() == Prenotazione.Postazione.INTERNO){
                prenotatiInterno.add(prenotazioni.get(i));
            }
        }
        return prenotatiInterno;
    }
}
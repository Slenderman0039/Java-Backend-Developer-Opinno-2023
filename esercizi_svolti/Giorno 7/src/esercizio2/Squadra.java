package esercizio2;
import java.util.ArrayList;

public class Squadra {
    private int id, punteggio, golFatti, golSubiti;
    private String nome;
    private ArrayList<Giocatore> rosa;

    public Squadra(){}

    public Squadra(int id, String nome){
        this.id = id;
        this.nome = nome;
        rosa = new ArrayList<>(20);
        punteggio = 0;
        golFatti = 0;
        golSubiti = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public int getGolFatti() {
        return golFatti;
    }

    public void setGolFatti(int golFatti) {
        this.golFatti = golFatti;
    }

    public int getGolSubiti() {
        return golSubiti;
    }

    public void setGolSubiti(int golSubiti) {
        this.golSubiti = golSubiti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + ", Punti: " + punteggio + ", Gol fatti: " + golFatti + ", Gol subiti: " + golSubiti;
    }
}
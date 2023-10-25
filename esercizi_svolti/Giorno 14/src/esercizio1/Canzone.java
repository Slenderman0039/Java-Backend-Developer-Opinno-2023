package esercizio1;

import java.util.Objects;

public class Canzone {
    private String nome;
    private String autore;

    private int id;

    public Canzone(String nome,String autore){
        this.nome = nome;
        this.autore = autore;
        this.id = ++Main.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Canzone canzone = (Canzone) o;
        return id == canzone.id && Objects.equals(nome, canzone.nome) && Objects.equals(autore, canzone.autore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, autore, id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    @Override
    public String toString() {
        return "[" +id+" , "+ nome + " , " + autore+"]";
    }
}

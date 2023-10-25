package esercizio2;

public class Studente implements Comparable{
    private String nome;
    private String cognome;
    private String matricola;

    public Studente(String nome, String cognome, String matricola) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMatricola() {
        return matricola;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", matricola='" + matricola + '\'' +
                '}';
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Studente){
            Studente studente = (Studente) o;
            return studente.getCognome().compareTo(getCognome());
        }
        return -1;
    }
}

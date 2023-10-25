package users;

import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Getter
public class Persona {

    public enum Patenti{ AM, A1, A2, A, B1, B, C1, C, D1, D, BE, C1E, CE, D1E, DE }

    private static int globalId = 0;
    private int id;
    private final String nome;
    private final String cognome;
    private final LocalDate dataNascita;
    private final String codiceFiscale;
    @Setter
    private String email;
    @Setter
    private String password;
    @Setter
    private List<Patenti> patenti;
    @Setter
    private boolean casco;
    @Setter
    private double credito;

    public Persona(String nome, String cognome, LocalDate dataNascita, String codiceFiscale, String email, String password) {
        this.id = globalId++;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.codiceFiscale = codiceFiscale;
        this.patenti = new ArrayList<>();
        this.email = email;
        this.password = password;
    }

    //AGG PATENTE
    public void aggiungiPatente(Patenti patente){ patenti.add(patente); }


    //check validità email Introduco i CONTROLLI
    public boolean checkEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    //CAMBIO EMAIL
    public void cambiaEmail(String nuovaEmail){
        if (checkEmail(nuovaEmail)){
            email= nuovaEmail;
        }else {
            System.out.println("Email non Valida");
        }
    }

    public int getId() {
        return id;
    }



    //CHECK PASSWORD. Introduco i CONTROLLI(min lunghezza,almeno un numero, un Carattere Maiuscolo)
    private boolean checkPassword(String password) {
        // Verifica la lunghezza minima della password
        if (password.length() < 8) {
            return false;
        }

        // Verifica MiNIMO un numero
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Verifica MiniMo un carattere maiuscolo
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        return true;
    }

    //  CAMBIA PASSWORD
    public void cambiaPassword(String newPassword) {
        if (checkPassword(newPassword)) {
            password = newPassword;
        } else {
            System.out.println("Password non valida");
        }
    }

    public String toStringForPrenotazione(){
       return "==== UTENTE ===\nNome: "+getNome()+".\nCognome: "+getCognome()+".\nEmail: " + getEmail()+".";
    }

    @Override
    public String toString() {
        return nome + " " + cognome + "(" + codiceFiscale + ")" + "\nData di nascita: " + dataNascita + "\nEmail: " + email + "\nPatenti: " + patenti + "\nCasco: "  + casco + "\nCredito: " + credito+ "\n";
    }
}
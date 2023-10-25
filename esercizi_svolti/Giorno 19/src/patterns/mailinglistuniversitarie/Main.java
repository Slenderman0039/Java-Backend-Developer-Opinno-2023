package patterns.mailinglistuniversitarie;

public class Main {

    public static void main(String[] args) {

        Docente andrea = new Docente("Andrea", "Gasparini", "ordinario");
        Docente marco = new Docente("Davide", "Fella", "ordinario");
        Docente davide = new Docente("Marco", "Adriani", "ordinario");

        Corso corsoJavaAndrea = new Corso("Java Developer di Andrea", andrea, "Zoom");

        Studente claudio = new Studente("Claudio");
        Studente alessandro = new Studente("Alessandro");
        Studente pasquale = new Studente("Pasquale");
        Studente giuseppe = new Studente("Giuseppe");
        Studente jacopo = new Studente("Jacopo");

        // Gli studenti si iscrivono al corso di andrea

        claudio.subscribe(corsoJavaAndrea);
        alessandro.subscribe(corsoJavaAndrea);
        pasquale.subscribe(corsoJavaAndrea);
        giuseppe.subscribe(corsoJavaAndrea);
        jacopo.subscribe(corsoJavaAndrea);

        System.out.print("Studenti iscritti al corso di Andrea:\n" + corsoJavaAndrea.studentiIscritti());

        // Andrea manda un messaggio ai suoi studenti

        String messaggioDiAndrea = andrea.sendMessage("Ragazzi oggi ritardo.", corsoJavaAndrea);

    }
}

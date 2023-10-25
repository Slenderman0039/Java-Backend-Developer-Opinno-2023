package esercizio2;

import java.util.Random;

public class Labirinto {

    private Entity[][] labirinto;
    private Muro[] mura = new Muro[10];
    private SpazioVuoto[] spaziVuoti = new SpazioVuoto[10];
    private Giocatore giocatore;
    private Mostro mostro;
    private Uscita uscita;
    private Vortice vortice1, vortice2, tmpVortice;
    private boolean flagVortice = false;

    public Labirinto(){
        labirinto = new Entity[5][5];
        generaLabirinto();
    }

    public Entity[][] getLabirinto() { return labirinto; }

    public Entity getEntity(Coordinate c){ return labirinto[c.getX()][c.getY()]; }

    public Giocatore getGiocatore() {
        return giocatore;
    }

    public void generaLabirinto(){

        /*for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                labirinto[i][j] = null;
            }
        }

        giocatore = null;
        mostro = null;
        uscita = null;
        vortice1 = null;
        vortice2 = null;

        for (int i = 0; i < 10; i++) {
            mura[i] = null;
            spaziVuoti[i] = null;
        }*/

        Coordinate posGiocatore, posMostro, posUscita, posVortice1, posVortice2;
        posGiocatore = (new Coordinate((int) (Math.random() * 5), (int)(Math.random() * 5)));
        giocatore = new Giocatore(posGiocatore);
        labirinto[posGiocatore.getX()][posGiocatore.getY()] = giocatore;

        //GENERIAMO GIOCATORE, MOSTRO, USCITA E DUE VORTICI

        do{
            posMostro = (new Coordinate((int) (Math.random() * 5), (int)(Math.random() * 5)));
            if(!(labirinto[posMostro.getX()][posMostro.getY()] instanceof Entity)){
                mostro = new Mostro(posMostro);
                labirinto[posMostro.getX()][posMostro.getY()] = mostro;
            }
        }while(!(labirinto[posMostro.getX()][posMostro.getY()] instanceof Mostro));

        do{
            posUscita = (new Coordinate((int) (Math.random() * 5), (int)(Math.random() * 5)));
            if(!(labirinto[posUscita.getX()][posUscita.getY()] instanceof Entity)){
                uscita = new Uscita(posUscita);
                labirinto[posUscita.getX()][posUscita.getY()] = uscita;
            }
        }while(!(labirinto[posUscita.getX()][posUscita.getY()] instanceof Uscita));

        do{
            posVortice1 = (new Coordinate((int) (Math.random() * 5), (int)(Math.random() * 5)));
            if(!(labirinto[posVortice1.getX()][posVortice1.getY()] instanceof Entity)){
                vortice1 = new Vortice(posVortice1);
                labirinto[posVortice1.getX()][posVortice1.getY()] = vortice1;
            }
        }while(!(labirinto[posVortice1.getX()][posVortice1.getY()] instanceof Vortice));

        do{
            posVortice2 = (new Coordinate((int) (Math.random() * 5), (int)(Math.random() * 5)));
            if(!(labirinto[posVortice2.getX()][posVortice2.getY()] instanceof Entity)){
                vortice2 = new Vortice(posVortice2);
                labirinto[posVortice2.getX()][posVortice2.getY()] = vortice2;
            }
        }while(!(labirinto[posVortice2.getX()][posVortice2.getY()] instanceof Vortice) && vortice1.getPosizione() != vortice2.getPosizione());

        //GENERIAMO 10 MURA E 10 SPAZI VUOTI

        int counterMura = 0, counterSpazi = 0;
        Coordinate posMura, posSpazio;

        do{
            posMura = (new Coordinate((int) (Math.random() * 5), (int)(Math.random() * 5)));
            if(!(labirinto[posMura.getX()][posMura.getY()] instanceof Entity)) {
                mura[counterMura] = new Muro(posMura);
                labirinto[posMura.getX()][posMura.getY()] = mura[counterMura++];
            }
        }while(counterMura != 10);

        do{
            posSpazio = (new Coordinate((int) (Math.random() * 5), (int)(Math.random() * 5)));
            if(!(labirinto[posSpazio.getX()][posSpazio.getY()] instanceof Entity)) {
                spaziVuoti[counterSpazi] = new SpazioVuoto(posSpazio);
                labirinto[posSpazio.getX()][posSpazio.getY()] = spaziVuoti[counterSpazi++];
            }
        }while(counterSpazi != 10);
    }

    public boolean muoviPersonaggio(char c){

        switch (c){
            default:
                System.out.println("Input invalido.");
                break;

            case 'r':
                generaLabirinto();
                break;

            case 'x':
                return false;

            case 'w':

                if(giocatore.getPosizione().getX() == 0){
                    System.out.println("Non puoi salire");
                    return false;
                }

                if(labirinto[giocatore.getPosizione().getX() - 1][giocatore.getPosizione().getY()] instanceof Muro){
                    System.out.println("Non puoi attraversare un muro.");
                    return false;
                }

                if(labirinto[giocatore.getPosizione().getX() - 1][giocatore.getPosizione().getY()] instanceof SpazioVuoto){

                    if(flagVortice == true){

                        labirinto[giocatore.getPosizione().getX() - 1][giocatore.getPosizione().getY()] = giocatore;
                        giocatore.setPosizione(giocatore.getPosizione().getX() - 1, giocatore.getPosizione().getY());

                        labirinto[giocatore.getPosizione().getX() + 1][giocatore.getPosizione().getY()] = tmpVortice;
                        tmpVortice.setPosizione(giocatore.getPosizione().getX() + 1, giocatore.getPosizione().getY());

                        flagVortice = false;
                    }

                    else{
                        SpazioVuoto tmp = (SpazioVuoto) labirinto[giocatore.getPosizione().getX() - 1][giocatore.getPosizione().getY()];

                        labirinto[giocatore.getPosizione().getX() - 1][giocatore.getPosizione().getY()] = giocatore;
                        giocatore.setPosizione(giocatore.getPosizione().getX() - 1, giocatore.getPosizione().getY());

                        labirinto[giocatore.getPosizione().getX() + 1][giocatore.getPosizione().getY()] = tmp;
                        tmp.setPosizione(giocatore.getPosizione().getX() + 1, giocatore.getPosizione().getY());
                    }

                    return true;
                }

                if(labirinto[giocatore.getPosizione().getX() - 1][giocatore.getPosizione().getY()] instanceof Vortice){

                    if(labirinto[giocatore.getPosizione().getX() - 1][giocatore.getPosizione().getY()].equals(vortice1)){

                        tmpVortice = vortice2;

                        labirinto[vortice2.getPosizione().getX()][vortice2.getPosizione().getY()] = giocatore;
                        giocatore.setPosizione(vortice2.getPosizione().getX(), vortice2.getPosizione().getY());

                        Coordinate coordinate = new Coordinate(vortice1.getPosizione().getX() + 1, vortice1.getPosizione().getY());
                        SpazioVuoto spazioVuoto = new SpazioVuoto(coordinate);
                        labirinto[vortice1.getPosizione().getX() + 1][vortice1.getPosizione().getY()] = spazioVuoto;

                    } else{

                        tmpVortice = vortice1;

                        labirinto[vortice1.getPosizione().getX()][vortice1.getPosizione().getY()] = giocatore;
                        giocatore.setPosizione(vortice1.getPosizione().getX(), vortice1.getPosizione().getY());

                        Coordinate coordinate = new Coordinate(vortice2.getPosizione().getX() + 1, vortice2.getPosizione().getY());
                        SpazioVuoto spazioVuoto = new SpazioVuoto(coordinate);
                        labirinto[vortice2.getPosizione().getX() + 1][vortice2.getPosizione().getY()] = spazioVuoto;

                    }
                    flagVortice = true;
                    return true;
                }

                if(labirinto[giocatore.getPosizione().getX() - 1][giocatore.getPosizione().getY()] instanceof Mostro){
                    System.out.println("Se ti muovi in questa direzione il mostro ti mangia");
                    return false;
                }

                if(labirinto[giocatore.getPosizione().getX() - 1][giocatore.getPosizione().getY()] instanceof Uscita){

                    Coordinate coordinate = new Coordinate(giocatore.getPosizione().getX(),giocatore.getPosizione().getY());
                    SpazioVuoto spazioVuoto = new SpazioVuoto(coordinate);
                    labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY()] = spazioVuoto;

                    labirinto[giocatore.getPosizione().getX()-1][giocatore.getPosizione().getY()] = giocatore;
                    giocatore.setPosizione(giocatore.getPosizione().getX()-1,giocatore.getPosizione().getY());
                    System.out.println("Hai vinto");
                    return true;
                }

                break;

            case 'a':

                if(giocatore.getPosizione().getY() == 0){
                    System.out.println("Non puoi andare a sinistra");
                    return false;
                }

                if(labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() - 1] instanceof Muro){
                    System.out.println("Non puoi attraversare un muro.");
                    return false;
                }

                if(labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() - 1] instanceof SpazioVuoto){

                    if(flagVortice == true){

                        labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() - 1] = giocatore;
                        giocatore.setPosizione(giocatore.getPosizione().getX(), giocatore.getPosizione().getY() - 1);

                        labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() + 1] = tmpVortice;
                        tmpVortice.setPosizione(giocatore.getPosizione().getX(), giocatore.getPosizione().getY() + 1);

                        flagVortice = false;
                    }

                    else{
                        SpazioVuoto tmp = (SpazioVuoto) labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() - 1];

                        labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() - 1] = giocatore;
                        giocatore.setPosizione(giocatore.getPosizione().getX(), giocatore.getPosizione().getY() - 1);

                        labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() + 1] = tmp;
                        tmp.setPosizione(giocatore.getPosizione().getX(), giocatore.getPosizione().getY() + 1);
                    }

                    return true;
                }

                if(labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() - 1] instanceof Vortice){

                    if(giocatore.getPosizione().getX() - 1 == vortice1.getPosizione().getX() && giocatore.getPosizione().getY() == vortice1.getPosizione().getY()){

                        tmpVortice = vortice2;

                        labirinto[vortice2.getPosizione().getX()][vortice2.getPosizione().getY()] = giocatore;
                        giocatore.setPosizione(vortice2.getPosizione().getX(), vortice2.getPosizione().getY());

                        Coordinate coordinate = new Coordinate(vortice1.getPosizione().getX(), vortice1.getPosizione().getY() + 1);
                        SpazioVuoto spazioVuoto = new SpazioVuoto(coordinate);
                        labirinto[vortice1.getPosizione().getX()][vortice1.getPosizione().getY() + 1] = spazioVuoto;

                    } else{

                        tmpVortice = vortice1;

                        labirinto[vortice1.getPosizione().getX()][vortice1.getPosizione().getY()] = giocatore;
                        giocatore.setPosizione(vortice1.getPosizione().getX(), vortice1.getPosizione().getY());

                        Coordinate coordinate = new Coordinate(vortice2.getPosizione().getX(), vortice2.getPosizione().getY() + 1);
                        SpazioVuoto spazioVuoto = new SpazioVuoto(coordinate);
                        labirinto[vortice2.getPosizione().getX()][vortice2.getPosizione().getY() + 1] = spazioVuoto;
                    }
                    flagVortice = true;
                    return true;
                }

                if(labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() - 1] instanceof Mostro){
                    System.out.println("Se ti muovi in questa direzione il mostro ti mangia");
                    return false;
                }

                if(labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() - 1] instanceof Uscita){

                    Coordinate coordinate = new Coordinate(giocatore.getPosizione().getX(),giocatore.getPosizione().getY());
                    SpazioVuoto spazioVuoto = new SpazioVuoto(coordinate);
                    labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY()] = spazioVuoto;

                    labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() - 1] = giocatore;
                    giocatore.setPosizione(giocatore.getPosizione().getX(),giocatore.getPosizione().getY() - 1);


                    System.out.println("Hai vinto");
                    return true;
                }

                break;

            case 's':

                if(giocatore.getPosizione().getX() == 4){
                    System.out.println("Non puoi scendere");
                    return false;
                }

                if(labirinto[giocatore.getPosizione().getX() + 1][giocatore.getPosizione().getY()] instanceof Muro){
                    System.out.println("Non puoi attraversare un muro.");
                    return false;
                }

                if(labirinto[giocatore.getPosizione().getX() + 1][giocatore.getPosizione().getY()] instanceof SpazioVuoto){

                    if(flagVortice == true){

                        labirinto[giocatore.getPosizione().getX() + 1][giocatore.getPosizione().getY()] = giocatore;
                        giocatore.setPosizione(giocatore.getPosizione().getX() + 1, giocatore.getPosizione().getY());

                        labirinto[giocatore.getPosizione().getX() - 1][giocatore.getPosizione().getY()] = tmpVortice;
                        tmpVortice.setPosizione(giocatore.getPosizione().getX() - 1, giocatore.getPosizione().getY());

                        flagVortice = false;
                    }

                    else{
                        SpazioVuoto tmp = (SpazioVuoto) labirinto[giocatore.getPosizione().getX() + 1][giocatore.getPosizione().getY()];

                        labirinto[giocatore.getPosizione().getX() + 1][giocatore.getPosizione().getY()] = giocatore;
                        giocatore.setPosizione(giocatore.getPosizione().getX() + 1, giocatore.getPosizione().getY());

                        labirinto[giocatore.getPosizione().getX() - 1][giocatore.getPosizione().getY()] = tmp;
                        tmp.setPosizione(giocatore.getPosizione().getX() - 1, giocatore.getPosizione().getY());
                    }

                    return true;
                }

                if(labirinto[giocatore.getPosizione().getX() - 1][giocatore.getPosizione().getY()] instanceof Vortice){

                    if(labirinto[giocatore.getPosizione().getX() - 1][giocatore.getPosizione().getY()].equals(vortice1)){

                        tmpVortice = vortice2;

                        labirinto[vortice2.getPosizione().getX()][vortice2.getPosizione().getY()] = giocatore;
                        giocatore.setPosizione(vortice2.getPosizione().getX(), vortice2.getPosizione().getY());

                        Coordinate coordinate = new Coordinate(vortice1.getPosizione().getX() - 1, vortice1.getPosizione().getY());
                        SpazioVuoto spazioVuoto = new SpazioVuoto(coordinate);
                        labirinto[vortice1.getPosizione().getX() - 1][vortice1.getPosizione().getY()] = spazioVuoto;

                    } else{

                        tmpVortice = vortice1;

                        labirinto[vortice1.getPosizione().getX()][vortice1.getPosizione().getY()] = giocatore;
                        giocatore.setPosizione(vortice1.getPosizione().getX(), vortice1.getPosizione().getY());

                        Coordinate coordinate = new Coordinate(vortice2.getPosizione().getX() - 1, vortice2.getPosizione().getY());
                        SpazioVuoto spazioVuoto = new SpazioVuoto(coordinate);
                        labirinto[vortice2.getPosizione().getX() - 1][vortice2.getPosizione().getY()] = spazioVuoto;

                    }
                    flagVortice = true;
                    return true;
                }

                if(labirinto[giocatore.getPosizione().getX() + 1][giocatore.getPosizione().getY()] instanceof Mostro){
                    System.out.println("Se ti muovi in questa direzione il mostro ti mangia");
                    return false;
                }

                if(labirinto[giocatore.getPosizione().getX() + 1][giocatore.getPosizione().getY()] instanceof Uscita){

                    Coordinate coordinate = new Coordinate(giocatore.getPosizione().getX(),giocatore.getPosizione().getY());
                    SpazioVuoto spazioVuoto = new SpazioVuoto(coordinate);
                    labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY()] = spazioVuoto;

                    labirinto[giocatore.getPosizione().getX()+1][giocatore.getPosizione().getY()] = giocatore;
                    giocatore.setPosizione(giocatore.getPosizione().getX()+1,giocatore.getPosizione().getY());

                    System.out.println("Hai vinto");
                    return true;
                }

                break;

            case 'd':

                if(giocatore.getPosizione().getY() == 4){
                    System.out.println("Non puoi andare a destra");
                    return false;
                }

                if(labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() + 1] instanceof Muro){
                    System.out.println("Non puoi attraversare un muro.");
                    return false;
                }

                if(labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() + 1] instanceof SpazioVuoto){

                    if(flagVortice == true){

                        labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() + 1] = giocatore;
                        giocatore.setPosizione(giocatore.getPosizione().getX(), giocatore.getPosizione().getY() + 1);

                        labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() - 1] = tmpVortice;
                        tmpVortice.setPosizione(giocatore.getPosizione().getX(), giocatore.getPosizione().getY() - 1);

                        flagVortice = false;
                    }

                    else{
                        SpazioVuoto tmp = (SpazioVuoto) labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() + 1];

                        labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() + 1] = giocatore;
                        giocatore.setPosizione(giocatore.getPosizione().getX(), giocatore.getPosizione().getY() + 1);

                        labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() - 1] = tmp;
                        tmp.setPosizione(giocatore.getPosizione().getX(), giocatore.getPosizione().getY() - 1);
                    }

                    return true;
                }

                if(labirinto[giocatore.getPosizione().getX() - 1][giocatore.getPosizione().getY()] instanceof Vortice){

                    if(labirinto[giocatore.getPosizione().getX() - 1][giocatore.getPosizione().getY()].equals(vortice1)){

                        tmpVortice = vortice2;

                        labirinto[vortice2.getPosizione().getX()][vortice2.getPosizione().getY()] = giocatore;
                        giocatore.setPosizione(vortice2.getPosizione().getX(), vortice2.getPosizione().getY());

                        Coordinate coordinate = new Coordinate(vortice1.getPosizione().getX() + 1, vortice1.getPosizione().getY());
                        SpazioVuoto spazioVuoto = new SpazioVuoto(coordinate);
                        labirinto[vortice1.getPosizione().getX() + 1][vortice1.getPosizione().getY()] = spazioVuoto;

                    } else{

                        tmpVortice = vortice1;

                        labirinto[vortice1.getPosizione().getX()][vortice1.getPosizione().getY()] = giocatore;
                        giocatore.setPosizione(vortice1.getPosizione().getX(), vortice1.getPosizione().getY());

                        Coordinate coordinate = new Coordinate(vortice2.getPosizione().getX() + 1, vortice2.getPosizione().getY());
                        SpazioVuoto spazioVuoto = new SpazioVuoto(coordinate);
                        labirinto[vortice2.getPosizione().getX() + 1][vortice2.getPosizione().getY()] = spazioVuoto;

                    }
                    flagVortice = true;
                    return true;
                }

                if(labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() + 1] instanceof Mostro){
                    System.out.println("Se ti muovi in questa direzione il mostro ti mangia");
                    return false;
                }

                if(labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY() + 1] instanceof Uscita){

                    Coordinate coordinate = new Coordinate(giocatore.getPosizione().getX(),giocatore.getPosizione().getY());
                    SpazioVuoto spazioVuoto = new SpazioVuoto(coordinate);
                    labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY()] = spazioVuoto;

                    labirinto[giocatore.getPosizione().getX()][giocatore.getPosizione().getY()+1] = giocatore;
                    giocatore.setPosizione(giocatore.getPosizione().getX(),giocatore.getPosizione().getY()+1);


                    System.out.println("Hai vinto");
                    return true;
                }

                break;

        }

        return false;
    }

    public boolean muoviMostro(){
        Random rand = new Random();

        int direzione = rand.nextInt(4);

        switch(direzione){

            case 1:         //w

                if(mostro.getPosizione().getX() == 0){
                    return false;
                }

                if(labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()] instanceof Muro || labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()] instanceof Uscita){
                    return false;
                }

                if(labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()] instanceof SpazioVuoto){

                    SpazioVuoto tmp = (SpazioVuoto) labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()];

                    labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()] = mostro;
                    mostro.setPosizione(giocatore.getPosizione().getX() - 1, mostro.getPosizione().getY());

                    labirinto[mostro.getPosizione().getX() + 1][mostro.getPosizione().getY()] = tmp;
                    tmp.setPosizione(mostro.getPosizione().getX() + 1, mostro.getPosizione().getY());

                    return true;
                }

                /*if(labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()] instanceof Vortice){
                    if(labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()].equals(vortice1)){
                        mostro.setPosizione(vortice2.getPosizione());
                        labirinto[giocatore.getPosizione().getX() + 1][giocatore.getPosizione().getY()] = mostro;
                        return true;
                    } else{
                        mostro.setPosizione(vortice1.getPosizione());
                        labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()] = mostro;
                        return true;
                    }
                }*/

                break;

            case 3: //a

                if(mostro.getPosizione().getY() == 0){
                    return false;
                }

                if(labirinto[mostro.getPosizione().getX()][mostro.getPosizione().getY() - 1] instanceof Muro || labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()] instanceof Uscita){
                    return false;
                }

                if(labirinto[mostro.getPosizione().getX()][mostro.getPosizione().getY() - 1] instanceof SpazioVuoto){

                    SpazioVuoto tmp = (SpazioVuoto) labirinto[mostro.getPosizione().getX()][mostro.getPosizione().getY() - 1];

                    labirinto[mostro.getPosizione().getX()][mostro.getPosizione().getY() - 1] = mostro;
                    mostro.setPosizione(mostro.getPosizione().getX(), mostro.getPosizione().getY() - 1);

                    labirinto[mostro.getPosizione().getX()][mostro.getPosizione().getY() + 1] = tmp;
                    tmp.setPosizione(mostro.getPosizione().getX(), mostro.getPosizione().getY() + 1);

                    return true;
                }

                /*if(labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()] instanceof Vortice){
                    if(labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()].equals(vortice1)){
                        mostro.setPosizione(vortice2.getPosizione());
                        labirinto[mostro.getPosizione().getX() + 1][mostro.getPosizione().getY()] = mostro;
                        return true;
                    } else{
                        mostro.setPosizione(vortice1.getPosizione());
                        labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()] = mostro;
                        return true;
                    }
                }*/

                if(labirinto[mostro.getPosizione().getX()][mostro.getPosizione().getY() - 1] instanceof Uscita){
                    return true;
                }

                break;

            case 2:     //s

                if(mostro.getPosizione().getX() == 4){
                    return false;
                }

                if(labirinto[mostro.getPosizione().getX() + 1][mostro.getPosizione().getY()] instanceof Muro || labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()] instanceof Uscita){
                    return false;
                }

                if(labirinto[mostro.getPosizione().getX() + 1][mostro.getPosizione().getY()] instanceof SpazioVuoto){

                    SpazioVuoto tmp = (SpazioVuoto) labirinto[giocatore.getPosizione().getX() + 1][mostro.getPosizione().getY()];

                    labirinto[mostro.getPosizione().getX() + 1][giocatore.getPosizione().getY()] = mostro;
                    giocatore.setPosizione(mostro.getPosizione().getX() + 1, mostro.getPosizione().getY());

                    labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()] = tmp;
                    tmp.setPosizione(mostro.getPosizione().getX() - 1, mostro.getPosizione().getY());

                    return true;
                }

                /*if(labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()] instanceof Vortice){
                    if(labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()].equals(vortice1)){
                        mostro.setPosizione(vortice2.getPosizione());
                        labirinto[mostro.getPosizione().getX() + 1][mostro.getPosizione().getY()] = mostro;
                        return true;
                    } else{
                        mostro.setPosizione(vortice1.getPosizione());
                        labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()] = mostro;
                        return true;
                    }
                }*/

                break;

            case 4: //d

                if(mostro.getPosizione().getY() == 4){
                    return false;
                }

                if(labirinto[mostro.getPosizione().getX()][mostro.getPosizione().getY() + 1] instanceof Muro || labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()] instanceof Uscita){
                    return false;
                }

                if(labirinto[mostro.getPosizione().getX()][mostro.getPosizione().getY() + 1] instanceof SpazioVuoto){

                    SpazioVuoto tmp = (SpazioVuoto) labirinto[mostro.getPosizione().getX()][mostro.getPosizione().getY() + 1];

                    labirinto[mostro.getPosizione().getX()][mostro.getPosizione().getY() + 1] = mostro;
                    mostro.setPosizione(mostro.getPosizione().getX(), mostro.getPosizione().getY() + 1);

                    labirinto[mostro.getPosizione().getX()][mostro.getPosizione().getY() - 1] = tmp;
                    tmp.setPosizione(mostro.getPosizione().getX(), mostro.getPosizione().getY() - 1);

                    return true;
                }

                /*if(labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()] instanceof Vortice){
                    if(labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()].equals(vortice1)){
                        mostro.setPosizione(vortice2.getPosizione());
                        labirinto[mostro.getPosizione().getX() + 1][mostro.getPosizione().getY()] = mostro;
                        return true;
                    } else{
                        mostro.setPosizione(vortice1.getPosizione());
                        labirinto[mostro.getPosizione().getX() - 1][mostro.getPosizione().getY()] = mostro;
                        return true;
                    }
                }*/

                break;
        }

        return false;
    }


    public String stampaLabirinto(){

        String s = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                s += "[ " + labirinto[i][j].toString() + " ]";
            }
            s += "\n";
        }
        return s;
    }

}
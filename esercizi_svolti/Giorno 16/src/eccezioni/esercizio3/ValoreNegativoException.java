package eccezioni.esercizio3;

public class ValoreNegativoException extends Exception{

    public ValoreNegativoException(){
        super();
    }

    @Override
    public String getMessage(){
        return "Hai inserito un numero negativo";
    }

}
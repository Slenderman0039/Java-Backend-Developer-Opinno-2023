package esercizio4;

import java.util.ArrayList;
import java.util.List;

public class Pila<T> {

    List<T> pila = new ArrayList<>();

    public void push(T elem){
        pila.add(0, elem);
    }

    public T pop(){
        return pila.remove(0);
    }

    public T peek(){ return pila.get(0); }

    public boolean isEmpty(){ return (pila.size() == 0); }

    public String toString(){
        String s = "";
        for(T i : pila){
            s += i.toString() + " ";
        }
        return s;
    }
}

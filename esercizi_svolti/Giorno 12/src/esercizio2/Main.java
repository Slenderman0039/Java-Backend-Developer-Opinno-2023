package esercizio2;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        //Write a Java program to append the specified element to the end of a linked list.

        LinkedList<String> colori = new LinkedList<>();

        colori.add("Rosso");
        colori.add("Blu");
        colori.add("Nero");
        colori.add("Viola");
        colori.add("Giallo");

        colori.addLast("Grigio");

        //Write a Java program to iterate through all elements in a linked list.

        for(String i : colori)
            System.out.println(i);
        System.out.println("\n--------------------------");

        //Write a Java program to iterate through all elements in a linked list starting at the specified position

        for(int i = 2; i < colori.size(); i++)
            System.out.println(colori.get(i));

        //Write a Java program to iterate a linked list in reverse order.

        System.out.println("\n--------------------------");
        for(int i = colori.size() - 1; i >= 0; i--)
            System.out.println(colori.get(i));
    }
}

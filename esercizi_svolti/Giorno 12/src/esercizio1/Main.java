package esercizio1;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        //Write a Java program to create an array list, add some colors (strings) and print out the collection.
        //DICHIARO L'ARRAYLIST

        ArrayList<String> colori = new ArrayList<>();

        //RIEMPIO L'ARRAYLIST

        colori.add("Rosso");
        colori.add("Blu");
        colori.add("Nero");
        colori.add("Viola");
        colori.add("Giallo");

        System.out.println(colori.toString());

        colori.remove("Nero");
        System.out.println(colori);
        System.out.println("----------------------");

        //Write a Java program to iterate through all elements in an array list.

        for(String i : colori)
            System.out.print(i + ", ");

        System.out.println("\n---------------");

        for(int i = 0; i < colori.size(); i++)
            System.out.print(colori.get(i));

        //Write a Java program to insert an element into the array list at the first position.

        System.out.println("\n---------------");
        colori.add(0, "Ciano");
        System.out.println(colori);

        //Write a Java program to retrieve an element (at a specified index) from a given array list.
        String coloreDaRitornare = colori.get(2);
        System.out.println("\n---------------");
        System.out.println(coloreDaRitornare);

        //Write a Java program to update an array element by the given element.

        colori.set(colori.indexOf("Rosso"), "Arancione");
        System.out.println("\n----------------------");
        System.out.println(colori);

        //Write a Java program to remove the third element from an array list
        colori.remove(2);
        System.out.println("\n----------------------");
        System.out.println(colori);

        //Write a Java program to search for an element in an array list.
        System.out.println("\n----------------------");
        System.out.println(colori);
        System.out.println(colori.contains("Ciano"));
        System.out.println(colori.contains("Grigio"));

        //Write a Java program to sort a given array list.
        colori.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) { return o1.compareTo(o2); }
        });

        System.out.println("\n----------------------");
        System.out.println(colori);

        ArrayList<Integer> arrayNumeri = new ArrayList<>();
        arrayNumeri.add(2);
        arrayNumeri.add(4);
        arrayNumeri.add(6);
        arrayNumeri.add(3);

        ArrayList<Object> arrayObject = new ArrayList<>();
        arrayObject.addAll(arrayNumeri);
        arrayObject.addAll(colori);

        System.out.println(arrayObject);

    }
}
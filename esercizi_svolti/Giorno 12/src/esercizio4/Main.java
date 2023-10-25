package esercizio4;

public class Main {

    public static void main(String[] args) {

        Pila<Integer> pilaDiInteri = new Pila<>();

        pilaDiInteri.push(1);
        pilaDiInteri.push(7);
        pilaDiInteri.push(134);
        pilaDiInteri.push(9);
        pilaDiInteri.push(2);

        System.out.println(pilaDiInteri.toString());

        System.out.println(pilaDiInteri.pop());
        System.out.println(pilaDiInteri.toString());

        System.out.println(pilaDiInteri.peek());
        System.out.println(pilaDiInteri.toString());

        System.out.println(pilaDiInteri.isEmpty());

        Pila<String> pilaDiStringhe = new Pila<>();
        pilaDiStringhe.push("Pasquale");
        pilaDiStringhe.push("Alessandro");
        pilaDiStringhe.push("Claudio");
        pilaDiStringhe.push("Jacopo");
        pilaDiStringhe.push("Giuseppe");

        System.out.println(pilaDiStringhe.toString());

        System.out.println(pilaDiStringhe.pop());
        System.out.println(pilaDiStringhe.toString());

        System.out.println(pilaDiStringhe.peek());
        System.out.println(pilaDiStringhe.toString());

        System.out.println(pilaDiStringhe.isEmpty());
    }
}

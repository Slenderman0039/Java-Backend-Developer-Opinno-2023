package patterns.tripleton;

public class Main {

    public static void main(String[] args) {

        Tripleton tripleton = Tripleton.getInstance();
        System.out.println(tripleton);
        tripleton = Tripleton.getInstance();
        System.out.println(tripleton);
        tripleton = Tripleton.getInstance();
        System.out.println(tripleton);
        tripleton = Tripleton.getInstance();
        System.out.println(tripleton);
        tripleton = Tripleton.getInstance();
        System.out.println(tripleton);
        tripleton = Tripleton.getInstance();
        System.out.println(tripleton);
        tripleton = Tripleton.getInstance();
        System.out.println(tripleton);
        tripleton = Tripleton.getInstance();
        System.out.println(tripleton);

    }
}

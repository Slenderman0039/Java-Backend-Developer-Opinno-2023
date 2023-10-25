package patterns.tripleton;

import java.util.ArrayList;
import java.util.List;

public class Tripleton {

    private static List<Tripleton> instances = new ArrayList<>();
    private static int counter = 0;
    private static Tripleton internalInstance;
    private static boolean flag = false;

    private Tripleton(){}

    public static Tripleton getInstance(){
        if(counter > 2){
            flag = true;
            counter = 0;
        }
        if(flag == false){
            instances.add(new Tripleton());
            return instances.get(counter++);
        }
        else{
            return instances.get(counter++);
        }
    }

    public String toString(){ return String.valueOf(counter); }
}

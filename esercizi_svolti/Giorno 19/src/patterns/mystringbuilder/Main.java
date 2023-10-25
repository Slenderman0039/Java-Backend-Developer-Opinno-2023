package patterns.mystringbuilder;

public class Main {

    public static void main(String[] args) {

        MyString.MyStringBuilder msb = new MyString.MyStringBuilder();

        msb.append("Facilissimo")
                .append(" concatenare")
                .append(" stringhe!");

        MyString myFinalString = msb.build();

        System.out.println(myFinalString.toString().equals("Facilissimo concatenare stringhe!"));
        System.out.println(myFinalString.toString());

    }

}
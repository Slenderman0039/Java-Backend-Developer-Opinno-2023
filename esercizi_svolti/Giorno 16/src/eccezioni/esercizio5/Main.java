package eccezioni.esercizio5;

import java.io.*;


public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = null;

        //file.txt va messo nella directory principale

        try{
            br = new BufferedReader(new FileReader("file.txt"));
            String line = br.readLine();
            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch(NullPointerException exc){
            System.out.println(exc);
        }
        catch(FileNotFoundException exc){
            System.out.println(exc);
        }
        catch(IOException exc){
            System.out.println(exc);
        }
        finally {
            if(br != null) {
                br.close();
                System.out.println("File chiuso.");
            }
        }


        /*File f = new File("prova.txt");
        f.createNewFile();*/
    }
}
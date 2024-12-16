package flujoDatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leer {

    public static String dato() throws IOException{
        String dato = "";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        dato = br.readLine();


        return dato;
    }

    public static int datoInt() throws IOException, NumberFormatException{
        int num = 0;

        num = Integer.parseInt(dato());

        return num;
    }

    public static double datoDouble() throws NumberFormatException, IOException{
        double num = 0;
        String cadena = "";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);
        
        cadena = bf.readLine();

        num = Double.parseDouble(cadena);

        return num;
    }

}

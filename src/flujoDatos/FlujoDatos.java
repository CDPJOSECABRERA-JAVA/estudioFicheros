package flujoDatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlujoDatos {
    public FlujoDatos(){
        System.out.println("Estudio flujo de datos");
        String dato = "";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int num;

        System.out.println("Introduzca un dato:");

        try {
            dato=br.readLine();
            num = Integer.parseInt(dato);
            System.out.println("Dato = " + num);

        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}

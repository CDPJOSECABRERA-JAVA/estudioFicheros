package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Desencriptar {


    public Desencriptar(String frase){
        
        File f = new File("Ficheros//desencriptar.txt");

        try {
            if (!f.exists()) {
                f.createNewFile();
                System.out.println("El archivo ha sido creado con exito.");
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error con el fichero.");
            System.exit(0);
        }

        String[] ficheroArr;
        int[] arr;

        String fraseDesencriptada = "";
        int numPalabras;
        int tamanioPalabra;
        int puntero;

        int posLetra, relatividad;


        try(FileReader fr = new FileReader(f); BufferedReader bf = new BufferedReader(fr)) {
            
            ficheroArr = bf.readLine().split(",");
            arr = arrToInt(ficheroArr);

            numPalabras = arr[0];
            puntero = 1;

            for (int i = 0; i < numPalabras; i++) {
            tamanioPalabra = arr[puntero];
            puntero++;   

                for (int j = 0; j < tamanioPalabra; j++) {
                    posLetra = arr[puntero];
                    puntero++;
                    relatividad = arr[puntero];
                    puntero++;

                    fraseDesencriptada += desencriptarLetra(posLetra, relatividad);
                }
                fraseDesencriptada += " ";
            }
            
            System.out.println(fraseDesencriptada);

        } catch (IOException e) {
            System.out.println("Error relacionado con el archivo.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    char desencriptarLetra(int posLetra, int relatividad){
        char letra;
        String alfabeto = "abcdefghijklmnopqrstuvwxyz";

        letra = (relatividad%2 == 0) ? alfabeto.charAt(posLetra - 1) : alfabeto.charAt(alfabeto.length() - posLetra);

        return letra;
    }

    int[] arrToInt(String[] strArr){
        int[] arr = new int[strArr.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        
        return arr;
    }
}

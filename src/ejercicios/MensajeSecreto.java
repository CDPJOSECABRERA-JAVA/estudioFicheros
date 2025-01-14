package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MensajeSecreto {
    public MensajeSecreto(){

        //CREAR Y COMPROBAR SI EL ARCHIVO EXISTE
        File archivo = new File("Ficheros\\mensajeSecreto.txt");

        try {

            if (archivo.exists()) {
                System.out.println("El archivo ya existe.");
            }else{
                archivo.createNewFile();
                System.out.println("Archivo creado correctamente.");
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error inesperado.");
            System.out.println("Saliendo...");
            System.exit(1);
        }

        //DECLARACION DE VARIABLES
        String[] alfabeto = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int numeroDePalabras =0;
        int longitudPalabra = 0;
        int posPalabra = 0;
        int relatividad = 0;
        String fraseDesencriptada = "";
        String palabra = "";

        int[] palabrasInt = new int[0];
 
        // DESENCRIPTACION DEL FICHERO
        try (FileReader fr = new FileReader(archivo); BufferedReader br = new BufferedReader(fr)) {
            
            numeroDePalabras = Integer.parseInt(br.readLine());
            for (int i = 0; i < numeroDePalabras; i++) {
                
                longitudPalabra = Integer.parseInt(br.readLine());
                palabrasInt = new int[longitudPalabra];

                for (int j = 0; j < longitudPalabra; j++) {
                    posPalabra = Integer.parseInt(br.readLine());
                    relatividad = Integer.parseInt(br.readLine());

                    if (relatividad%2 == 0) palabrasInt[j] = posPalabra-1;
                    else palabrasInt[j] = alfabeto.length - posPalabra;
                }
                
                System.out.println(desencriptar(alfabeto, palabrasInt));
                System.out.println(Arrays.toString(palabrasInt));
            }
        
            
            
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error inesperado.");
            System.out.println("Saliendo...");
            System.exit(1);
        }

        System.out.println(fraseDesencriptada);
    }

    public static String desencriptar(String[] alfabeto, int[] palabraInt){
        String palabra = "";

        for (int i = 0; i < palabraInt.length; i++) {
            palabra += alfabeto[palabraInt[i]];
        }

        return palabra;
    }

    /* 
    public static void escribirFichero(int[] numsEntrada, File archivo){
        int cont = 0;
        archivo.delete();
        do {
            try(FileWriter fw = new FileWriter(archivo, true)) {
                fw.write(String.valueOf(numsEntrada[cont]) + (char)13);
                cont++;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } while (cont != numsEntrada.length);
    }
    */
    
}

package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
 
        // DESENCRIPTACION DEL FICHERO
        try (FileReader fr = new FileReader(archivo); BufferedReader br = new BufferedReader(fr)) {
            
            numeroDePalabras = Integer.parseInt(br.readLine());

            for (int i = 0; i < numeroDePalabras; i++) {
                longitudPalabra = Integer.parseInt(br.readLine());
                for (int j = 0; j < longitudPalabra; j++) {
                    posPalabra = Integer.parseInt(br.readLine());
                    relatividad = Integer.parseInt(br.readLine());
                    
                    if (relatividad%2 == 0) palabra += alfabeto[posPalabra-1];
                    else palabra += alfabeto[alfabeto.length - posPalabra];
                }
                    fraseDesencriptada += palabra;
                    fraseDesencriptada += " ";

                    palabra = ""; 
            }
            
            
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error inesperado.");
            System.out.println("Saliendo...");
            System.exit(1);
        }

        System.out.println(fraseDesencriptada);
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

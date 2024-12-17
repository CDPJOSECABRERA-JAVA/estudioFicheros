package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MensajeSecreto {
    public MensajeSecreto(){


        
        //CREAR Y COMPROBAR SI EL ARCHIVO EXISTE
        File archivo = new File("Ficheros\\mensajeSecreto.txt");

        try {
            boolean creado = archivo.createNewFile();

            if (creado) System.out.println("El archivo ha sido creado satisfactoriamente");
            else System.out.println("El archivo no ha sido creado o ya existe.");
        } catch (IOException e) {
            System.out.println("Error.");
        }


        
        try  {
            leerFichero(archivo);
            
        } catch (IOException e) {
            System.out.println("error");
        }

        

    }

    
    public static void leerFichero(File f) throws IOException{
        FileReader fr;
        BufferedReader br;


        fr = new FileReader(f);
        br = new BufferedReader(fr);
        
        //primera linea (cantidad de palabras)
        int cantidadPalabras = Integer.parseInt(br.readLine());

        for (int i = 0; i <= cantidadPalabras; i++) {
            System.out.println(br.readLine());
        }

        

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

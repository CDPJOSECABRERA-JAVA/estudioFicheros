package ejercicios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MensajeSecreto {
    public MensajeSecreto(){
        int[] numsEntrada = {5,2,5,-10,12,194,7,22,-11,13,197,5,40,14,-13,9,222,20,13,12,-77,
            7,1,-34,7,-7,26,99,24,777,1,214,9,9,1,98,2,26,49,15,7,8,26,25,13,100,26,77,14,200,
            22,7,3,-38,5,98,9,3
        };

        
        //CREAR Y COMPROBAR SI EL ARCHIVO EXISTE
        File archivo = new File("Ficheros\\mensajeSecreto.txt");

        try {
            boolean creado = archivo.createNewFile();

            if (creado) System.out.println("El archivo ha sido creado satisfactoriamente");
            else System.out.println("El archivo no ha sido creado o ya existe.");
        } catch (IOException e) {
            System.out.println("Error.");
        }

        //RELLENAR EL FICHERO:

            escribirFichero(numsEntrada, archivo);

        

    }

    
    
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
}

package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FicheroNotasAlumnos {
    public FicheroNotasAlumnos(){
        File f = new File("Ficheros\\notasAlumnos.txt");

        //COMPROBAR SI EXISTE EL FICHERO
        try {
            if (f.exists()) System.out.println("El archivo ya existe.");
            else {
                f.createNewFile();
                System.out.println("Archivo creado (vacío).");
            }
            
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado.");
            System.out.println("Saliendo...");
            System.exit(1);
        }

        //LEER FICHERO
        String alumnosStr ="", asignaturasStr = "", linea = "";
        String[] fila = new String[0];
        String[] alumnos = new String[0], asignaturas = new String[0];
        int[][] notas = new int[0][0];

        try(FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr)) {
            alumnos = br.readLine().split(",");
            asignaturas = br.readLine().split(",");

            notas = new int[asignaturas.length][];

            for (int i = 0; i < notas.length; i++) {
                linea = br.readLine();
                fila = linea.split(",");
                notas[i] = recibirFila(fila);
            }

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error relacionado con el fichero.");
            System.exit(1);
        } catch (Exception e){
            System.out.println(e.getMessage());
        } 

        System.out.println(Arrays.toString(alumnos));
        System.out.println(Arrays.toString(asignaturas));
        for (int i = 0; i < notas.length; i++) {
            System.out.println(Arrays.toString(notas[i]));
        }
        
    }

    static int[] recibirFila(String[] fila){
        int[] arr = new int[fila.length];
        
        for (int i = 0; i < fila.length; i++) {
            arr[i] = Integer.parseInt(fila[i]);
        }

        return arr;
    }
}

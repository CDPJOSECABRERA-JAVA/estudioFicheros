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
        String[] alumnos = new String[0], asignaturas = new String[0];
        String[][] notas = new String[0][0];
        int i = 0;
        boolean vacio = false;

        try(FileReader fr = new FileReader(f); BufferedReader bf = new BufferedReader(fr)) {
            alumnosStr = bf.readLine();
            asignaturasStr = bf.readLine();

            alumnos = alumnosStr.split(",");
            asignaturas = asignaturasStr.split(",");

            notas = new String[asignaturas.length][alumnos.length];

            while ((linea = bf.readLine()) != null) {
                notas[i] = linea.split(",");
                i++;
            }
            
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error relacionado con el fichero.");
            System.exit(1);
        } catch (Exception e){
            System.out.println(e.getMessage());
        } 

        System.out.println(Arrays.toString(alumnos));
        System.out.println(Arrays.toString(asignaturas));
        for (int j = 0; j < notas.length; j++) {
            System.out.println(Arrays.toString(notas[j]));
        }
        

    }
}

package estudioFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class Ficheros {

    public Ficheros(){
    //C:\Users\criis\Documents\ASIGNATURAS\PROGRAMACION\workspace\introduccionProgramacion\estudioFicheros
        System.out.println("-----------Estudio Ficheros-----------");
        File fichero, directorio;
        //Creacion directorio;
        directorio = new File("Ficheros");
        if (!directorio.exists()) directorio.mkdir();


        //Saber si es un directorio

        if (directorio.isDirectory()) {
            System.out.println("Si es un directorio.");
        };

        // crear fichero
        File f = new File("fichero.txt");
        try {
            if (!f.exists()) f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileReader fr;
        BufferedReader br;

        try {
           fr = new FileReader(f);
           br = new BufferedReader(fr);
           System.out.println(br.readLine());
           System.out.println(br.readLine());
           System.out.println(br.readLine());
           System.out.println(br.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* 
            System.out.println("Nombre: " + fichero.getName());
            System.out.println("Path: " + fichero.getPath());
            System.out.println("Parent: " + fichero.getParent());
            System.out.println("AbsolutePath: " + fichero.getAbsolutePath());
            System.out.println("Modificado: " + fichero.lastModified());
            System.out.println("Path: " + fichero.getPath());
            System.out.println(" " + new Date(fichero.lastModified()));
        */
    }

    
}

package estudioFicheros;

import java.io.File;
import java.util.Date;

public class Ficheros {

    public Ficheros(){
    //C:\Users\criis\Documents\ASIGNATURAS\PROGRAMACION\workspace\introduccionProgramacion\estudioFicheros
        System.out.println("-----------Estudio Ficheros-----------");
        File fichero, directorio;
        String ruta = "C:\\Users\\criis\\Documents\\ASIGNATURAS\\PROGRAMACION\\workspace\\introduccionProgramacion\\estudioFicheros\\Ficheros\\";
        //Creacion directorio;
        directorio = new File(ruta);
        
        boolean exito = directorio.mkdir();

        if (exito) System.out.println("Directorio creado con exito");
        else System.out.println("No se ha creado el directorio o ya existe.");

        //Saber si es un directorio

        if (directorio.isDirectory()) {
            System.out.println("Si es un directorio.");
        };

        // crear fichero
        try {
            fichero = new File(ruta + "elMensajeSecreto.txt");
            exito = fichero.createNewFile();

            if (exito) System.out.println("Fichero creado satisfactoriamente.");
            else System.out.println("No se ha creado o ya existe");

        /* 
            System.out.println("Nombre: " + fichero.getName());
            System.out.println("Path: " + fichero.getPath());
            System.out.println("Parent: " + fichero.getParent());
            System.out.println("AbsolutePath: " + fichero.getAbsolutePath());
            System.out.println("Modificado: " + fichero.lastModified());
            System.out.println("Path: " + fichero.getPath());
            System.out.println(" " + new Date(fichero.lastModified()));
        */
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    
}

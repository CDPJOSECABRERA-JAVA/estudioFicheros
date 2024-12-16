package estudioFicheros;

import java.io.File;
import java.util.Date;

public class Ficheros {

    public Ficheros(){
    //C:\Users\criis\Documents\ASIGNATURAS\PROGRAMACION\workspace\introduccionProgramacion\estudioFicheros
        System.out.println("-----------Estudio Ficheros-----------");
        File fichero, directorio;

        //Creacion directorio;
        directorio = new File("C:\\Users\\criis\\Documents\\ASIGNATURAS\\PROGRAMACION\\workspace\\introduccionProgramacion\\estudioFicheros\\Ficheros");
        boolean exito = directorio.mkdir();

        if (exito) System.out.println("Directorio creado con exito");
        else System.out.println("No se ha creado el directorio o ya existe.");

        //Saber si es un directorio

        if (directorio.isDirectory()) {
            System.out.println("Si es un directorio.");
        }

        String ruta = "C:\\Users\\criis\\Documents\\ASIGNATURAS\\PROGRAMACION\\workspace\\introduccionProgramacion\\estudioFicheros\\Ficheros\\";

        // crear fichero
        fichero = new File(ruta + "prueba.txt");
        try {
            exito = fichero.createNewFile();
            if (exito) System.out.println("Fichero creado satisfactoriamente.");
            else System.out.println("No se ha creado o ya existe");

            fichero = new File("alumnos.txt");
            fichero.createNewFile();
            System.out.println("Nombre: " + fichero.getName());
            System.out.println("Path: " + fichero.getPath());
            System.out.println("Parent: " + fichero.getParent());
            System.out.println("AbsolutePath: " + fichero.getAbsolutePath());
            System.out.println("Modificado: " + fichero.lastModified());
            System.out.println("Path: " + fichero.getPath());
            System.out.println(" " + new Date(fichero.lastModified()));

        } catch (Exception e) {
            
        }
    }

    
}

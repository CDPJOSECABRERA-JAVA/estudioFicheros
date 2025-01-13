package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Notas {

    public Notas(){
        
        String[] alumnos = new String[0];
        String[] examenes = new String[0];
        int[][] notas = new int[0][0];
        File f = new File("Ficheros\\notas.txt");
        FileReader fr;
        BufferedReader bf;
        
        try{
        if (f.exists()) {
            System.out.println("El archivo ya existe");
        } else {
            f.createNewFile();
            System.out.println("Archivo creado");
        }
        fr = new FileReader(f);
        bf = new BufferedReader(fr);

        alumnos = bf.readLine().split(",");
        examenes = bf.readLine().split(",");

        notas = new int[examenes.length][];

        for (int i = 0; i < notas.length; i++) {
            notas[i] = arrayToInt(bf.readLine().split(","));
        }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        int mayorPrimerExamen = notaMasAlta(notas[0], alumnos);
        int mayorSegundoExamen = notaMasAlta(notas[3], alumnos);

        int notaMayor = (mayorPrimerExamen > mayorSegundoExamen) ? mayorPrimerExamen : mayorSegundoExamen;
        System.out.println("La nota mayor entre las dos es: " + notaMayor);

        //System.out.println(Arrays.toString(alumnos));
        //System.out.println(Arrays.toString(examenes));
        //System.out.println(Arrays.deepToString(notas));
    }

    static int[] arrayToInt(String[] arrStr){
        int[] arrInt = new int[arrStr.length];

        for (int i = 0; i < arrStr.length; i++) {
            arrInt[i] = Integer.parseInt(arrStr[i]);
        }

        return arrInt;
    }

    static int notaMasAlta(int[] arr, String[] alumnos){
        int x = arr[0];
        String alumno = "";

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > x){
                x = arr[i];
                alumno = alumnos[i];
            }
        }

        System.out.printf("La nota mas alta del examen es %d y la ha sacado %s\n", x, alumno);

        return x;
    }



}

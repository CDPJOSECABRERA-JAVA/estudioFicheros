package ejercicios;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CuadradoMagico {
    public CuadradoMagico(){
        File f = new File("Ficheros\\cuadradoMagico.txt");

            try {
                if (f.exists()) {
                    System.out.println("El archivo ya existe.");
                } else{
                    f.createNewFile();
                    System.out.println("Archivo creado");
                } 
            } catch (IOException e) {
                e.printStackTrace();
            }
    
            int numCuadrados = 0, filasYcolumnas = 0;
            int[][] arr;

            try(FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr)) {
                numCuadrados = Integer.parseInt(br.readLine());
                for (int i = 0; i < numCuadrados; i++) {
                    filasYcolumnas = Integer.parseInt(br.readLine());
                    arr = new int[filasYcolumnas][filasYcolumnas];

                    for (int j = 0; j < arr.length; j++) {
                        arr[j] = recibirFila(br.readLine().split(","));
                    }

                    System.out.println(Arrays.deepToString(arr));

                }
            
            
            } catch (Exception e) {
                System.out.println(e.getMessage());
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

package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class MaquinaGolosinas {
    public MaquinaGolosinas(){
        String[][] golosinas = new String[0][0];
        double[][] precios = new double[0][0];
        int[][] stock = new int[0][0];
        int tamano = 0;

        File f = new File("Ficheros\\maquinaGolosinas.txt");

        try (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr)){
            
            if (!f.exists()) {
                f.createNewFile();
                System.out.println("Archivo creado.");
            }

            tamano = Integer.parseInt(br.readLine());
            
            golosinas = new String[tamano][tamano];
            precios = new double[tamano][tamano];
            stock = new int[tamano][tamano];

            for (int i = 0; i < tamano; i++) {
                golosinas[i] = br.readLine().split(",");
            }
            
            for (int i = 0; i < tamano; i++) {
                precios[i] = arrToDouble(br.readLine().split(","));
            }

            for (int i = 0; i < tamano; i++) {
                stock[i] = arrToInt(br.readLine().split(","));
            }

            for (int i = 0; i < stock.length; i++) {
                System.out.println(Arrays.toString(golosinas[i]));
                System.out.println(Arrays.toString(precios[i]));
                System.out.println(Arrays.toString(stock[i]));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        int[][] ventas = new int[tamano][tamano];
        Scanner sc = new Scanner(System.in);
        double totalVentas = 0;
        boolean encendido = true;
        
        while (encendido) {
            mostrarMenu();

            switch (sc.nextInt()) {
                case 1:
                    totalVentas += pedirGolosina(golosinas,precios,stock, ventas);
                    break;
                case 2:
                    mostrarGolosinas(golosinas, precios);
                    break;
                case 3:
                    rellenarGolosina(golosinas, stock);
                    break;
                case 4:
                    ventasTotales(ventas, golosinas, totalVentas);
                    encendido = false;
                    break;
                default:
                    System.out.println("Código inválido.");
                    break;
            }

        }
    
    }
    /* M E T O D O S  D E  M A Q U I N A  G O L O S I N A S */
    static void mostrarGolosinas(String[][] golosinas, double[][] precios){

        String[] datos = {"COD.", "NOMBRE", "PRECIO$"};
        System.out.printf("%s %10s %15s", datos[0], datos[1], datos[2]);
        System.out.println();
        for (int i = 0; i < precios.length; i++) {
            for (int j = 0; j < precios.length; j++) {
                System.out.printf("%s %15.10s %10.1f$", i+""+j, golosinas[i][j], precios[i][j]);
                System.out.println();
            }
            
        }

    }

    static double pedirGolosina(String[][] golosinas, double[][] precios, int[][] stock, int[][] ventas){
 
        int[] filaYcolumna = new int[2];
        int f, c;
        double precio = 0;

        filaYcolumna = pedirCodigoProducto(stock);
        f = filaYcolumna[0];
        c = filaYcolumna[1];

        if (stock[f][c] == 0) {
            System.out.println("No quedan mas unidades de este producto.");
            return precio;
        }

        System.out.println("Has comprado: " + golosinas[f][c]);
        precio = precios[f][c];
        stock[f][c]--;
        ventas[f][c]++;

        return precio;
    }

    static void rellenarGolosina(String[][] golosinas, int[][] stock){      
        String pass = "MaquinaExpendedora2017";
        if (!pedirContrasena(pass)) {
            System.out.println("Contraseña incorrecta.");
            return;
        }

        while (true) {
            System.out.println("Código del producto a rellenar:");
            int[] filaYcolumna = pedirCodigoProducto(stock);
            int cantidad = 0;
            int f = filaYcolumna[0]; int c = filaYcolumna[1];

            System.out.println("Has seleccionado el producto: " + golosinas[f][c]);
            System.out.println("¿Cuántas unidades quieres añadir?");
            cantidad = pedirCantidad();

            stock[f][c] += cantidad;
            System.out.printf("'%s' ha pasado de tener %d a %d unidades.",  golosinas[f][c], (stock[f][c]-cantidad), stock[f][c]);

            System.out.println("¿Quieres añadir mas unidades de otro producto?");
            System.out.println("1. Si.\n2. No.");
            int seguir = pedirCantidad();

            if (seguir != 1) {
                System.out.println("Saliendo...");
                break;
            }
        }
    }
    
    static void ventasTotales(int[][] ventas, String[][] golosinas, double totalVentas){
        System.out.println("Golosinas vendidas:");
        
        for (int i = 0; i < golosinas.length; i++) {
            for (int j = 0; j < golosinas.length; j++) {
                if(ventas[i][j] != 0) System.out.println(ventas[i][j] + " " + golosinas[i][j]);
            }
        }
        System.out.println("VENTAS TOTALES: " + totalVentas);
    }
    /* M E T O D O S  D E  C O N V E R S I O N */
    static double[] arrToDouble(String[] strArr){
        double[] arr = new double[strArr.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Double.parseDouble(strArr[i]);
        }

        return arr;
    }
    static int[] arrToInt(String[] strArr){
        int[] arr = new int[strArr.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        return arr;
    }
    static void mostrarMenu(){
        System.out.println("""
            *******************************
            *    1. Pedir golosina.       *
            *   2. Mostrar golosinas.     *
            *   3. Rellenar golosinas.    *
            *   4. Apagar máquina.        *
            *******************************
            """
            );
    }
    static boolean pedirContrasena(String contrasena){
        Scanner sc = new Scanner(System.in);
        System.out.println("Contraseña:");
        String userPass = sc.nextLine();

        if (contrasena.equals(userPass)) return true;
        else return false;
    }
    static int[] pedirCodigoProducto(int[][] stock){
        
        Scanner sc;
        String codStr;
        int[] filaYcolumna = new int[2];
        int f, c;

        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Introduce el código del producto:");
                codStr = sc.nextLine();

                if (codStr.length() != 2) {
                    System.out.println("Error en el código introducido, inténtelo de nuevo.");
                } else {
                    filaYcolumna = arrToInt(codStr.split(""));
                    f = filaYcolumna[0]; c = filaYcolumna[1];

                    stock[f][c] = stock[f][c];

                    break;
                }
        
        }catch (Exception e){
            System.out.println("Ha ocurrido un error.");
        }
            
        }while (true);
        return filaYcolumna;
    }
    static int pedirCantidad(){
        do {
            try {
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                return n;
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error, intentalo de nuevo.");
            }
        } while (true);

    }

}


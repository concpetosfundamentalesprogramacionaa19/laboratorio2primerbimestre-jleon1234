package reporte;

import java.util.Scanner;

/**
 *
 * @author Juan Pablo
 */
public class Reporte {

    public static void main(String[] args) {
        //añadimso el objeto Scanner para pedir datos
        Scanner entrada = new Scanner(System.in);
        
        //declaramos las variables
        String nombre;
        double sueldo = 0;
        int hijos_total = 0;
        double pasajes = 0;
        double bar = 0;
        double salidas = 0;
        String mensaje = "";
        int contador = 1;
        int contador2 = 1;
        boolean bandera = true;
        String opcion = "";
        double totalpasajes = 0;
        double totalbar = 0;
        double totalsalidas = 0;
        double etotal = 0;
        
        //inicializamos la variable mensaje con el titulo
        mensaje = String.format("%s%s\n\n", mensaje,
                "Reporte Gastos de los Padres de Familia");
        //primer ciclo repetitivo para ingresar los nombres de los padras 
        
        while (bandera == true) {
            
            // Pedimos los datos al usuario y los añadimos en las variables
            System.out.print("Ingrese sus nombres y apellidos: ");
            nombre = entrada.nextLine();
            System.out.print("Ingrese su sueldo semanal: ");
            sueldo = entrada.nextDouble();
            System.out.print("Ingrese el numero de hijos: ");
            hijos_total = entrada.nextInt();
            //Imprimir primera cadena
            mensaje = String.format("%sReporte%d: \n", mensaje, contador);
            contador = contador + 1;
            mensaje = String.format("%sNombre del Padre de Familia :  "
                    + "%s\nSueldo semanal : %.2f\nNúmero de Hijos: "
                    + "%d\n\nReporte de"
                    + " Gastos\nPersona      Pasaje      Bar      Salidas\n",
                     mensaje, nombre, sueldo, hijos_total);
            //En este ciclo se ejecutara segun la cantidad de hijos que tenga
            while (contador2 <= hijos_total) {
                // Pedimos la informacion de los gastos de los hijos
                System.out.printf("Hijo %d\n", contador2);
                System.out.print("Ingrese el dinero destinado a los pasajes de su hijo: ");
                pasajes = entrada.nextDouble();
                System.out.print("Ingrese el dinero destinado al bar su hijo: ");
                bar = entrada.nextDouble();
                System.out.print("Ingrese el dinero destinado para las salidas de su "
                        + "hijo: ");
                salidas = entrada.nextDouble();
                mensaje = String.format("%sHijo %d      %.2f         %.2f     "
                        + "     %.2f\n",
                        mensaje, contador2, pasajes, bar, salidas);
                contador2 = contador2 + 1;

                //Se suman los totales
                totalpasajes = totalpasajes + pasajes;
                totalbar = totalbar + bar;
                totalsalidas = totalsalidas + salidas;
                etotal = totalpasajes + totalbar + totalsalidas;
            }
            mensaje = String.format("%s Total       %.2f         %.2f        "
                    + "  %.2f\n", mensaje, totalpasajes, totalbar, totalsalidas);

            //Resultado
            if (etotal < sueldo) {
                mensaje = String.format("%s\nEl padre de familia %s le alcanza el dinero"
                        + " semanal,para sus gastos.\n ", mensaje, nombre);
            } else {
                mensaje = String.format("%s\nEl padre de familia %s le falta el dinero "
                        + "semanal,para sus gastos.\n ", mensaje, nombre);
            }
            entrada.nextLine();

            /**/
            System.out.println("Ingrese 's' para realizar otro reporte o 'n'"
                    + " para presentar los reportes");
            opcion = entrada.nextLine();
            if (opcion.equalsIgnoreCase("s")) {
                bandera = true;
                contador2 = 1;
            } else {
                bandera = false;
            }
            mensaje = String.format("%s\n Reporte Finalizado %d", mensaje, contador - 1);
        }
        
        /*
            Imprimimos en pantalla los resultados
        */   
        System.out.printf("%s", mensaje);

    }

}

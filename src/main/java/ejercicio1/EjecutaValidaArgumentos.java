package ejercicio1;

import org.iesalandalus.programacion.utilidades.Entrada;
import java.io.File;
import java.io.IOException;

public class EjecutaValidaArgumentos {

    public static void main(String[] args) {
        System.out.print("Introduce un argumento (deja vacío para no enviar nada): ");
        String argumento = Entrada.cadena();

        ProcessBuilder pb;

        // Instanciamos el ProcessBuilder con o sin parámetros
        if (argumento.equals("")) {
            pb = new ProcessBuilder("java", "ejercicio1.ValidaArgumentos");
        } else {
            pb = new ProcessBuilder("java", "ejercicio1.ValidaArgumentos", argumento);
        }


        pb.directory(new File("build/classes/java/main"));

        try {
            Process proceso = pb.start();
            int codigoSalida = proceso.waitFor();

            System.out.println("Valor de salida: " + codigoSalida);

            if (codigoSalida == 1) {
                System.out.println("No hay argumentos");
            } else if (codigoSalida == 2) {
                System.out.println("El argumento es una cadena");
            } else if (codigoSalida == 3) {
                System.out.println("El número es menor que 0");
            } else if (codigoSalida == 4) {
                System.out.println("El número es mayor o igual que 0");
            }

        } catch (IOException e) {
            System.out.println("No se pudo iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("El proceso hijo fue interrumpido");
        }
    }
}
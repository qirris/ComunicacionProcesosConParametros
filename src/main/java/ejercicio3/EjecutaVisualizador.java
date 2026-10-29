package ejercicio3;

import org.iesalandalus.programacion.utilidades.Entrada;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjecutaVisualizador {

    public static void main(String[] args) {
        System.out.print("Introduce una cadena: ");
        String cadena = Entrada.cadena();

        // En el ProcessBuilder, si la cadena está vacía, no se la pasamos
        ProcessBuilder pb;
        if (cadena.equals("")) {
            pb = new ProcessBuilder("java", "ejercicio3.Visualizador");
        } else {
            pb = new ProcessBuilder("java", "ejercicio3.Visualizador", cadena, "5");
        }

        pb.directory(new File("build/classes/java/main"));

        try {
            Process hijo = pb.start();

            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(hijo.getInputStream()));

            String linea;

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

            lector.close();

            int codigoSalida = hijo.waitFor();

            System.out.println("Valor de salida: " + codigoSalida);

            if (codigoSalida == 0) {
                System.out.println("Final correcto.");
            } else {
                System.out.println("Final incorrecto.");
            }

        } catch (IOException e) {
            System.out.println(
                    "No se pudo iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("El proceso hijo fue interrumpido.");
        }
    }
}
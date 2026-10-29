package ejercicio2;

import org.iesalandalus.programacion.utilidades.Entrada;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LectorTxt {

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder(
                "java", "ejercicio2.TransformadorTxt");

        pb.directory(new File("build/classes/java/main"));

        try {
            Process hijo = pb.start();

            BufferedWriter escritor = new BufferedWriter(
                    new OutputStreamWriter(hijo.getOutputStream()));

            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(hijo.getInputStream()));

            System.out.println("Introduce palabras para transformar (escribe 'fin' para salir):");
            String linea = Entrada.cadena();

            while (linea != null && !linea.equals("fin")) {
                escritor.write(linea);
                escritor.newLine();

                System.out.println(lector.readLine());

                linea = Entrada.cadena();
            }

            escritor.close();
            lector.close();
            hijo.waitFor();

        } catch (IOException e) {
            System.out.println(
                    "Error de comunicación con el proceso hijo: "
                            + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("El proceso hijo fue interrumpido.");
        }
    }
}
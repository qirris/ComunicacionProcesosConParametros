package ejercicio4;

import org.iesalandalus.programacion.utilidades.Entrada;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GeneraAleatorios {

    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder(
                "java", "ejercicio4.Aleatorios");

        pb.directory(new File("build/classes/java/main"));

        try {
            Process hijo = pb.start();

            BufferedWriter escritor = new BufferedWriter(
                    new OutputStreamWriter(hijo.getOutputStream()));

            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(hijo.getInputStream()));

            String peticion;

            do {
                System.out.println("Escribe algo para generar un número o escribe fin para terminar: ");
                peticion = Entrada.cadena();

                if (!peticion.equals("fin")) {
                    escritor.write(peticion);
                    escritor.newLine();
                    escritor.flush();

                    System.out.println(lector.readLine());
                }

            } while (!peticion.equals("fin"));

            escritor.close();
            lector.close();

            hijo.destroy();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
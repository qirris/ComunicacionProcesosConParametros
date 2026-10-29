package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransformadorTxt {

    public static void main(String[] args) {
        BufferedReader lector = new BufferedReader(
                new InputStreamReader(System.in));

        try {
            String linea;

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea.toUpperCase());
                System.out.flush();
            }

            lector.close();

        } catch (IOException e) {
            System.err.println(
                    "Error al leer la entrada: " + e.getMessage());
            System.exit(1);
        }
    }
}
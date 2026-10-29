package ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aleatorios {

    public static void main(String[] args) {
        BufferedReader lector = new BufferedReader(
                new InputStreamReader(System.in));

        try {
            String peticion;

            while ((peticion = lector.readLine()) != null) {
                int numero = (int) (Math.random() * 11);

                System.out.println(numero);
                System.out.flush();
            }

            lector.close();

        } catch (IOException e) {
            System.err.println("Error al leer la entrada: " + e.getMessage());
        }
    }
}
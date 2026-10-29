package ejercicio3;

public class Visualizador {

    public static void main(String[] args) {
        if (args.length < 2 || args[0].equals("")) {
            System.out.println("Cadena introducida vacía.");
            System.exit(1);
        }

        String cadena = args[0];
        int veces = Integer.parseInt(args[1]);

        for (int i = 1; i <= veces; i++) {
            System.out.println(i + ". " + cadena);
        }
    }
}
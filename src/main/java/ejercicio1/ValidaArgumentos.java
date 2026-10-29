package ejercicio1;

public class ValidaArgumentos {

    public static void main(String[] args) {
        int codigoSalida;

        if (args.length == 0) {
            codigoSalida = 1;
        } else {
            try {
                int numero = Integer.parseInt(args[0]);

                if (numero <= 0) {
                    codigoSalida = 3;
                } else {
                    codigoSalida = 4;
                }

            } catch (NumberFormatException e) {
                codigoSalida = 2;
            }
        }

        System.exit(codigoSalida);
    }
}
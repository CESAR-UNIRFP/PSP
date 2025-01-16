import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloEscuchadorParesNones implements Runnable {
    private Thread hilo;
    private static int numCliente = 0;
    private Socket enchufeAlCliente;

    public HiloEscuchadorParesNones(Socket cliente) {
        numCliente++;
        hilo = new Thread(this, "Cliente" + numCliente);
        this.enchufeAlCliente = cliente;
        hilo.start();
    }

    @Override
    public void run() {
        try (
                BufferedReader entrada = new BufferedReader(new InputStreamReader(enchufeAlCliente.getInputStream()));
                PrintWriter escritor = new PrintWriter(enchufeAlCliente.getOutputStream(), true)
        ) {
            escritor.println("Bienvenido al juego de Pares o Nones!");

            while (true) {
                escritor.println("Elige 'pares' o 'nones':");
                String eleccion = entrada.readLine();

                if (eleccion == null) {
                    break; // Si la entrada es nula, el cliente cerró la conexión
                }

                eleccion = eleccion.trim().toLowerCase();
                if (!eleccion.equals("pares") && !eleccion.equals("nones")) {
                    escritor.println("Opción no válida. Por favor, escribe 'pares' o 'nones'.");
                    continue;
                }

                int numeroCliente = (int) (Math.random() * 10);
                int numeroServidor = (int) (Math.random() * 10);
                int suma = numeroCliente + numeroServidor;

                escritor.println("Tu número es: " + numeroCliente);
                escritor.println("El número del servidor es: " + numeroServidor);
                escritor.println("La suma es: " + suma);

                boolean esPar = suma % 2 == 0;
                if ((esPar && eleccion.equals("pares")) || (!esPar && eleccion.equals("nones"))) {
                    escritor.println("¡Ganaste!");
                } else {
                    escritor.println("¡Perdiste!");
                }

                escritor.println("¿Quieres jugar otra partida? (sí/no):");
                String continuar = entrada.readLine();

                if (continuar == null || continuar.trim().equalsIgnoreCase("no")) {
                    escritor.println("Gracias por jugar. ¡Hasta pronto!");
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error en la comunicación con el cliente: " + e.getMessage());
        } finally {
            try {
                enchufeAlCliente.close();
                System.out.println(hilo.getName() + " ha cerrado la conexión.");
            } catch (IOException e) {
                System.out.println("Error al cerrar el socket: " + e.getMessage());
            }
        }
    }
}



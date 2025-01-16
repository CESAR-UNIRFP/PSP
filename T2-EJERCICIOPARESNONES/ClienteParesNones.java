import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClienteParesNones {
    public static void main(String[] args) {
        System.out.println("CLIENTE DE PARES O NONES");
        System.out.println("-------------------------");
        Scanner lector = new Scanner(System.in);

        try {
            Socket cliente = new Socket();
            InetSocketAddress direccionServidor = new InetSocketAddress("192.168.1.69", 2001);
            cliente.connect(direccionServidor);
            System.out.println("Conectado al servidor.");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true);

            String texto;
            while ((texto = entrada.readLine()) != null) { // Lee mensajes del servidor
                System.out.println("Servidor: " + texto);

                // Si el mensaje termina con ":", se espera una respuesta del cliente
                if (texto.endsWith(":")) {
                    String respuesta = lector.nextLine();
                    escritor.println(respuesta);
                }

                // Si el servidor envía "¡Hasta pronto!" salimos
                if (texto.contains("¡Hasta pronto!")) {
                    break;
                }
            }

            cliente.close();
            System.out.println("Conexión cerrada.");
        } catch (IOException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}



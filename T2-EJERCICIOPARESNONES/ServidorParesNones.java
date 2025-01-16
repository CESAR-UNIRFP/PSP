import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorParesNones {
    public static void main(String[] args) {
        System.out.println("SERVIDOR DE PARES O NONES");
        System.out.println("--------------------------");
        try {
            ServerSocket servidor = new ServerSocket();
            InetSocketAddress direccionServidor = new InetSocketAddress("192.168.1.69", 2001);
            servidor.bind(direccionServidor);
            System.out.println("Servidor listo para aceptar solicitudes");

            while (true) {
                Socket enchufeAlCliente = servidor.accept();
                System.out.println("Nuevo cliente conectado");
                new HiloEscuchadorParesNones(enchufeAlCliente); // Crear un nuevo hilo para el cliente
            }
        } catch (IOException e) {
            System.out.println("Error del servidor: " + e.getMessage());
        }
    }
}

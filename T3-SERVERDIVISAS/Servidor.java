import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
public class Servidor {
    public static void main(String[] args) {
        System.out.println("APLICACIÓN DE SERVIDOR MULTITAREA");
        System.out.println("----------------------------------");
        try {
            ServerSocket servidor = new ServerSocket();
            InetSocketAddress direccion = new InetSocketAddress("192.168.1.104",2222);
            servidor.bind(direccion);
            System.out.println("Servidor listo para aceptar solicitudes");
            System.out.println("Dirección IP: " + direccion.getAddress());
            while (true) {
                System.out.println("Esperando conexiones entrantes...");
                Socket enchufeAlCliente = servidor.accept();
                System.out.println("Conexión aceptada de " + enchufeAlCliente.getInetAddress());
                System.out.println("Comunicación entrante");
                new HiloEscuchador(enchufeAlCliente);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

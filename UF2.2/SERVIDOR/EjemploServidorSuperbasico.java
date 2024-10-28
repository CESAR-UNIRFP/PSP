import java.net.ServerSocket;
import java.net.Socket;
public class EjemploServidorSuperbasico {
    public static void main(String[] args) {
        try {
            // Crear un ServerSocket que escuche en el puerto 8080
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Servidor escuchando en el puerto 8080...");
            // Esperar a que un cliente se conecte
            Socket ClientSocket = serverSocket.accept();
            System.out.println("Cliente conectado.");
            // Cerrar la conexión con el cliente y el servidor
            ClientSocket.close();
            System.out.println("Conexión con el cliente cerrada.");
            serverSocket.close();
            System.out.println("Servidor cerrado.");
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}


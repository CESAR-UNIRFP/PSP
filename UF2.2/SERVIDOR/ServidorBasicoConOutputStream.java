import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;

public class ServidorBasicoConOutputStream {
    public static void main(String[] args) {
        try {
            // Crear un ServerSocket que escuche en el puerto 8080
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Servidor escuchando en el puerto 8080...");

            // Esperar a que un cliente se conecte
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado.");

            // Enviar un mensaje al cliente usando OutputStream
            OutputStream outputStream = clientSocket.getOutputStream();
            String mensaje = "¡Hola, cliente! Este es un mensaje desde el servidor.";
            outputStream.write(mensaje.getBytes()); // Convertir el mensaje a bytes y enviarlo
            outputStream.flush(); // Asegurar que los datos se envíen inmediatamente

            // Cerrar la conexión con el cliente y el servidor
            clientSocket.close();
            System.out.println("Conexión con el cliente cerrada.");

            serverSocket.close();
            System.out.println("Servidor cerrado.");
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}


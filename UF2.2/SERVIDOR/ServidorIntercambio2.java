import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;

public class ServidorIntercambio2 {
    public static void main(String[] args) {
        try {
            // Crear un ServerSocket que escuche en el puerto 8080
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Servidor escuchando en el puerto 8080...");

            // Esperar a que un cliente se conecte
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado.");

            // Enviar un mensaje al cliente
            OutputStream outputStream = clientSocket.getOutputStream();
            String mensajeServidor = "¡Hola, cliente! Este es un mensaje desde el servidor.";
            outputStream.write(mensajeServidor.getBytes());
            outputStream.flush(); // Asegurarse de que los datos se envíen inmediatamente
            System.out.println("Mensaje enviado al cliente.");

            // Recibir el mensaje de respuesta del cliente usando un buffer
            InputStream inputStream = clientSocket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String mensajeCliente = new String(buffer, 0, bytesRead);
            System.out.println("Mensaje del cliente: " + mensajeCliente);

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


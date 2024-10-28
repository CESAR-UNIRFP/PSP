import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;

public class ClienteIntercambio2 {
    public static void main(String[] args) {
        try {
            // Crear un socket y conectarse al servidor en 127.0.0.1:8080
            Socket socket = new Socket("127.0.0.1", 8080);
            System.out.println("Conectado al servidor en 127.0.0.1:8080");

            // Leer el mensaje del servidor usando un buffer
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String mensajeServidor = new String(buffer, 0, bytesRead);
            System.out.println("Mensaje del servidor: " + mensajeServidor);

            // Enviar un mensaje de respuesta al servidor
            OutputStream outputStream = socket.getOutputStream();
            String mensajeCliente = "¡Hola, servidor! Este es un mensaje desde el cliente.";
            outputStream.write(mensajeCliente.getBytes());
            outputStream.flush();
            System.out.println("Mensaje enviado al servidor.");

            // Cerrar el socket
            socket.close();
            System.out.println("Conexión cerrada.");
        } catch (Exception e) {
            System.out.println("No se pudo conectar al servidor: " + e.getMessage());
        }
    }
}


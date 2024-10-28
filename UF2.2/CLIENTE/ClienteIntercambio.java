import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;

public class ClienteIntercambio {
    public static void main(String[] args) {
        try {
            // Crear un socket y conectarse al servidor en 127.0.0.1:8080
            Socket socket = new Socket("127.0.0.1", 8080);
            System.out.println("Conectado al servidor en 127.0.0.1:8080");

            // Leer el mensaje del servidor usando readAllBytes
            InputStream inputStream = socket.getInputStream();
            byte[] datosServidor = inputStream.readAllBytes(); // Leer todos los bytes disponibles
            String mensajeServidor = new String(datosServidor); // Convertir los bytes a String
            System.out.println("Mensaje del servidor: " + mensajeServidor);

            // Enviar un mensaje de respuesta al servidor
            OutputStream outputStream = socket.getOutputStream();
            String mensajeCliente = "¡Hola, servidor! Este es un mensaje desde el cliente.";
            outputStream.write(mensajeCliente.getBytes()); // Enviar el mensaje en bytes
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

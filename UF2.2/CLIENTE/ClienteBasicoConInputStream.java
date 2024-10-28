import java.net.Socket;
import java.io.InputStream;

public class ClienteBasicoConInputStream
{
        public static void main(String[] args)
        {
            try
            {
                // Crear un socket y conectarse al servidor en 127.0.0.1:8080
                Socket socket = new Socket("127.0.0.1", 8080);
                System.out.println("Conectado al servidor en 127.0.0.1:8080");

                // Leer el mensaje completo del servidor
                InputStream inputStream = socket.getInputStream();

                byte[] datos = inputStream.readAllBytes(); // Leer todos los bytes disponibles
                String mensaje = new String(datos); // Convertir los bytes a String
                System.out.println("Mensaje del servidor: " + mensaje);

                // Cerrar el socket
                socket.close();
                System.out.println("Conexión cerrada.");
            } catch (Exception e) {
                System.out.println("No se pudo conectar al servidor: " + e.getMessage());
            }
        }
}



import java.net.Socket;
public class EjemploClienteSocketBasico
{
    public static void main(String[] args)
    {
        try
        {
            // Crear un socket y conectarse al servidor en 127.0.0.1:8080
            Socket socket = new Socket("192.68.10.128", 8080);
            System.out.println("Conectado al servidor en 127.0.0.1:8080");

            // Cerrar el socket
            socket.close();
            System.out.println("Conexión cerrada.");
        } catch (Exception e)
        {
            System.out.println("No se pudo conectar al servidor: " + e.getMessage());
        }
    }
}


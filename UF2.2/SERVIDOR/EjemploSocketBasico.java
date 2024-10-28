import java.net.Socket;
public class EjemploSocketBasico
{
    public static void main(String[] args)
    {
        try
        {
            // Crear un socket y conectarse a la dirección 127.0.0.1 (localhost) en el puerto 8080
            Socket socket = new Socket("127.0.0.1", 8080);
            System.out.println("Socket creado y conectado a 127.0.0.1 en el puerto 8080");
            // Cerrar el socket
            socket.close();
            System.out.println("Socket cerrado.");
        }
        catch (Exception e)
        {
            System.out.println("Error al crear o conectar el socket: " + e.getMessage());
        }
    }
}



import java.io.*;
import java.net.*;

public class EjServidor {
    public static void main(String[] args) {
        try {
            // Crear un ServerSocket en el puerto 8080
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Esperando conexión de clientes...");

            // Aceptar una conexión de un cliente
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado!");

            // Crear flujos para recibir y enviar datos
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Leer el mensaje del cliente
            String mensajeCliente = reader.readLine();
            System.out.println("Mensaje del cliente: " + mensajeCliente);

            // Responder al cliente
            writer.println("Hola, cliente!");

            // Cerrar el socket
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


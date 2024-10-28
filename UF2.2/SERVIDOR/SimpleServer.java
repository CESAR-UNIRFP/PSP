import java.io.*;
import java.net.*;
public class SimpleServer {
    public static void main(String[] args) {
        try {
            // Crea el ServerSocket en el puerto 8080
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Servidor iniciado, esperando conexión...");
            // Acepta la conexión de un cliente
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado desde: " + clientSocket.getInetAddress());
            // Flujo para leer datos del cliente
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            // Comunicación sencilla con el cliente
            String clientMessage = input.readLine();
            System.out.println("Mensaje del cliente: " + clientMessage);
            output.println("Hola cliente, el servidor ha recibido tu mensaje.");
            // Cierra el socket del cliente y el servidor
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

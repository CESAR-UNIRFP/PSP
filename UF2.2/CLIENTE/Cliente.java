import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            // Conectar al servidor en localhost y puerto 8080
            Socket clientSocket = new Socket("localhost", 8080);

            // Crear flujos para enviar y recibir datos
            OutputStream output = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Enviar un mensaje al servidor
            writer.println("Hola, servidor!");

            // Leer la respuesta del servidor
            String respuesta = reader.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);

            // Cerrar el socket
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


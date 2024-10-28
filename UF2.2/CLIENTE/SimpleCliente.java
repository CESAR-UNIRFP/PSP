import java.io.*;
import java.net.*;
public class SimpleCliente {
    public static void main(String[] args) {
        try {
            // Conecta al servidor en localhost y puerto 8080
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Conectado al servidor.");
            // Crear un PrintWriter para enviar datos al servidor
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            // Crear un BufferedReader para recibir la respuesta del servidor
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Enviar un mensaje al servidor
            output.println("Hola, servidor!");
            // Leer la respuesta del servidor
            String serverResponse = input.readLine();
            System.out.println("Respuesta del servidor: " + serverResponse);
            // Cerrar los recursos
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

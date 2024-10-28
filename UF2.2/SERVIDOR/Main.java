import java.net.InetSocketAddress;
public class Main
{
    public static void main(String[] args)
    {
        // Creando una InetSocketAddress con un hostname y puerto
        InetSocketAddress socketAddress1 = new InetSocketAddress("localhost", 8080);
        // Creando una InetSocketAddress con una dirección IP y puerto
        InetSocketAddress socketAddress2 = new InetSocketAddress("192.168.10.128", 8080);
        // Creando una InetSocketAddress con una dirección invertida y puerto
        InetSocketAddress socketAddress3 = new InetSocketAddress( 8080);
        System.out.println("Hostname: " + socketAddress1.getHostName());
        System.out.println("IP: " + socketAddress1.getAddress());
        System.out.println("Puerto: " + socketAddress1.getPort());
        System.out.println("Hostname2: " + socketAddress2.getHostName());
        System.out.println("IP2: " + socketAddress2.getAddress());
        System.out.println("Puerto2: " + socketAddress2.getPort());
        System.out.println("Hostname2: " + socketAddress3.getHostName());
        System.out.println("IP2: " + socketAddress3.getAddress());
        System.out.println("Puerto2: " + socketAddress3.getPort());
    }
}

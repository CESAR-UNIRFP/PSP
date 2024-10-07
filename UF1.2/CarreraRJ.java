public class CarreraRJ
{
    public static void main(String[] args) throws InterruptedException
    {
        CorredorRJ c1 = new CorredorRJ("Corredor1",Thread.MIN_PRIORITY);
        c1.getHilo().join();
        new CorredorRJ("Corredor2",Thread.MIN_PRIORITY);
        new CorredorRJ("Corredor3",Thread.MAX_PRIORITY);
    }
}

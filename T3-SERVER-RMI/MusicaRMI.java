import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
public class MusicaRMI extends UnicastRemoteObject implements MusicaInterfaceRMI
{
    private static final long serialVersionUID = -4817856459999901795L;
    private ArrayList<Cancion> canciones;
    public MusicaRMI() throws RemoteException {
        canciones = new ArrayList<Cancion>();
        canciones.add(new Cancion("Bohemian Rhapsody", "Queen", "A Night at the Opera", 1975));
        canciones.add(new Cancion("You're My Best Friend", "Queen", "A Night at the Opera", 1975));
        canciones.add(new Cancion("Sweet Lady", "Queen", "A Night at the Opera", 1975));
        canciones.add(new Cancion("Karma Police", "Radiohead", "OK Computer", 1997));
        canciones.add(new Cancion("Meeting In The Aisle", "Radiohead", "OK Computer", 1997));
        canciones.add(new Cancion("Bloom", "Radiohead", "The King of Limbs", 2011));
        canciones.add(new Cancion("Little by Little", "Radiohead", "The King of Limbs", 2011));
        canciones.add(new Cancion("Give Up the Ghost", "Radiohead", "The King of Limbs", 2011));
        canciones.add(new Cancion("Every Breaking Wave", "U2", "Songs of Innocence", 2014));canciones.add(new Cancion("Raised by Wolves", "U2", "Songs of Innocence", 2014));
        canciones.add(new Cancion("The Troubles", "U2", "Songs of Innocence", 2014));
        canciones.add(new Cancion("The Refugee", "U2", "War", 1983));
        canciones.add(new Cancion("Red Light", "U2", "War", 1983));
        canciones.add(new Cancion("Sunday Bloody Sunday", "U2", "War", 1983));
    }
    @Override
    public String buscarTitulo(String titulo) throws RemoteException {
        String resultado = "";
        for (Cancion c : canciones) {
            if (c.getTitulo().contains(titulo)) {
                resultado = resultado + c + "\n";
            }
        }
        return resultado;
    }
    @Override
    public String buscarBanda(String banda) throws RemoteException {
        String resultado = "";
        for (Cancion c : canciones) {
            if (c.getBanda().contains(banda)) {
                resultado = resultado + c + "\n";
            }
        }
        return resultado;
    }
    @Override
    public String buscarAlbum(String album) throws RemoteException {
        String resultado = "";
        for (Cancion c : canciones) {
            if (c.getAlbum().contains(album)) {
                resultado = resultado + c + "\n";
            }
        }
        return resultado;
    }
    @Override
    public String buscarProducido(int a) throws RemoteException {
        String resultado = "";
        for (Cancion c : canciones) {
            if (c.getProducido() == a) {
                resultado = resultado + c + "\n";
            }
        }
        return resultado;
    }
}
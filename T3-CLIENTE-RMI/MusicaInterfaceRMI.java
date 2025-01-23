import java.rmi.Remote;
import java.rmi.RemoteException;
public interface MusicaInterfaceRMI extends Remote {
    public String buscarTitulo(String titulo) throws RemoteException;
    public String buscarBanda(String banda) throws RemoteException;
    public String buscarAlbum(String album) throws RemoteException;
    public String buscarProducido(int a) throws RemoteException;
}

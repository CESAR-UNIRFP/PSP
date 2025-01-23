public class Cancion {
    private String titulo;
    private String banda;
    private String album;
    private int producido;
    public Cancion(String titulo, String banda, String album, int producido) {
        this.titulo = titulo;
        this.banda = banda;
        this.album = album;
        this.producido = producido;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getBanda() {
        return banda;
    }
    public String getAlbum() {
        return album;
    }
    public int getProducido() {
        return producido;
    }
    @Override
    public String toString() {
        return titulo + " (" + banda + ") Álbum=" + album + " - " + producido;
    }
}

public class FakeRegistroEnArchivo implements GestorDeRegistro {

    private String datos;

    @Override
    public void registrar(String datos) {
        this.datos = datos;
    }

    public String datos() {
        return datos;
    }
}

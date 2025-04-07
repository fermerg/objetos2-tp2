import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        RegistroEnArchivo registro = new RegistroEnArchivo("C:\\Users\\fm\\Desktop\\restaurante.txt");
        ProveedorFecha fecha = () -> LocalDateTime.now();
        Mesa mesa = new Mesa(registro, fecha);
        TarjetaCredito visa = new TarjetaVisa("visa", 3);
        TarjetaCredito master = new TarjetaMastercard("master", 2);
        TarjetaCredito comarca = new TarjetaComarca("comarca", 2);
        TarjetaCredito otra = new TarjetaOtra("otra", 0);
        Menu raviol = new Menu("raviol", 1030);
        Menu carne = new Menu("carne", 1220);
        Menu vino = new Menu("vino", 300);

        mesa.agregarPlato(carne);
        mesa.agregarPlato(raviol);
        mesa.agregarBebida(vino);
        float total = mesa.costoTotal(visa, 5);
    }
}

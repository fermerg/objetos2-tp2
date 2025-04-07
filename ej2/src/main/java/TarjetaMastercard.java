public class TarjetaMastercard extends TarjetaCredito {
    public TarjetaMastercard(String nombre, int descuento) {
        super(nombre, descuento);
    }

    @Override
    public float aplicarDescuento(float montoPlatos, float montoBebidas) {
        return montoPlatos * descuento / 100;
    }
}

//Los pagos con tarjeta de crédito Mastercard tienen un 2% de descuento sobre
////el costo total de los platos principales.
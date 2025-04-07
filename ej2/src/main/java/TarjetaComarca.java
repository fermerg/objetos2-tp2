public class TarjetaComarca extends TarjetaCredito {
    public TarjetaComarca(String nombre, int descuento) {
        super(nombre, descuento);
    }

    @Override
    public float aplicarDescuento(float montoPlatos, float montoBebidas) {
        return (montoPlatos + montoBebidas) * descuento / 100;
    }
}

//Los pagos con tarjeta de crédito Comarca Plus tienen un
////descuento del 2% sobre el costo total (bebidas + platos principales).
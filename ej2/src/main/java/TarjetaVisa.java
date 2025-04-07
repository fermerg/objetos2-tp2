public class TarjetaVisa extends TarjetaCredito {
    public TarjetaVisa(String nombre, float descuento) {
        super(nombre, descuento);
    }

    @Override
    public float aplicarDescuento(float montoPlatos, float montoBebidas) {
        float des = montoBebidas * descuento / 100;
        return des;
    }
}

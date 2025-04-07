public abstract class TarjetaCredito {
    protected String nombre;

    protected float descuento;

    public TarjetaCredito(String nombre, float descuento) {
        this.nombre = nombre;
        this.descuento = descuento;
    }

    public float aplicarDescuento(float montoPlatos, float montoBebidas) {
        return 0;
    }
}

//Los pagos con tarjeta de crédito Visa tienen un descuento del 3% sobre el costo
//total de las bebidas. Los pagos con tarjeta de crédito Mastercard tienen un 2% de descuento sobre
//el costo total de los platos principales. Los pagos con tarjeta de crédito Comarca Plus tienen un
//descuento del 2% sobre el costo total (bebidas + platos principales). Cualquier otro tipo de tarjeta
//no posee descuento. Además del costo de la comida, es obligatorio dejar propina, que puede ser:
//2%, 3% o 5% del costo total.
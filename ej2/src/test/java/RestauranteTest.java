import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class RestauranteTest {
    Mesa mesa;
    TarjetaCredito visa;
    TarjetaCredito master;
    TarjetaCredito comarca;
    TarjetaCredito otra;
    Menu raviol;
    Menu carne;
    Menu vino;
    FakeRegistroEnArchivo registro;
    FakeProveedorFecha fecha;


    @BeforeEach
    void inicializar() {
        registro = new FakeRegistroEnArchivo();
        fecha = new FakeProveedorFecha();
        mesa = new Mesa(registro, fecha);
        visa = new TarjetaVisa("visa", 3);
        master = new TarjetaMastercard("master", 2);
        comarca = new TarjetaComarca("comarca", 2);
        otra = new TarjetaOtra("otra", 0);
        raviol = new Menu("raviol", 1030);
        carne = new Menu("carne", 1220);
        vino = new Menu("vino", 300);
    }

    @Test
    void testTarjetaVisa() {
        mesa.agregarPlato(carne);
        mesa.agregarPlato(raviol);
        mesa.agregarBebida(vino);
        float total = mesa.costoTotal(visa, 5);
        assertEquals(2546.0, total, 0.1);
        assertEquals("2025-03-25T03:39 " + 2546.0, registro.datos());
    }
}

//1. Cálculo de costo con tarjeta Visa.
//2. Cálculo de costo con tarjeta Mastercard.
//3. Cálculo de costo con tarjeta Comarca Plus

//Los pagos con tarjeta de crédito Visa tienen un descuento del 3% sobre el costo total de las bebidas.
// Los pagos con tarjeta de crédito Mastercard tienen un 2% de descuento sobre el costo total de los platos principales.
// Los pagos con tarjeta de crédito Comarca Plus tienen un descuento del 2% sobre el costo total (bebidas + platos principales).
// Cualquier otro tipo de tarjeta no posee descuento. Además del costo de la comida, es obligatorio dejar propina, que puede ser:
//2%, 3% o 5% del costo total.
import java.util.ArrayList;
import java.util.List;

public class Mesa {
    List<Menu> bebidas;
    List<Menu> platos;
    GestorDeRegistro registro;
    ProveedorFecha fecha;

    public Mesa(GestorDeRegistro registro, ProveedorFecha fecha) {
        this.bebidas = new ArrayList<>();
        this.platos = new ArrayList<>();
        this.registro = registro;
        this.fecha = fecha;
    }

    public void agregarPlato(Menu plato) {
        this.platos.add(plato);
    }

    public void agregarBebida(Menu bebida) {
        this.bebidas.add(bebida);
    }

    public float costoPlatos() {
        float total = 0;
        for (Menu p : platos) {
            total += p.getPrecio();
        }
        return total;
    }

    public float costoBebidas() {
        float total = 0;
        for (Menu b : bebidas) {
            total += b.getPrecio();
        }
        return total;
    }

    public float costoPlatosBebidas() {
        float total;
        total = costoPlatos() + costoBebidas();
        return total;
    }

    public float costoTotal(TarjetaCredito tarjeta, float propina) {
        float total = (costoPlatosBebidas()) - (tarjeta.aplicarDescuento(costoPlatos(), costoBebidas())) + propina;
        this.registro.registrar(this.fecha.fecha() + " " + total);
        return total;
    }
}


//se solicita que cada vez que se calcule el costo de una
//cena o almuerzo se almacene en un archivo de texto la fecha/hora y el monto total. De la siguiente
//forma:
//dd/mm/yyyy || 1100
//dd/mm/yyyy || 590
//dd/mm/yyyy || 2314.3
//dd/mm/yyyy || 1100
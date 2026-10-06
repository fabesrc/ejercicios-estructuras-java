import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Carrito<T extends Vendible> implements Iterable<T> {
    private final List<T> productos;
    private final String nombre;


    public Carrito (String nombre){
        this.nombre = nombre;
        productos = new ArrayList<>();
    }



    // AGREGAR PRODUCTOS

    public boolean agregar(T producto) {
        return productos.add(producto);
    }

    // CALCULAR PRECIO MAYOR


    public T precioMayor(){
        if(productos.isEmpty()){
            return null;
        }
        T productoMayor = productos.getFirst();

        for(T producto : productos){
            if(producto.getPrecio() > productoMayor.getPrecio()){
                productoMayor = producto;
            }
        }
        return productoMayor;
    }


    // PRECIO TOTAL

    public double calcularPrecioTotal(){
        double precioTotal = 0;
        for(T producto : productos){
            precioTotal += producto.getPrecio();
        }
        return precioTotal;
    }


    public boolean eliminar(T producto) {
        if(productos.isEmpty()){
            return false;
        }
        productos.remove(producto);
        return true;
    }

    @Override
    public CarritoIterator<T> iterator() {
        return new CarritoIterator(productos, 100);
    }

    public CarritoIterator<T> iteradorPrecioMin(double precioMinimo) {
        return new CarritoIterator<>(productos, precioMinimo);
    }




}

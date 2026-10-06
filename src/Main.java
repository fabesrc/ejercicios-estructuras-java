import java.util.List;

public class Main {
    public static void main(String[] args) {

        Carrito<Producto> carrito = new Carrito<>("Carrito01");

        carrito.agregar(new Producto("Teclado Mecánico", 85.50));
        carrito.agregar(new Producto("Monitor 4K", 320.00));
        carrito.agregar(new Producto("Mouse Gamer", 45.00));
        carrito.agregar(new Producto("Teclado suave", 120.00));

        System.out.println("Producto de mayor precio: " + carrito.precioMayor());
        System.out.println("Precio total de la compra: $" + carrito.calcularPrecioTotal());

        CarritoIterator<Producto> iteradorMin = carrito.iteradorPrecioMin(50.0);

        System.out.println("\nProductos con precio mayor o igual a $50.0:");
        while (iteradorMin.hasNextPrecioMin()) {
            System.out.println(iteradorMin.nextPrecioMin());
        }
    }
}
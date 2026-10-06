import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CarritoIterator<T extends Vendible> implements Iterator<T> {
    private int indice = 0;
    private List<T> lista;
    private double precioMinimo;

    public CarritoIterator(List<T> lista, double precioMinimo) {
        this.lista = lista;
        this.precioMinimo = precioMinimo;
    }


    @Override
    public boolean hasNext() {
        // Avanza el índice saltando los elementos que no cumplen el precio mínimo
        while (indice < lista.size() && lista.get(indice).getPrecio() < precioMinimo) {
            indice++;
        }
        return indice < lista.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T elemento = lista.get(indice);
        indice++; // Prepara el índice para la siguiente iteración
        return elemento;
    }

    public boolean hasNextPrecioMin(){
        while (indice < lista.size() && lista.get(indice).getPrecio() < precioMinimo) {
            indice++;
        }
        return indice < lista.size();
    }

    public T nextPrecioMin(){
        if(!hasNextPrecioMin()) {
            throw new NoSuchElementException();
        }
        T t =  lista.get(indice);
        indice++;
        return t;
    }


}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.pedidos;

/**
 *
 * @author carmen
 */
public class Pedido {
    private Producto[] productos;
    private int cantidadProductos;
    private final int MAX_PRODUCTOS = 100;

    public Pedido() {
        this.productos = new Producto[MAX_PRODUCTOS];
        this.cantidadProductos = 0;
    }

    public void agregarProducto(Producto producto) {
        if (cantidadProductos < MAX_PRODUCTOS) {
            productos[cantidadProductos] = producto;
            cantidadProductos++;
        } else {
            System.out.println("No se pueden agregar más productos al pedido.");
        }
    }

    public void mostrarPedido() {
        if (cantidadProductos != 0) {
            System.out.println("\n==========Pedido actual==========");
            for (int i = 0; i < cantidadProductos; i++) {
                System.out.println(productos[i].mostrarInfo());
            }
        } else {
            System.out.println("No hay ningún pedido");

        }
    }

    public void eliminarProducto(String nombreProducto) {
        boolean eliminado = false;

        for (int i = 0; i < cantidadProductos; i++) {
            if (productos[i].getNombre().equalsIgnoreCase(nombreProducto)) {
                for (int j = i; j < cantidadProductos - 1; j++) {
                    productos[j] = productos[j + 1];
                }
                productos[cantidadProductos - 1] = null;
                cantidadProductos--;
                eliminado = true;
                System.out.println("Producto eliminado: " + nombreProducto);
                break;
            }
        }

        if (!eliminado) {
            System.out.println("Producto no encontrado: " + nombreProducto);
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < cantidadProductos; i++) {
            total += productos[i].getPrecio();

        }
        return total;
    }
    
}

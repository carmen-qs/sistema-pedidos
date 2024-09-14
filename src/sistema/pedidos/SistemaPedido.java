
package sistema.pedidos;
import java.util.Scanner;
public class SistemaPedido {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Pedido pedido = new Pedido();
        int opcion;
        do {
            System.out.println("\n--- Carta de Presentacion ---");
            System.out.println("1. Realizar Pedido");
            System.out.println("2. Mostrar Pedido");
            System.out.println("3. Mostrar Total");
            System.out.println("4. Elimiar Pedido");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del plato: ");
                    entrada.nextLine();
                    String nombrePlato = entrada.nextLine();
                    System.out.print("Ingrese el precio del plato: ");
                    double precioPlato = entrada.nextDouble();
                    System.out.print("Ingrese la cantidad que va pedir: ");
                    int cantidadPlato = entrada.nextInt();
                    entrada.nextLine();
                    PlatoTipico plato1 = new PlatoTipico(nombrePlato, precioPlato, cantidadPlato);
                    pedido.agregarProducto(plato1);

                    System.out.print("\nDesea Pedir alguna Bebida (si/no)?: ");
                    String pedir = entrada.next();
                    if (pedir.equalsIgnoreCase("si")) {
                        System.out.print("\nIngrese el nombre de la bebida: ");
                        entrada.nextLine();
                        String nombreBebida = entrada.nextLine();
                        System.out.print("Ingrese el precio de la bebida: ");
                        double precioBebida = entrada.nextDouble();
                        System.out.print("Ingrese la cantidad que va pedir: ");
                        int cantidadBebida = entrada.nextInt();
                        entrada.nextLine();
                        Bebida bebida = new Bebida(nombreBebida, precioBebida, cantidadBebida);
                        pedido.agregarProducto(bebida);
                    }

                    break;
                case 2:

                    pedido.mostrarPedido();
                    break;
                case 3:
                    System.out.println("La cantidad a pagar es: " + pedido.calcularTotal());
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del plato a eliminar: ");
                    entrada.nextLine();
                    String nombrePlato1 = entrada.nextLine();
                    pedido.eliminarProducto(nombrePlato1);
                    break;
                case 5:
                    System.out.println("Hasta luego...°");
                    break;
                default:
                    System.out.println("Opccion no valida");
                    break;
            }
        } while (opcion != 5);
    }
}

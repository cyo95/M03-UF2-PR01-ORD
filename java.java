import java.util.ArrayList;
import java.util.Scanner;

public class Supermarket {

    public static void main(String[] args) {
        // Crear categorías de productos
        ArrayList<String> categories = new ArrayList<String>();
        categories.add("Frutas");
        categories.add("Verduras");
        categories.add("Carnes");
        categories.add("Lácteos");

        // Crear productos y agregarlos a las categorías
        ArrayList<Producto> productos = new ArrayList<Producto>();
        productos.add(new Producto("Manzanas", 1.50, "Frutas frescas"));
        productos.add(new Producto("Plátanos", 0.99, "Frutas frescas"));
        productos.add(new Producto("Zanahorias", 0.50, "Verduras frescas"));
        productos.add(new Producto("Lechuga", 1.20, "Verduras frescas"));
        productos.add(new Producto("Pollo", 4.50, "Carne fresca"));
        productos.add(new Producto("Cerdo", 3.75, "Carne fresca"));
        productos.add(new Producto("Leche", 1.00, "Leche fresca"));
        productos.add(new Producto("Yogurt", 1.25, "Yogurt natural"));

        Scanner input = new Scanner(System.in);
        int option = 0;
        ArrayList<Producto> carrito = new ArrayList<Producto>();

        while (option != 3) {
            // Mostrar menú principal
            System.out.println("=== Menú principal ===");
            System.out.println("1. Ver categorías");
            System.out.println("2. Ver carrito");
            System.out.println("3. Finalizar compra");
            System.out.print("Elija una opción: ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    // Mostrar categorías
                    System.out.println("=== Categorías ===");
                    for (int i = 0; i < categories.size(); i++) {
                        System.out.println((i+1) + ". " + categories.get(i));
                    }
                    System.out.print("Elija una categoría: ");
                    int catOption = input.nextInt();

                    // Mostrar productos en la categoría seleccionada
                    System.out.println("=== Productos de " + categories
                    
                                    .get(catOption-1) + " ===");
                ArrayList<Producto> productosCategoria = new ArrayList<Producto>();
                for (Producto p : productos) {
                    if (p.getCategoria().equals(categories.get(catOption-1))) {
                        productosCategoria.add(p);
                    }
                }
                for (int i = 0; i < productosCategoria.size(); i++) {
                    System.out.println((i+1) + ". " + productosCategoria.get(i).toString());
                }
                System.out.print("Elija un producto (0 para volver): ");
                int prodOption = input.nextInt();
                if (prodOption > 0 && prodOption <= productosCategoria.size()) {
                    Producto productoSeleccionado = productosCategoria.get(prodOption-1);
                    carrito.add(productoSeleccionado);
                    System.out.println(productoSeleccionado.getNombre() + " agregado al carrito.");
                }
                break;
            case 2:
                // Mostrar carrito
                System.out.println("=== Carrito ===");
                for (Producto p : carrito) {
                    System.out.println(p.toString());
                }
                break;
case 3:
    // Finalizar compra
    double total = 0;
    System.out.println("=== Resumen de la compra ===");
    for (Producto p : carrito) {
        System.out.println(p.getNombre() + ": $" + p.getPrecio());
        total += p.getPrecio();
    }
    System.out.println("Total: $" + total);
    break;
default:
    System.out.println("Opción inválida.");
    break;
}
}
System.out.println("¡Gracias por su compra!");
input.close();
}
}

class Producto {
private String nombre;
private double precio;
private String categoria;
private String descripcion;

public Producto(String nombre, double precio, String categoria) {
    this.nombre = nombre;
    this.precio = precio;
    this.categoria = categoria;
}

public String getNombre() {
    return nombre;
}

public double getPrecio() {
    return precio;
}

public String getCategoria() {
    return categoria;
}

public String getDescripcion() {
    return descripcion;
}

public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}

public String toString() {
    return nombre + " - $" + precio;
}
}
package edu.uca;

import picocli.CommandLine;

import java.util.Scanner;

@CommandLine.Command(name = "tienda", mixinStandardHelpOptions = true, version = "1.0",
        description = "sistema de manejo interactivo del stock de la tienda")
public class Main implements Runnable {
    private Tienda tienda = new Tienda();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new CommandLine(new Main()).execute(args);
    }

    @Override
    public void run() {
        System.out.println("Bienvendo al sistema de manejo interactivo del stock de la tienda");
        while (true) {
            System.out.println("\nElija una opción:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Salir");
            System.out.print("> ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    tienda.mostrarInventario();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida, intente nuevamente.");
            }
        }
    }

    private void agregarProducto() {
        System.out.print("\nIngrese el ID del producto: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese el nombre del producto: ");
        String name = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double price = Double.parseDouble(scanner.nextLine());

        Sizes size = null;
        while (size == null) {
            System.out.print("Ingrese el tamaño del producto (S, M, L, XL, XXL, XXXL): ");
            String input = scanner.nextLine().toUpperCase();

            try {
                size = Sizes.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Tamaño inválido. Por favor ingrese uno de los valores válidos.");
            }
        }


        Materiales material = null;
        while (material == null) {
            System.out.print("Ingrese el material del producto (ALGODON, POLYESTER, NYLON, TELA): ");
            String input = scanner.nextLine().toUpperCase();

            try {
                material = Materiales.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Material inválido. Por favor ingrese uno de los valores válidos.");
            }
        }

        Producto producto = new Ropa(id, name, price, size, material);
        this.descuentoAlgodon((Ropa)producto);
        tienda.agregarProducto(producto);
    }

    private void descuentoAlgodon(Ropa producto) {
        if((producto.getMaterial()).equals(Materiales.ALGODON)) {
            producto.setPrecio(producto.getPrecio()*0.8);
            System.out.println("Felicidades! Obtuviste un 20% de descuento.");
        }
    }
}
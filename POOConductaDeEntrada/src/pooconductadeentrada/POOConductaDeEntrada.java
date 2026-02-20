package pooconductadeentrada;

import java.util.List;
import java.util.Scanner;

public class POOConductaDeEntrada {

    private static ServiceCuenta serviceCuenta = new ServiceCuenta();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    listarCuentasAhorro();
                    break;
                case 2:
                    listarCuentasCorriente();
                    break;
                case 3:
                    crearCuentaAhorro();
                    break;
                case 4:
                    crearCuentaCorriente();
                    break;
                case 5:
                    obtenerInformacionCuenta();
                    break;
                case 6:
                    System.out.println("\n¡Gracias por usar el sistema de cuentas bancarias!");
                    break;
                default:
                    System.out.println("\nOpción inválida. Por favor, intente nuevamente.");
            }

            if (opcion != 6) {
                esperarContinuar();
            }

        } while (opcion != 6);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n");
        System.out.println("   SISTEMA DE GESTION DE CUENTAS BANCARIAS     ");

        System.out.println("  1. Listar todas las cuentas Ahorro           ");
        System.out.println("  2. Listar todas las cuentas Corriente        ");
        System.out.println(" 3. Crear cuenta de Ahorro                    ");
        System.out.println("  4. Crear cuenta Corriente                    ");
        System.out.println("  5. Obtener informacion de cuenta             ");
        System.out.println("  6. Salir                                     ");

        System.out.print("Seleccione una opcion: ");
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void listarCuentasAhorro() {
        System.out.println("\n CUENTAS DE AHORRO ");
        List<Ahorro> cuentasAhorro = serviceCuenta.listarCuentasAhorro();

        if (cuentasAhorro.isEmpty()) {
            System.out.println("No hay cuentas de ahorro registradas.");
        } else {
            for (int i = 0; i < cuentasAhorro.size(); i++) {
                System.out.println("\nCuenta #" + (i + 1) + ":");
                System.out.println(cuentasAhorro.get(i).toString());
            }
        }
    }

    private static void listarCuentasCorriente() {
        System.out.println("\n CUENTAS CORRIENTE ");
        List<Corriente> cuentasCorriente = serviceCuenta.listarCuentasCorriente();

        if (cuentasCorriente.isEmpty()) {
            System.out.println("No hay cuentas corriente registradas.");
        } else {
            for (int i = 0; i < cuentasCorriente.size(); i++) {
                System.out.println("\nCuenta #" + (i + 1) + ":");
                System.out.println(cuentasCorriente.get(i).toString());
            }
        }
    }

    private static void crearCuentaAhorro() {
        System.out.println("\nCREAR CUENTA DE AHORRO ");

        System.out.print("Número de cuenta: ");
        String numeroCuenta = scanner.nextLine();

        System.out.print("DNI del cliente: ");
        long dniCliente = Long.parseLong(scanner.nextLine());

        System.out.print("Saldo inicial: ");
        double saldoActual = Double.parseDouble(scanner.nextLine());

        System.out.print("Fecha de creación (dd/mm/yyyy): ");
        String fechaCreacion = scanner.nextLine();

        Ahorro cuentaAhorro = new Ahorro(numeroCuenta, dniCliente, saldoActual, fechaCreacion);
        serviceCuenta.crearCuenta(cuentaAhorro);

        System.out.println("\n✓ Cuenta de ahorro creada exitosamente.");
    }

    private static void crearCuentaCorriente() {
        System.out.println("\n CREAR CUENTA CORRIENTE ");

        System.out.print("Número de cuenta: ");
        String numeroCuenta = scanner.nextLine();

        System.out.print("DNI del cliente: ");
        long dniCliente = Long.parseLong(scanner.nextLine());

        System.out.print("Saldo inicial: ");
        double saldoActual = Double.parseDouble(scanner.nextLine());

        System.out.print("Impuesto: ");
        double impuesto = Double.parseDouble(scanner.nextLine());

        Corriente cuentaCorriente = new Corriente(numeroCuenta, dniCliente, saldoActual, impuesto);
        serviceCuenta.crearCuenta(cuentaCorriente);

        System.out.println("\n Cuenta corriente creada exitosamente.");
    }

    private static void obtenerInformacionCuenta() {
        System.out.println("\n BUSCAR INFORMACIÓN DE CUENTA ");

        System.out.print("Ingrese el número de cuenta: ");
        String numeroCuenta = scanner.nextLine();

        Cuenta cuenta = serviceCuenta.obtenerDatosCuenta(numeroCuenta);

        if (cuenta == null) {
            System.out.println("\n No se encontro ninguna cuenta con el número: " + numeroCuenta);
        } else {
            System.out.println("\n Informacion de la cuenta:");
            System.out.println(cuenta.toString());
        }
    }

    private static void esperarContinuar() {
        System.out.print("\nPresione ENTER para continuar...");
        scanner.nextLine();
    }
}

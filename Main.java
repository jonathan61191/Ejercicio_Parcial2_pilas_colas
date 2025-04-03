import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Inventario inventario = new Inventario();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);       
        int opcion;
        do {
            try {
                System.out.println("Bienvenido al sistema de inventario");
                System.out.println("Seleccione el dispositivo:");
                System.out.println("1. PC");
                System.out.println("2. Tablet");
                System.out.println("3. Salir");
                System.out.println("Escriba la opción correspondiente:");	
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número.");
                scanner.next(); 
                opcion = 0;             
            }            
            switch (opcion) {
                case 1:
                    menuPC();
                    break;
                case 2:
                    menuTablet();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;              
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
       
    }

    public static void menuPC(){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do { 
            try {
                System.out.println("Menu de PC");
                System.out.println("1. Agregar PC");
                System.out.println("2. Prestar PC");
                System.out.println("3. Devolver PC");
                System.out.println("4. Mostrar PCs Disponibles");
                System.out.println("5. Mostrar PCs Prestadas");
                System.out.println("6. Modificar precio PC");
                System.out.println("7. Modificar memoria RAM PC");
                System.out.println("8. Modificar disco duro PC");
                System.out.println("9. volver al menú principal");
                System.out.println("Seleccione una opción:");
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número.");
                scanner.next(); 
                opcion = 0;             
            }            
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el serial de la PC: ");
                    String serialPC = scanner.next();
                    System.out.print("Ingrese la marca de la PC: ");
                    String marcaPC = scanner.next();                    
                    double precioPC = 0;
                    do {
                        try {
                            System.out.print("Ingrese el precio de la PC: ");
                            precioPC = scanner.nextDouble();
                            if (precioPC <= 0) {
                                System.out.println("Error: El precio debe ser mayor que cero.");
                            }                            
                        } catch (InputMismatchException e) {
                            System.out.println("Error: El precio debe ser un número.");
                            scanner.next();
                        }
                    } while (precioPC <= 0);                  
                    
                    System.out.print("Ingrese la memoria RAM de la PC: ");
                    String memoriaRAM = scanner.next();
                    System.out.print("Ingrese el disco duro de la PC: ");
                    String discoDuro = scanner.next();
                    PC pc = new PC(serialPC, marcaPC, precioPC, memoriaRAM, discoDuro);
                    inventario.agregarPC(pc);                    
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuarioPC = scanner.next();
                    inventario.prestarPC(nombreUsuarioPC);
                    break;
                case 3:
                    System.out.print("Ingrese el serial de la PC a devolver: ");
                    String serialPCDevolver = scanner.next();
                    inventario.devolverPC(serialPCDevolver);
                    break;
                case 4:
                    inventario.mostrarPCsDisponibles();
                    break;
                case 5:
                    inventario.mostrarPCsPrestados();
                    break;
                case 6:
                    System.out.print("Ingrese el serial de la PC a modificar: ");
                    String serialPCModificar = scanner.next();
                    double nuevoPrecio = 0;
                    do {
                        try {
                            System.out.print("Ingrese el nuevo precio de la PC: ");
                            nuevoPrecio = scanner.nextDouble();
                            if (nuevoPrecio <= 0) {
                                System.out.println("Error: El precio debe ser mayor que cero.");
                            }                            
                        } catch (InputMismatchException e) {
                            System.out.println("Error: El precio debe ser un número.");
                            scanner.next();
                        }
                    } while (nuevoPrecio <= 0);
                    inventario.modificarPrecioPC(serialPCModificar, nuevoPrecio);                    
                    break;
                case 7:
                    System.out.print("Ingrese el serial de la PC a modificar: ");
                    String serialPCModificarRAM = scanner.next();
                    System.out.print("Ingrese la nueva memoria RAM de la PC: ");
                    String nuevaMemoriaRAM = scanner.next();
                    inventario.modificarRamPC(serialPCModificarRAM, nuevaMemoriaRAM);
                    break;
                case 8:
                    System.out.print("Ingrese el serial de la PC a modificar: ");
                    String serialPCModificarDisco = scanner.next();
                    System.out.print("Ingrese el nuevo disco duro de la PC: ");
                    String nuevoDiscoDuro = scanner.next();
                    inventario.modificarDiscoDuroPC(serialPCModificarDisco, nuevoDiscoDuro);
                    break;                    
                case 9:
                    System.out.println("bye...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 9);
    }


    public static void menuTablet(){
        Scanner scanner = new Scanner(System.in);        
        int opcion;
        do { 
            try {
                System.out.println("Menu de Tablet");
                System.out.println("1. Agregar Tablet");
                System.out.println("2. Prestar Tablet");
                System.out.println("3. Devolver Tablet");
                System.out.println("4. Mostrar Tablets Disponibles");
                System.out.println("5. Mostrar Tablets Prestadas");
                System.out.println("6. Modificar precio Tablet");
                System.out.println("7. volver al menú principal");
                System.out.println("Seleccione una opción:");
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número.");
                scanner.next(); 
                opcion = 0;             
            }            
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el serial de la Tablet: ");
                    String serialTablet = scanner.next();
                    System.out.print("Ingrese la marca de la Tablet: ");
                    String marcaTablet = scanner.next();
                    double precioTablet = 0;
                    do {
                        try {
                            System.out.print("Ingrese el precio de la Tablet: ");
                            precioTablet = scanner.nextDouble();
                            if (precioTablet <= 0) {
                                System.out.println("Error: El precio debe ser mayor que cero.");
                            }                            
                        } catch (InputMismatchException e) {
                            System.out.println("Error: El precio debe ser un número.");
                            scanner.next();
                        }
                    } while (precioTablet <= 0);
                    System.out.print("Ingrese el tamaño de la Tablet: ");
                    String tamanoTablet = scanner.next();
                    Tablet tablet = new Tablet(serialTablet, marcaTablet, precioTablet, tamanoTablet);
                    inventario.agregarTablet(tablet);     
                                  
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuarioTablet = scanner.next();
                    inventario.prestarTablet(nombreUsuarioTablet);
                    break;                
                case 3:
                    System.out.print("Ingrese el serial de la Tablet a devolver: ");
                    String serialTabletDevolver = scanner.next();
                    inventario.devolverTablet(serialTabletDevolver);
                    break;
                case 4:
                    inventario.mostrarTabletsDisponibles();
                    break;
                case 5:
                    inventario.mostrarTabletsPrestadas();
                    break;
                case 6:
                    System.out.print("Ingrese el serial de la Tablet a modificar: ");
                    String serialTabletModificar = scanner.next();
                    double nuevoPrecioTablet = 0;
                    do {
                        try {
                            System.out.print("Ingrese el nuevo precio de la Tablet: ");
                            nuevoPrecioTablet = scanner.nextDouble();
                            if (nuevoPrecioTablet <= 0) {
                                System.out.println("Error: El precio debe ser mayor que cero.");
                            }                            
                        } catch (InputMismatchException e) {
                            System.out.println("Error: El precio debe ser un número.");
                            scanner.next();
                        }
                    } while (nuevoPrecioTablet <= 0);
                    inventario.modificarPrecioTablet(serialTabletModificar, nuevoPrecioTablet);
                    break;
                case 7:
                    System.out.println("bye...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
    }
}

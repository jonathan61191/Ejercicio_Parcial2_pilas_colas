import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Inventario {
    private Stack<PC> pcDisponibles = new Stack<>();
    private Stack<Tablet> tabletDisponibles = new Stack<>();
    private Queue<PC> pcPrestados = new LinkedList<>();
    private Queue<Tablet> tabletPrestados = new LinkedList<>();

    public void agregarPC(PC pc) {
        for (PC p : pcDisponibles) {
            if (p.getSerial().equalsIgnoreCase(pc.getSerial())) {
                System.out.println("El PC con el serial " + pc.getSerial() + " ya existe en el inventario.");
                System.out.println("No se puede agregar el PC.");
                return;
            }
        }
        for (PC p : pcPrestados) {
            if (p.getSerial().equalsIgnoreCase(pc.getSerial())) {
                System.out.println("El PC con el serial " + pc.getSerial() + " ya existe en el inventario.");
                System.out.println("No se puede agregar el PC.");
                return;
            }
        }
        pcDisponibles.push(pc);
        System.out.println("PC agregado exitosamente.");
    }

    public void agregarTablet(Tablet tablet) {
        for (Tablet t : tabletDisponibles) {
            if (t.getSerial().equalsIgnoreCase(tablet.getSerial())) {
                System.out.println("La tablet con el serial " + tablet.getSerial() + " ya existe en el inventario.");
                System.out.println("No se puede agregar la tablet.");
                return;
            }
        }
        for (Tablet t : tabletPrestados) {
            if (t.getSerial().equalsIgnoreCase(tablet.getSerial())) {
                System.out.println("La tablet con el serial " + tablet.getSerial() + " ya existe en el inventario.");
                System.out.println("No se puede agregar la tablet.");
                return;
            }
        }
        tabletDisponibles.push(tablet);
        System.out.println("Tablet agregada exitosamente.");
    }

    public void prestarPC(String nombreUsuario) {
        if (!pcDisponibles.isEmpty()) {
            PC pc = pcDisponibles.pop();           
            pc.prestar(nombreUsuario);            
            pcPrestados.add(pc);
            System.out.println("PC prestado a " + nombreUsuario);
        } else {
            System.out.println("No hay PCs disponibles para prestar.");
        }
    }

    public void prestarTablet(String nombreUsuario) {
        if (!tabletDisponibles.isEmpty()) {
            Tablet tablet = tabletDisponibles.pop();
            tablet.prestar(nombreUsuario);
            tabletPrestados.add(tablet);
            System.out.println("Tablet prestada a " + nombreUsuario);
        } else {
            System.out.println("No hay tablets disponibles para prestar.");
        }
    }

    public void devolverPC(String serial) {
        for (PC pc : pcPrestados) {            
            if (pc.getSerial().equalsIgnoreCase(serial.trim())) {
                pc.devolver();
                pcPrestados.remove(pc);
                pcDisponibles.push(pc);
                System.out.println("PC devuelto.");
                return;
            }
        }
        System.out.println("No se encontró el PC con el serial proporcionado.");
    }

    public void devolverTablet(String serial) {
        for (Tablet tablet : tabletPrestados) {
            if (tablet.getSerial().equalsIgnoreCase(serial.trim())) {
                tablet.devolver();
                tabletPrestados.remove(tablet);
                tabletDisponibles.push(tablet);
                System.out.println("Tablet devuelta.");
                return;
            }
        }
        System.out.println("No se encontró la tablet con el serial proporcionado.");
    }


    public void mostrarPCsDisponibles() {
        System.out.println("PCs disponibles:");
        for (PC pc : pcDisponibles) {
            System.out.println("Serial: " + pc.getSerial() + ", Marca: " + pc.getMarca() + ", Precio: " + pc.getPrecio());
        }
    }

    public void mostrarTabletsDisponibles() {
        System.out.println("Tablets disponibles:");
        for (Tablet tablet : tabletDisponibles) {
            System.out.println("Serial: " + tablet.getSerial() + ", Marca: " + tablet.getMarca() + ", Precio: " + tablet.getPrecio());
        }
    }

    public void mostrarPCsPrestados() {
        System.out.println("PCs prestados:");
        for (PC pc : pcPrestados) {
            System.out.println("Serial: " + pc.getSerial() + ", Marca: " + pc.getMarca() + ", Precio: " + pc.getPrecio() + ", Usuario: " + pc.getNombreUsuario());
        }
    }

    public void mostrarTabletsPrestadas() {
        System.out.println("Tablets prestadas:");
        for (Tablet tablet : tabletPrestados) {
            System.out.println("Serial: " + tablet.getSerial() + ", Marca: " + tablet.getMarca() + ", Precio: " + tablet.getPrecio() + ", Usuario: " + tablet.getNombreUsuario());
        }
    }


    public void modificarPrecioTablet(String serial, double nuevoPrecio) {
        for (Tablet tablet : tabletDisponibles) {
            if (tablet.getSerial().equalsIgnoreCase(serial.trim())) {
                tablet.setPrecio(nuevoPrecio);
                System.out.println("Precio de la tablet modificado a: " + nuevoPrecio);
                return;
            }
        }
        System.out.println("No se encontró la tablet con el serial proporcionado.");
    }


    public void modificarPrecioPC(String serial, double nuevoPrecio) {
        for (PC pc : pcDisponibles) {
            if (pc.getSerial().equalsIgnoreCase(serial.trim())) {
                pc.setPrecio(nuevoPrecio);
                System.out.println("Precio del PC modificado a: " + nuevoPrecio);
                return;
            }
        }
        System.out.println("No se encontró el PC con el serial proporcionado.");
    }

    public void modificarRamPC(String serial, String nuevaRam) {
        for (PC pc : pcDisponibles) {
            if (pc.getSerial().equalsIgnoreCase(serial.trim())) {
                pc.setMemoriaRAM(nuevaRam);
                System.out.println("RAM del PC modificado a: " + nuevaRam);
                return;
            }
        }
        System.out.println("No se encontró el PC con el serial proporcionado.");
    }

    public void modificarDiscoDuroPC(String serial, String nuevoDiscoDuro) {
        for (PC pc : pcDisponibles) {
            if (pc.getSerial().equalsIgnoreCase(serial.trim())) {
                pc.setDiscoDuro(nuevoDiscoDuro);
                System.out.println("Disco Duro del PC modificado a: " + nuevoDiscoDuro);
                return;
            }
        }
        System.out.println("No se encontró el PC con el serial proporcionado.");
    }

    
}

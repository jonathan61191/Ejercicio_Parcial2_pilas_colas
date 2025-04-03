public class Tablet {
    private String serial;
    private String marca;
    private double precio;
    private String tamano;
    private String nombreUsuario;
    private boolean disponible;

    public Tablet(String serial, String marca, double precio, String tamano) {
        this.serial = serial;
        this.marca = marca;
        this.precio = precio;
        this.tamano = tamano;
        this.nombreUsuario = "";
        this.disponible = true; 
    }

    public String getSerial() {
        return serial;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTamano() {
        return tamano;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public boolean esDisponible() {
        return disponible;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
   
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
 

    public void prestar(String nombreUsuario) {
        if (disponible) {
            this.nombreUsuario = nombreUsuario;
            this.disponible = false;
        } else {
            System.out.println("La tablet no está disponible para prestar.");
        }
    }
    
    public void devolver() {
        if (!disponible) {
            this.nombreUsuario = "";
            this.disponible = true;
        } else {
            System.out.println("La tablet ya está disponible.");
        }
    }



}
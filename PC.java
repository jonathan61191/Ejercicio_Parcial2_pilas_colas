public class PC {
    private String serial;
    private String marca;
    private double precio;
    private String memoriaRAM;
    private String discoDuro;
    private String nombreUsuario;
    private boolean disponible;

    public PC(String serial, String marca, double precio, String memoriaRAM, String discoDuro) {
        this.serial = serial;
        this.marca = marca;
        this.precio = precio;
        this.memoriaRAM = memoriaRAM;
        this.discoDuro = discoDuro;
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

    public String getMemoriaRAM() {
        return memoriaRAM;
    }

    public String getDiscoDuro() {
        return discoDuro;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public boolean isDisponible() {
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

    public void setMemoriaRAM(String memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public void setDiscoDuro(String discoDuro) {
        this.discoDuro = discoDuro;
    }

    public void prestar(String nombreUsuario) {
        if (disponible) {
            this.nombreUsuario = nombreUsuario;
            this.disponible = false;
        } else {
            System.out.println("El PC no está disponible para prestar.");
        }
    }

    public void devolver() {
        if (!disponible) {
            this.nombreUsuario = "";
            this.disponible = true;
        } else {
            System.out.println("El PC ya está disponible.");
        }
    }


}

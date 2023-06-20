package Enums;

public enum Category {
    TECHNOLOGY("TECNOLOGIA"),
    FASHION("MODA"),
    VEHICLES("VEHICULOS"),
    SUPERMARKET("SUPERMERCADO");

    private final String nombre;

    Category(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
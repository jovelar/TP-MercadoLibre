public enum Province {
    BSAS("Buenos Aires"), CABA("CABA"), CATAMARCA("Catamarca"), CHACO("Chaco"),
    CHUBUT("Chubut"), CORDOBA("Córdoba"), CORRIENTES("Corrientes"),
    ENTRERIOS("Entre Ríos"), FORMOSA("Formosa"), JUJUY("Jujuy"),
    LAPAMPA("La Pampa"), LARIOJA("La Rioja"), MENDOZA("Mendoza"), MISIONES("Misiones"),
    NEUQUEN("Neuquén"), RIONEGRO("Río Negro"), SALTA("Salta"), SANJUAN("San Juan"),
    SANLUIS("San Luis"), SANTACRUZ("Santa Cruz"), SANTAFE("Santa Fe"),
    SANTIAGODELESTERO("Santiago del Estero"), TIERRADELFUEGO("Tierra del Fuego"), TUCUMAN("Tucumán");

    private final String nombre;

    Province(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

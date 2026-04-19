package models;

/**
 * Represents a guest (invitado) registered in the system.
 */
public class Invitado {

    private String nombre;
    private String celular;
    private String genero;
    private String fechaNacimiento;
    private String direccion;
    private boolean aceptaTerminos;

    public Invitado(String nombre, String celular, String genero,
                    String fechaNacimiento, String direccion, boolean aceptaTerminos) {
        this.nombre = nombre;
        this.celular = celular;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.aceptaTerminos = aceptaTerminos;
    }

    public String getNombre()           { return nombre; }
    public String getCelular()          { return celular; }
    public String getGenero()           { return genero; }
    public String getFechaNacimiento()  { return fechaNacimiento; }
    public String getDireccion()        { return direccion; }
    public boolean isAceptaTerminos()   { return aceptaTerminos; }
}
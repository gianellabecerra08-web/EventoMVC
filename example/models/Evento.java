package models;

public class Evento {
    private String nombre;
    private String fecha;
    private String lugar;
    private String invitado;

    public Evento(String nombre, String fecha, String lugar, String invitado) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.invitado = invitado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public String getInvitado() {
        return invitado;
    }
}

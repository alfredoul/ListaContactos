package mx.alfredoul.listacontactos;

/**
 * Created by alfredoul on 13/11/16.
 */

public class Contacto {
    //generamos las variables públicas, mis atributos
    private String nombre;
    private String telefono;
    private String email;
    private int foto;

    //generamos un método constructor Contacto para poder instanciar nuestros objetos
    public Contacto(int foto, String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.foto = foto;
    }

    //generamos getters & setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}

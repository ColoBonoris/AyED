package p2;

/**
 * Persona
 */
public class Persona {

    private String nombre;
    private String apellido;
    private String mail;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public String tusDatos(){
        String auxStr = new String("Nombre : " + this.getNombre()
        + ", Apellido: " + this.getApellido()
        + ", Mail: " + this.getMail()
        + ".");
        return auxStr;
    }

}

package p2;
/*
 
 */
public class Alumno extends Persona{
    private String facultad;
    private String comision;
    private String direccion;

    public Alumno(){

    }

    public Alumno(String nombre,
    String apellido,
    String mail,
    String facultad,
    String comision,
    String direccion){
        super.setNombre(nombre);
        super.setApellido(apellido);
        super.setMail(mail);
        this.comision = comision;
        this.direccion = direccion;
        this.facultad = facultad;
    }
    public String getFacultad() {
        return this.facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getComision() {
        return this.comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public String tusDatos(){
        String auxStr = new String(super.tusDatos()
        + ", Facultad: " + this.getFacultad()
        + ", Comision: " + this.getComision()
        + ", Direccion: " + this.getDireccion()
        + ".");
        return auxStr;
    }

    @Override
    public String toString(){
        return this.tusDatos();
    }
}

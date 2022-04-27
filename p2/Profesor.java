package p2;

public class Profesor extends Persona{

    private String catedra;
    private String facultad;

    public String getCatedra() {
        return this.catedra;
    }

    public void setCatedra(String catedra) {
        this.catedra = catedra;
    }

    public String getFacultad() {
        return this.facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String tusDatos(){
        String auxStr = new String(super.tusDatos()
        + ", Facultad: " + this.getFacultad()
        + ", Catedra: " + this.getCatedra()
        + ".");
        return auxStr;
    }  

}
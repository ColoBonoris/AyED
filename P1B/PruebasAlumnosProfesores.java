package P1B;

/*
    Escriba una clase llamada Test con el método main, el cual cree un arreglo
    con 2 objetos Estudiante, otro arreglo con 3 objetos Profesor, y luego
    recorra ambos arreglos imprimiendo los valores obtenidos mediante el
    método tusDatos(). Recuerde asignar los valores de los atributos de los
    objetos Estudiante y Profesor invocando los respectivos métodos setters.
 */
public class PruebasAlumnosProfesores {

    public static void main(String[] args) {
        Alumno[] a = new Alumno[2];
        Profesor[] p = new Profesor[3];
        a[0] = new Alumno("Nicolas",
        "Bonoris",
        "fakemail@gmail.com",
        "Informatica",
        "Prueba Comision",
        "Calle Falsa 123"
        );
        a[1] = new Alumno();
        a[1].setNombre("Nombre 1");
        a[1].setApellido("Apellido 1");
        a[1].setMail("mail1@gmail.com");
        a[1].setFacultad("Facultad 1");
        a[1].setComision("Comision 1");
        a[1].setDireccion("Direccion 1");
        for (int i = 0; i < p.length; i++) {
            p[i] = new Profesor();
            p[i].setNombre("Nombre " + i);
            p[i].setApellido("Apellido " + i);
            p[i].setMail("mail" + i + "@gmail.com");
            p[i].setFacultad("Facultad " + i);
            p[i].setCatedra("Catedra " + i);
            System.out.println("    Profesor " + i + " = \n      " + p[i].tusDatos());
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println("    Alumno " + i + " = \n      " + a[i].tusDatos());
        }
    }
}
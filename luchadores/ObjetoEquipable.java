package luchadores;

import java.lang.Math;

public class ObjetoEquipable {

    private String nombre;
    private int mejoraBase;
    private int estrellas;
    private int mejoraFinal;
    private String estadistica;

    public ObjetoEquipable() {
        this.nombre = elegirNombre(nombres());
        this.mejoraBase = obtenerMejoraBase();
        this.estrellas = obtenerEstrellas();
        this.mejoraFinal = obtenerMejoraFinal();
        this.estadistica = elegirEst(estadisticas());
    }
     public ObjetoEquipable(int estrellas) {
        this.nombre = elegirNombre(nombres());
        this.mejoraBase = obtenerMejoraBase();
        this.estrellas = estrellas;
        this.mejoraFinal = obtenerMejoraFinal();
        this.estadistica = elegirEst(estadisticas());
    }

    @Override
    public String toString() {
        String saltoLinea = System.getProperty("line.separator");
        return "Nombre: " + nombre + saltoLinea
                + "Mejora Base: " + mejoraBase + saltoLinea
                + "Estrellas: " + estrellas + saltoLinea
                + "Mejora Final: " + mejoraFinal + saltoLinea
                + "Estadistica: " + estadistica;
    }

    //metodo para mostrar el objeto dropeado por consola
    public void mostrarDrop() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Estrellas: " + estrellas);
        System.out.println("Mejora total: " + mejoraFinal + " al " + estadistica);
    }

    //Metodos que final la base, estrellas y mejora final del objeto equipable
    private int obtenerMejoraBase() {
        int mejoraBase = (int) (Math.random() * 9 + 1);
        return mejoraBase;
    }

    private int obtenerEstrellas() {
        int por = (int) (Math.random() * 100 + 1);
        int estrellas = 1;
        if (por > 20) {
            estrellas = 2;
        }
        if (por > 40) {
            estrellas = 3;
        }
        if (por > 60) {
            estrellas = 4;
        }
        if (por > 75) {
            estrellas = 5;
        }
        if (por > 85) {
            estrellas = 6;
        }
        if (por > 90) {
            estrellas = 7;
        }
        if (por > 94) {
            estrellas = 8;
        }
        if (por > 97) {
            estrellas = 9;
        }
        if (por > 99) {
            estrellas = 10;
        }
        /*no es necesario hacer "else" porque el valor de las estrellas 
            dejaran de cambiar cuando ya no se cumpla la condici�n
            (debi hacer lo mismo cuando hacia el rango de 
            los luchadores para la primera tarea)*/
        return estrellas;
    }

    private int obtenerMejoraFinal() {
        mejoraFinal = mejoraBase * estrellas;
        return mejoraFinal;
    }

    //Metodo para darle "nombre" al arma
    private String[] nombres() {
        String[] nom = new String[5];
        nom[0] = "Maza";
        nom[1] = "Staff";
        nom[2] = "Espada";
        nom[3] = "Escudo";
        nom[4] = "Dagas";
        return nom;
    }

    private String elegirNombre(String[] nom) {
        int n = (int) (Math.random() * 5);
        String name = nom[n];
        return name;
    }

    private String[] estadisticas() {
        String[] stat = new String[4];
        stat[0] = "HP";
        stat[1] = "ATK";
        stat[2] = "DEF";
        stat[3] = "SPD";
        return stat;
    }

    private String elegirEst(String[] stat) {
        int e = (int) (Math.random() * 4);
        String estadistica = stat[e];
        return estadistica;
    }

    //Métodos get y set
    public String getNombre() {
        return nombre;
    }

    public int getMejoraBase() {
        return mejoraBase;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public int getMejoraFinal() {
        return mejoraFinal;
    }

    public String getEstadistica() {
        return estadistica;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMejoraBase(int mejoraBase) {
        this.mejoraBase = mejoraBase;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public void setMejoraFinal(int mejoraFinal) {
        this.mejoraFinal = mejoraFinal;
    }

    public void setEstadistica(String estadistica) {
        this.estadistica = estadistica;
    }

}

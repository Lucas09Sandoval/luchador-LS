package luchadores;

public class Personaje {

    protected String nombre;
    protected String faccion;
    protected int hp;
    protected int atk;
    protected int def;
    protected int spd;

    public Personaje(String nombre, String faccion, int hp, int atk, int def, int spd) {
        this.nombre = nombre;
        this.faccion = faccion;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }

    public String toString() {
        String saltoLinea = System.getProperty("line.separator");
        return "Nombre: " + nombre + saltoLinea
                + "Facción: " + faccion + saltoLinea
                + "HP: " + hp + saltoLinea
                + "Ataque: " + atk + saltoLinea
                + "Defensa: " + def + saltoLinea
                + "Velocidad: " + spd;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFaccion() {
        return this.faccion;
    }

    public void setFaccion(String faccion) {
        this.faccion = faccion;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return this.atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return this.def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpd() {
        return this.spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }
}

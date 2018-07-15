package luchadores;

import java.lang.Math;
import java.util.ArrayList;

public class Monstruo extends Personaje {
    //los datos base de cada Monstruo creado	

    private ArrayList<ObjetoEquipable> drop;

    //Constructor de la clase monstruo con datos al azar
    public Monstruo(String nombre, String faccion, int hp, int atk, int def, int spd) {
        super(nombre, faccion, hp, atk, def, spd);
        this.nombre = elegirNombre(nombresDeMonstruo());
        this.faccion = elegirFaccion(faccionMonstruo());
        this.hp = hp();
        this.atk = atk();
        this.def = def();
        this.spd = spd();
        this.drop = new ArrayList<ObjetoEquipable>();
        //esto es para la clase batalla
        llenarArrayListDrop();
    }

    @Override
    public String toString() {
        String saltoLinea = System.getProperty("line.separator");
        return "Nombre: " + nombre + saltoLinea
                + "Facción: " + faccion + saltoLinea
                + "HP: " + hp + saltoLinea
                + "Ataque: " + atk + saltoLinea
                + "Defensa: " + def + saltoLinea
                + "Velocidad: " + spd + saltoLinea
                + "Drop: " + objetos();
    }

    private String objetos() {
        String drop = "";
        String saltoLinea = System.getProperty("line.separator");
        for (int x = 0; x < this.drop.size(); x++) {
            drop += this.drop.get(x).getNombre()+"\t"+"Estrellas: "+this.drop.get(x).getEstrellas() + saltoLinea;
        }
        return drop;
    }

    //Para la clase batalla
    private void llenarArrayListDrop() {
        int prob = (int) (Math.random() * 100 + 1);
        ObjetoEquipable objeto;
        if (prob > 40) {
            objeto = new ObjetoEquipable(1);
            this.drop.add(objeto);
        } else {
            if (prob > 10) {
                objeto = new ObjetoEquipable(3);
                this.drop.add(objeto);
            } else {
                if (prob <= 10) {
                    objeto = new ObjetoEquipable(5);
                    this.drop.add(objeto);
                }
            }
        }
    }

    //Método para que el drop valla al InventarioDeObjetos
    private void soltarDrop() {
        if (this.hp <= 0) {
            InventarioObjetos inventario = new InventarioObjetos();
            if (inventario.inventarioObj.size() <= 10) {
                for (int x = 0; x < drop.size(); x++) {
                    inventario.inventarioObj.add(this.drop.get(x));
                }
            }
        }
    }

    //Método que muestra el monstruo creado en consola
    public void mostrarMonstruo() {
        System.out.println("Se ha creado un monstruo");
        System.out.println("Nombre: " + nombre);
        System.out.println("Faccion: " + faccion);
        System.out.println("HP: " + "\t" + hp);
        System.out.println("ATK: " + "\t" + atk);
        System.out.println("DEF: " + "\t" + def);
        System.out.println("SPD: " + "\t" + spd);
    }

    //m�todos que generan el nombre, faccion y las estadisticas del monstruo
    private String[] nombresDeMonstruo() {
        String[] monstruos = new String[3];
        monstruos[0] = "Ghost Rider";
        monstruos[1] = "Dark Veilnus";
        monstruos[2] = "Vanir";

        return monstruos;
    }

    private String elegirNombre(String[] monstruos) {
        int m = (int) (Math.random() * 3);
        String nombre = monstruos[m];
        return nombre;
    }

    private String[] faccionMonstruo() {
        String[] faccion = new String[3];
        faccion[0] = "Agua";
        faccion[1] = "Fuego";
        faccion[2] = "Planta";
        return faccion;
    }

    private String elegirFaccion(String[] faccion) {
        //f variable para obtener facci�n
        int f = (int) (Math.random() * 3);
        String tipo = faccion[f];
        return tipo;
    }

    private int hp() {
        int hp = (int) (Math.random() * 3501 + 500);
        return hp;
    }

    private int atk() {
        int atk = (int) (Math.random() * 1001 + 500);
        return atk;
    }

    private int def() {
        int def = (int) (Math.random() * 6 + 20);
        return def;
    }

    private int spd() {
        int spd = (int) (Math.random() * 11 + 90);
        return spd;
    }

    //Métodos get y set	
    public ArrayList<ObjetoEquipable> getDrop() {
        return drop;
    }

    public void setDrop(ArrayList<ObjetoEquipable> drop) {
        this.drop = drop;
    }

}

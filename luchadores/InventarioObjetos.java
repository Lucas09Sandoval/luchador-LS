package luchadores;

import java.util.ArrayList;

public class InventarioObjetos {

    public static ArrayList<ObjetoEquipable> inventarioObj = new ArrayList<ObjetoEquipable>();

    @Override
    public String toString() {
        return contenido();
    }

    private String contenido() {
        String saltoLinea = System.getProperty("line.separator");
        String contenido = "";
        for (int x = 0; x < inventarioObj.size(); x++) {
            contenido += inventarioObj.get(x).toString() + saltoLinea;
        }
        return contenido;
    }

    //Metodo que mustre todos los Objetos del inventario de Objetos por consola
    public void mostrarInvObj() {
        for (int i = 0; i < inventarioObj.size(); i++) {
            System.out.print("Obj N°:" + " " + (i + 1) + "\t" + "Nombre " + inventarioObj.get(i).getNombre());
            System.out.print("\t" + "Estrellas: " + "\t" + inventarioObj.get(i).getEstrellas());
            System.out.print("\t" + "MejoraTotal: " + "\t" + inventarioObj.get(i).getMejoraFinal());
            System.out.print("\t" + "Estadistica que mejora: " + "\t" + inventarioObj.get(i).getEstadistica());
            System.out.println("");
        }
    }

    //Metodo que agrega un objeto al inventario de objetos
    public void agregarObjeto() {
        if (inventarioObj.size() == 10) {
            //System.out.println("No se pueden agregar Objetos");
        } else {
            ObjetoEquipable objeto = new ObjetoEquipable();
            inventarioObj.add(objeto);
        }
    }

    //Metodo que elimina un Objeto
    public void eliminarUnObjeto(int x) {
        if (inventarioObj.size() == 0) {
            //System.out.println("No hay objetos para mover al inventario");
        } else {
            inventarioObj.remove(x);
            //System.out.println("Se elimino el objeto " + (x+1) + " del inventario de objetos");
        }
    }

    //Metodo que filtra los Objetos
    public String filtrarObjetos(int x) {

        String objetos = null;
        String frase = null;
        String saltoLinea = System.getProperty("line.separator");
        int estrellas = x;

        for (int i = 0; i < inventarioObj.size(); i++) {
            if (inventarioObj.get(i).getEstrellas() == estrellas) {
                objetos += inventarioObj.get(i).getNombre() + saltoLinea;

            }
        }

        if (objetos != null) {
            frase = "No hay resultados";
            objetos = "";
        } else {
            frase = "Los objetos son: ";
        }
        return (frase + objetos);
    }

    //Métodos get y set
    public ArrayList<ObjetoEquipable> getInventarioObj() {
        return inventarioObj;
    }

    public void setInventarioObj(ArrayList<ObjetoEquipable> inventarioObj) {
        this.inventarioObj = inventarioObj;
    }

}

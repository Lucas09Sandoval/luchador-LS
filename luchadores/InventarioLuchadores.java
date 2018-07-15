package luchadores;

import java.util.ArrayList;

public class InventarioLuchadores {

    public static ArrayList<Luchador> inventarioLuch = new ArrayList<Luchador>();

    //Método que retorna todos los luchadores del inventario
    @Override
    public String toString() {
        return contenido();
    }

    private String contenido() {
        String saltoLinea = System.getProperty("line.separator");
        String contenido = "";
        for (int x = 0; x < inventarioLuch.size(); x++) {
            contenido += inventarioLuch.get(x).toString() + saltoLinea;
        }
        return contenido;

    }

    //Metodo que mustra todos los luchadores del inventario por consola
    public void mostrarInv() {
        for (int i = 0; i < inventarioLuch.size(); i++) {
            System.out.print("Luchador N°" + " " + i + "\t" + "Nombre " + inventarioLuch.get(i).getNombre());
            System.out.print("\t" + "Rango " + "\t" + inventarioLuch.get(i).getRango());
            System.out.print("\t" + "Facci�n " + "\t" + inventarioLuch.get(i).getFaccion());
            System.out.println("");
        }
    }

    //Metodo que retorna un solo luchador del arraylist inventario con todos sus datos	    	
    public String verUnLuchador(int x) {
        return inventarioLuch.get(x).toString();
    }

    //Metodo que agrega luchador al inventario
    public void agregarLuchador() {
        if (inventarioLuch.size() == 25) {
            //System.out.println("No se pueden agregar m�s luchadores");
        } else {
            //System.out.println("Se ha agregado un luchador");
            Luchador luchador = new Luchador("", "", 0, 0, 0, 0);
            inventarioLuch.add(luchador);
        }
    }

    //Metodo que elimina un luchador
    public void eliminarUnluchador(int x) {
        inventarioLuch.remove(x);
        //System.out.println("Se elimino un luchador del inventario");
    }

    //Metodo que filtra los luchadores
    public String filtrarLuchadorPorRango(int x) {

        String resultados = "";
        String saltoLinea = System.getProperty("line.separator");

        for (int i = 0; i < inventarioLuch.size(); i++) {
            if (inventarioLuch.get(i).getRango() == x) {
                resultados += inventarioLuch.get(i).getNombre() + saltoLinea;
            }
        }

        return resultados;

    }

    public String filtrarLuchadorPorFaccion(String faccion) {

        String resultados = "";
        String saltoLinea = System.getProperty("line.separator");

        for (int i = 0; i < inventarioLuch.size(); i++) {
            if (faccion.equals(inventarioLuch.get(i).getFaccion())) {
                resultados += inventarioLuch.get(i).getNombre() + saltoLinea;
            }
        }
        return resultados;
    }
}

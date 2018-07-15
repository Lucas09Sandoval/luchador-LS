package Main;

import luchadores.*;

public class Main {

    public static void main(String[] args) {
        Batalla campo = new Batalla();
        campo.agregarLuchadores();

        System.out.println("Equipo");
        for (int x = 0; x < campo.equipo.size(); x++) {
            System.out.println(campo.equipo.get(x).toString());
        }

        System.out.println("");
        System.out.println("Boss");
        System.out.println(campo.enemigo.toString());

        parte2(campo);
    }

    private static void parte2(Batalla campo) {

        campo.iniciarPartida();

    }

}

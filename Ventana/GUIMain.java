package Ventana;

public class GUIMain {

    public static void main(String[] args) {

        /*Tener en cuenta que los 25 luchadores son generados al azar, el usuario solo
        elige 6 de los 25 para jugar*/
        GUIDatos datos = new GUIDatos("Datos de la partida");
        datos.setVisible(true);
    }
}

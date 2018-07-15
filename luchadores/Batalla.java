package luchadores;

import java.util.ArrayList;
import java.lang.Math;

public class Batalla {

    public static Monstruo enemigo = new Monstruo(" ", " ", 0, 0, 0, 0);
    public static ArrayList<Luchador> equipo = new ArrayList<Luchador>();
    //el arrrayList turno es para poder ordenar el orden en que se moveran los luchadores

    public void agregarLuchadores() {
        Luchador luchador;
        for (int x = 0; x < 6; x++) {
            luchador = new Luchador("", " ", 0, 0, 0, 0);
            equipo.add(luchador);
        }
        vectorLuchadores();
    }

    //Método para hacer vector con el que trabajara el ordenamiento de la burbuja
    private void vectorLuchadores() {
        Luchador[] luchs = new Luchador[6];
        for (int i = 0; i < luchs.length; i++) {
            luchs[i] = equipo.get(i);
        }
        burbuja(luchs);
    }

    //Método de la burbuja para ordenar luchadores por las velocidades
    private void burbuja(Luchador[] luchs) {

        for (int i = 0; i < luchs.length - 1; i++) {
            for (int j = 0; j < luchs.length - 1; j++) {
                if (luchs[j].getSpd() < luchs[j + 1].getSpd()) {
                    Luchador tmp = luchs[j + 1];
                    luchs[j+1] = null;
                    luchs[j + 1] = luchs[j];
                    luchs[j] = null;
                    luchs[j] = tmp;
                }
            }
        }
        ordenarTurno(luchs);
    }

    //aqui se agregran los luchadores ordenados del vector al arrayList
    //primero se vacia el equipo para evitar que se dupliquen los luchadores
    private void ordenarTurno(Luchador[] luchs) {
        
        int largoArrayList = equipo.size();
        
        equipo.clear();
        
        for (int x = 0; x < largoArrayList; x++) {
                    equipo.add(luchs[x]);
        }
    }

    public void iniciarPartida() {
        int a = lanzarDados();
        System.out.println("Resultado de los dados: "+a);
        evaluarCaso(a);

        System.out.println("Luchadores despues de lanzar dados");
        for (int x = 0; x < equipo.size(); x++) {
            System.out.println(equipo.get(x).toString());
        }
        System.out.println("Mosntruo despues de lanzar dados");
        System.out.println(enemigo.toString());

        pelear();
        System.out.println(finalizarPartida());
    }

    private void pelear() {

        do {
            if (enemigo.getSpd() > equipo.get(0).getSpd()) {
                if (enemigo.getHp() != 0) {
                    atacarM(enemigo);
                }
                for (int x = 0; x < equipo.size(); x++) {
                    atacarJ(equipo.get(x));
                }
            } else {
                for (int x = 0; x < equipo.size(); x++) {
                    atacarJ(equipo.get(x));
                }
                if (enemigo.getHp() != 0) {
                    atacarM(enemigo);
                }
            }
        } while (enemigo.getHp() != 0 && equipo.size() != 0);
    }

    //Métodos pedidos para el avance anterior de ayudantía
    private int lanzarDados() {
        int dado1 = lanzarDado1();//el de 8 caras		
        int dado2 = lanzarDado2();//el de 6 caras

        int resultado = (dado1 - dado2);
        return resultado;
    }

    //Métodos para obtene el valor del dado de 8 y 6 respectivamente
    private int lanzarDado1() {
        int dado8c = (int) (Math.random() * 8 + 1);
        return dado8c;
    }

    private int lanzarDado2() {
        int dado6c = (int) (Math.random() * 6 + 1);
        return dado6c;
    }

    //Métodos para evaluar resultados del lanzarDados()
    private void evaluarCaso(int resultado) {

        if (resultado > 0) {

            for (int x = 0; x < equipo.size(); x++) {
                int dmg = equipo.get(x).getAtk();
                equipo.get(x).setAtk(dmg * resultado);
            }
        } else {
            if (resultado == 0) {
                //No pasa nada (?)
            } else {
                if (resultado < 0) {
                    int dmg = enemigo.getAtk();
                    enemigo.setAtk(dmg * (resultado * (-1)));
                }
            }
        }
    }

    //Métodos para poder atacar
    private void atacarJ(Luchador luchador) {

        String faccionM = enemigo.getFaccion();
        String faccionJ = luchador.getFaccion();
        double bonus = evaluarFaccion(faccionJ, faccionM);

        double a = (luchador.getAtk() * bonus);

        int dmg = (int) a;

        int dmgT = (dmg - enemigo.getDef());

        if (dmgT < 0) {
            dmgT = 0;
        }
        int hpMonstruo = enemigo.getHp();

        enemigo.setHp(hpMonstruo - dmgT);

        if (enemigo.getHp() < 0) {
            enemigo.setHp(0);
        }
    }

    private void atacarM(Monstruo enemigo) {

        String faccionM = enemigo.getFaccion();
        String faccionJ = equipo.get(0).getFaccion();
        double bonus = evaluarFaccion(faccionM, faccionJ);

        double a = (enemigo.getAtk() * bonus);

        int dmg = (int) a;

        int dmgT = (dmg - equipo.get(0).getDef());

        if (dmgT < 0) {
            dmgT = 0;
        }

        int hpLuchador = equipo.get(0).getHp();

        equipo.get(0).setHp(hpLuchador - dmgT);

        if (equipo.get(0).getHp() < 0) {
            equipo.get(0).setHp(0);
        }

        if (equipo.get(0).getHp() == 0) {
            equipo.remove(0);
            System.out.println("Un luchador a muerto!");
        }
    }

    //Método para ver si la facción es favorable o desfavorable
    private double evaluarFaccion(String faccionAtacante, String faccionResistiendo) {
        double bonus = 1;
        if (faccionAtacante.equals("Agua")) {
            if (faccionResistiendo.equals("Fuego")) {
                bonus = (1.5);
            }

            if (faccionResistiendo.equals("Planta")) {
                bonus = (0.75);
            }
        }
        if (faccionAtacante.equals("Fuego")) {
            if (faccionResistiendo.equals("Planta")) {
                bonus = (1.5);
            }
            if (faccionResistiendo.equals("Agua")) {
                bonus = (0.75);
            }
        }
        if (faccionAtacante.equals("Planta")) {
            if (faccionResistiendo.equals("Agua")) {
                bonus = (1.5);
            }
            if (faccionResistiendo.equals("Fuego")) {
                bonus = (0.75);
            }
        }
        return bonus;
    }

    private String finalizarPartida() {
        String ganador = "";

        if (equipo.size() == 0) {
            ganador = "Perdido, vuelve a intentar :c";
        } else {
            ganador = "Ganado! Felicidades";
        }

        return "Usted ha: " + ganador;
    }
}

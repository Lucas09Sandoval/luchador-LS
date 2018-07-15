package luchadores;

import java.lang.Math;

public class Luchador extends Personaje {

    private int rango;
    private ObjetoEquipable[] objeto;

    //Con datos ingresados por el usuario
    public Luchador(String nombre, String faccion, int hp, int atk, int def, int spd, int rango) {
        super(nombre, faccion, hp, atk, def, spd);
        this.rango = rango;
        this.objeto = new ObjetoEquipable[1];
    }

    //luchador generado con datos al azar
    public Luchador(String nombre, String faccion, int hp, int atk, int def, int spd) {
        super(nombre, faccion, hp, atk, def, spd);
        this.nombre = elegirNombre(nombres());
        this.faccion = elegirFaccion(faccion());
        this.hp = hp();
        this.atk = atk();
        this.def = def();
        this.spd = spd();
        this.rango = rango();
        this.objeto = new ObjetoEquipable[1];
    }

    private String objetoEquipado() {
        String contenido = "";
        if (objeto[0] == null) {
            contenido = "El luchador no tiene Objeto equipado";
        } else {
            contenido = objeto[0].getNombre();
        }
        return contenido;
    }

    //Método para equipar objeto
    public void equiparObjeto(ObjetoEquipable objetoEquipable) {
        objeto[0] = objetoEquipable;
        aumentarEstadisticas(objetoEquipable);
    }

    //Metodo para aumentar las estadisticas con el bono del objeto equipado
    private void aumentarEstadisticas(ObjetoEquipable objeto) {
        int aumento = objeto.getMejoraFinal();
        String estadistica = objeto.getEstadistica();
        //no es necesario hacer else 
        if (estadistica.equals("HP")) {
            aumentarHp(aumento);
        }
        if (estadistica.equals("ATK")) {
            aumentarAtk(aumento);
        }
        if (estadistica.equals("DEF")) {
            aumentarDef(aumento);
        }
        if (estadistica.equals("SPD")) {
            aumentarSpd(aumento);
        }
    }

    private void aumentarHp(int aumento) {
        this.setHp((this.hp + aumento));
    }

    private void aumentarAtk(int aumento) {
        this.setAtk((this.atk + aumento));
    }

    private void aumentarDef(int aumento) {
        this.setAtk((this.def + aumento));
    }

    private void aumentarSpd(int aumento) {
        this.setAtk((this.spd + aumento));
    }

    //Método para desequiparObjeto
    public void desequiparObjeto() {
        ObjetoEquipable objetoEquipable = objeto[0];
        objeto[0] = null;
        reducirEstadisticas(objetoEquipable);
    }

    //Método para quitar el bono del objeto
    private void reducirEstadisticas(ObjetoEquipable objeto) {
        int aumento = objeto.getMejoraFinal();
        String estadistica = objeto.getEstadistica();
        //no es necesario hacer else 
        if (estadistica.equals("HP")) {
            reducirHp(aumento);
        }
        if (estadistica.equals("ATK")) {
            reducirAtk(aumento);
        }
        if (estadistica.equals("DEF")) {
            reducirDef(aumento);
        }
        if (estadistica.equals("SPD")) {
            reducirSpd(aumento);
        }
    }

    //Metodo para quitar el bono del objeto
    private void reducirHp(int aumento) {
        this.setHp((this.hp - aumento));
    }

    private void reducirAtk(int aumento) {
        this.setHp((this.atk - aumento));
    }

    private void reducirDef(int aumento) {
        this.setHp((this.def - aumento));
    }

    private void reducirSpd(int aumento) {
        this.setHp((this.spd - aumento));
    }

    //M�todo para mostrar datos
    public void mostrarLuchador() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Facción: " + faccion);
        System.out.println("Rango: " + rango);
        System.out.println("HP: " + hp);
        System.out.println("ATK: " + atk);
        System.out.println("DEF " + def);
        System.out.println("SPD: " + spd);
    }

//Metodos para crear los datos de un luchador (Nombre, faccion, rango, estadisticas)
    private String[] nombres() {
        String[] peleadores = new String[15];
        peleadores[0] = "Kazuma";
        peleadores[1] = "Wolfmanx";
        peleadores[2] = "Darkrai";
        peleadores[3] = "Destroyer";
        peleadores[4] = "Gintoki";
        peleadores[5] = "Magikarp";
        peleadores[6] = "Agumon";
        peleadores[7] = "Naruto";
        peleadores[8] = "Luffy";
        peleadores[9] = "Goku";
        peleadores[10] = "Ichigo";
        peleadores[11] = "Hakuno";
        peleadores[12] = "Shirou";
        peleadores[13] = "Araragi";
        peleadores[14] = "Saitama";
        return peleadores;
    }

    private String elegirNombre(String[] peleadores) {
        //n  variable para obtener el normbre del luchador
        int n = (int) (Math.random() * 15);
        String name = peleadores[n];
        return name;
    }

    private String[] faccion() {
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

    private int rango() {
        int prob = (int) (Math.random() * 100 + 1);
        int rango = 5;
        /*El rango cambiara solo si se cumple la condici�n.
	    	 Para que el rango se mantenga es 5 (es decir el m�ximo)
	    	 el entero prob debe 5 o menos (% de que sea esa rango)*/
        if (prob > 5) {
            rango = 4;
        }
        if (prob > 15) {
            rango = 3;
        }
        if (prob > 30) {
            rango = 2;
        }
        if (prob > 60) {
            rango = 1;
        }
        return rango;
    }

    private int hp() {
        int hp = (int) (Math.random() * 301 + 200);
        return hp;
    }

    private int atk() {
        int atk = (int) (Math.random() * 51 + 20);
        return atk;
    }

    private int def() {
        int def = (int) (Math.random() * 21 + 5);
        return def;
    }

    private int spd() {
        int spd = (int) (Math.random() * 91 + 10);
        return spd;
    }
    //Metodos get y set	

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    public ObjetoEquipable getObjeto(int x) {
        return objeto[x];
    }

    public void setObjeto(int x, ObjetoEquipable objeto) {
        this.objeto[x] = objeto;
    }

    //Override de toString() de la clase Personaje
    @Override
    public String toString() {

        return "Nombre: " + nombre + "\t"
                + "Facción: " + faccion + "\t"
                + "Rango: " + rango + "\t"
                + "HP: " + hp + "\t"
                + "Ataque: " + atk + "\t"
                + "Defensa: " + def + "\t"
                + "Velocidad: " + spd + "\t"
                + "Objeto Equipado: " + "\t" + objetoEquipado();
    }

}

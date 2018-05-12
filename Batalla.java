import java.util.ArrayList;
import java.lang.Math;

public class Batalla {
	
	//los array no deben ser privados, para poder agregar luchadores o monstruos
	private static ArrayList<Luchador> equipo = new ArrayList<Luchador>();
	private static ArrayList<Monstruo> enemigo = new ArrayList<Monstruo>();
	private static ArrayList<Luchador> turno = new ArrayList<Luchador>();
	//el tercer array es solo para mover de equipo a este, para ordenar
		
		
	//las instrucciones dice que los luchadores sean 6 al azar, asi que no requiere parametro
	public static void agregarLuchador(){
		Luchador luchador;
		for(int x=0;x<6;x++){//el for es para agregar 6 luchadores de forma facil
			luchador = new Luchador(""," ",0,0,0,0); //se crean luchadores
			equipo.add(luchador); // se agregan al equipo
		}
	}
	//este es privado y estatico, porque el jugador pelea contra un monstruo al azar
	private static void agregarMonstruo(){
		Monstruo monstruo = new Monstruo(" "," ",0,0,0,0);
		enemigo.add(monstruo);
	}
	
	//Método para ordenar turnos en que se moveran los jugadores
	private  static void ordenarLuchadores(){		
		int arr[] = new int[6];
		for (int i = 0 ; i < arr.length;i++){            
            arr[i] = equipo.get(i).getSpd();;
        }
        burbuja(arr);
	}		
	
	//Método de la burbuja para ordenar las velocidades
	private static void burbuja(int[] arreglo){      
		
		for(int i = 0; i < arreglo.length - 1; i++){
            for(int j = 0; j < arreglo.length - 1; j++){
                if (arreglo[j] < arreglo[j + 1]){
                    int tmp = arreglo[j+1];
                    arreglo[j+1] = arreglo[j];
                    arreglo[j] = tmp;
                }
            }
        }
		ordenarTurno(arreglo);
	}
	//aqui se agregan los luchadores al arraylist turno segun el orden de velocidad en el arreglo[]
	private static void ordenarTurno(int[] arreglo){
		for(int x=0;x<6;x++){
			for(int y=0; y<6;y++){
				if(arreglo[x]==equipo.get(y).getSpd()){
					turno.add(equipo.get(y));
				}				
			}
			/*Para probar si sirve
			 * System.out.println(turno.get(x).getNom()+" "+ turno.get(x).getSpd());			  
			 */
		}		
	}
	
	public int lanzarDados(){
		int dado1 = lanzarDado1();//el de 8 caras		
		int dado2= lanzarDado2();//el de 6 caras
		
		int resultado = (dado2 - dado1);	
		return resultado;
	}		
	//Métodos para obtene el valor del dado de 8 y 6 respectivamente
 	private static int lanzarDado1(){
		int dado8c = (int)(Math.random()*8+1);
		return dado8c;
	}
	private static int lanzarDado2(){
		int dado6c = (int)(Math.random()*6+1);
		return dado6c;		
	}
	//Métodos para evaluar resultados del lanzarDados para monstruo y jugador	
	private static int evaluarCasoJ(int i, int resultado){	
		//el i es para saber que luchador esta peleando
		
		int dmgJ=0;//daño del ataque del jugador
		if(resultado>0){
			dmgJ = turno.get(i).getAtk()*resultado;
			}
		if(resultado==0){
			dmgJ = turno.get(i).getAtk();
		}
		if(resultado<0){ 
			dmgJ = turno.get(i).getAtk();
			}
		return dmgJ;
		
	}
	private static int evaluarCasoM(int resultado){	
		
		int dmgM=0;//daño del ataque del jugador
		if(resultado>0){
			dmgM = enemigo.get(0).getAtk()*resultado;
			}
		if(resultado==0){
			dmgM = enemigo.get(0).getAtk();
		}
		if(resultado<0){ 
			dmgM = enemigo.get(0).getAtk();
			}		
		return dmgM;		
	}
	//métodos para poder atacar
	private static int atacarJ(int dmgJ){
		int dmg = (dmgJ-enemigo.get(0).getDef());
		
		String faccionM = enemigo.get(0).getFaccion();
		String faccionJ = turno.get(0).getFaccion();
		int dmgT = evaluarFaccion(dmg,faccionM,faccionJ);
		
		if (dmgT<0){
			dmgT=0;
		};
		return dmgT;
	}
	private static int atacarM(int dmgM){
		//se supone que monstruo primero ataca al más rapido, que seria la posición 0 de turno
		int dmg= (dmgM-turno.get(0).getDef());
		int dmgT=0;
		/*
		 * String faccionM = enemigo.get(0).getFaccion();
		String faccionJ = turno.get(0).getFaccion();
		int dmgT=evaluarFaccionM(dmg, faccionM, faccionJ); //el daño total es el (daño)*(bono de faccion)
		
		if (dmgT<0){
			dmgT=0;
		};
		*/
		return dmgT;		
	}
	//métodos para que el ataque del jugador o monstruo reduzca la vida
	private static void newHpMonstruo(int dmgT){		
		int hp= enemigo.get(0).getHp();
		enemigo.get(0).setHp((hp-dmgT));
	}
	private static void newHpLuchador(int dmgT){		
		int hp= turno.get(0).getHp();
		turno.get(0).setHp((hp-dmgT));
	}
	
	//Método para ver si la facción es favorable o desfavorable
	//solo esta hecho para el turno de luchador, requiere mejora para
	//porder ser usado tambien por el mosntruo
	private static int evaluarFaccion(int dmg,String faccionM, String faccionJ){
		if(faccionJ.equals("Agua")){
			if(faccionM.equals("Fuego")){
				double a= dmg*(1.5); //obtengo la parte entera de un double abajo
				dmg= (int)a; //porque el dmg es un int
			}
			if(faccionM.equals("Planta")){
				double a= dmg*(0.75);
				dmg=(int)a;
			}			
		}
		if(faccionJ.equals("Fuego")){
			if(faccionM.equals("Planta")){
				double a= dmg*(1.5); 
				dmg= (int)a; 
			}
			if(faccionM.equals("Agua")){
				double a= dmg*(0.75);
				dmg=(int)a;
			}
		}
		if(faccionJ.equals("Planta")){
			if(faccionM.equals("Agua")){
				double a= dmg*(1.5); 
				dmg= (int)a; 
			}
			if(faccionM.equals("Fuego")){
				double a= dmg*(0.75);
				dmg=(int)a;
			}
		}
		return dmg;
		}	
}


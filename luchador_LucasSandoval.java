import java.util.Random;
import java.util.Scanner;

public class luchador_LucasSandoval {	
	static int c=1; //para almacenar en la matriz de luchadores
	static int a; //para comparar luchadores
public static String [][] stats = new String[7][16];    
        
    public static void main(String[] args) {
    nombres();
    Scanner leer = new Scanner(System.in);
    int cerrar;    
    do{int opc;
    System.out.println("1.Crear un luchador(límite:15)");
    System.out.println("2.Mostrar todos los luchadores");
    opc = leer.nextInt();
    switch(opc){
     case 1: crearUnLuchador(rango(),hp(),atk(),def(),spd(), elegirNombre(nombres()),elegirFaccion(faccion()));
     break;             
     case 2: mostrarPeleadores(); 
     break;
      }
    System.out.println("¿Quiere continuar?");
    System.out.println("1.Si");
    System.out.println("2.No");
        cerrar = leer.nextInt();
     }while(cerrar==1);
    System.out.println("Adios");
     }       	
    
   public static void crearUnLuchador(int rango,int hp, int atk, int def, int spd, String nombre, String faccion){
	   compararLuchador(rango, nombre, faccion);
    	/*si el metodo comparar retorna un 0, generara un luchador
    	  si retorna un 1, significa que habia otro peleador igual
    	  por lo cual no se creara el peleador*/
    	
        if(0==a){
        System.out.println("Se creó el luchador: "+nombre);
        System.out.println("De la facción: "+faccion);
        System.out.println("Con un rango de "+rango+" estellas");
        System.out.println("Sus estadisticas son:");
        System.out.println("HP Base: "+hp+" (Total: "+ hp*rango+")");
        System.out.println("ATK Base: "+atk+" (Total: "+ atk*rango+")");
        System.out.println("DEF Base: "+def+" (Total: "+ def*rango+")");        
        System.out.println("SPD Base: "+spd+" (Total: "+ spd*rango+")");
        /*Tener en cuenta que "Base" es distinto del "Total"
        (Porque el Total es por un determinado rango del luchador)
        */ 
        hp=hp*rango;
        atk=atk*rango;
        def=def*rango;
        spd=spd*rango;               
        almacenarLuchador(hp,atk,def,spd,nombre,faccion,rango);}      
	   }
    
    public static void compararLuchador(int rango, String nombre, String faccion){    	
    	    //los luchadores deben tener distinto rango o facción si tienen igual nombre
    	    a=0;
    	    /*el if que va aqui abajo es para prevenir errores 
    	    por el limite de la matriz (15 luchadores), pues el metodo compararLuchador 
    	    usa parte de la columna siguiente (trataria de usar una columna inexistente)*/
    	    if(c==16){System.out.println("No se pueden crear más luchadores");
    	    a++;
    	    }else{
    	    stats[0][c] = nombre;
    	    stats[1][c] = String.valueOf(rango);
    	    stats[6][c] = faccion; 
    	    //no empiezo "y" desde 0 porque ahi estan solo el tipo de dato (nombre, hp, etc)
    	    	for(int y=1; y<c; y++){
    	    		if(stats[0][c]==stats[0][y] && stats[1][c]==stats[1][y]){  
    	    			System.out.println("Luchador generado ya existe");
    	    			a++;}
    	    		
    	    		if(stats[0][c]==stats[0][y] && stats[6][c]==stats[6][y]){    	    			
    	    			a++;}
    	    		}
    	    	}    	    	
    }
    	      	       
    
    public static String[] nombres(){
    String [] peleadores  = new String[15];
    peleadores[0]="Kazuma";
    peleadores[1]="Wolfmanx";
    peleadores[2]="Darkrai";
    peleadores[3]="Destroyer";
    peleadores[4]="Gintoki";
    peleadores[5]="Magikarp";
    peleadores[6]="Agumon";
    peleadores[7]="Naruto";
    peleadores[8]="Luffy";
    peleadores[9]="Goku";
    peleadores[10]="Ichigo";
    peleadores[11]="Hakuno";
    peleadores[12]="Shirou";
    peleadores[13]="Araragi";
    peleadores[14]="Saitama";
   
    return peleadores;
    }
    
    public static String elegirNombre(String []peleadores){
   //n  variable para obtener el normbre del luchador
    int n = (int)(Math.random()*15);
    String name = peleadores[n];
    return name;
    }
    
    public static String[] faccion(){
    String [] faccion = new String[3];
    faccion[0]="Agua";
    faccion[1]="Fuego";
    faccion[2]="Tierra";
    return faccion;
    }
    
    public static String elegirFaccion(String[]faccion){
    //f variable para obtener facción
    int f = (int)(Math.random()*3);
    String tipo = faccion[f];
    return tipo;
    }
    
    public static int rango(){
    	/*generar un numero al azar entre 1 y 100,
    	que simulara la probabilidad del rango del luchador
    	entre:
    	 1 a 5 sera de 5 estrellas
    	 6 a 15 de 4 estrellas
    	 16 a 30 de 3 estrellas
    	 31 a 60 de 2 estrellas
    	 61 a 100 de 1 estrellas
    	*/
    	int rango =0;
        int prob = (int)(Math.random()*100+1);
        if(prob>60){rango =1;}
        else{if(prob>30){rango=2;}
        else{if(prob>15){rango =3;}
        else{if(prob>5){rango =4;}
        else{rango=5;}
        }
        }
        }
        return rango;
        }
        
    //todas las estadisticas con +1 para evitar el 0
    public static int hp(){
        int hp = (int)(Math.random()*300+200+1);
        return hp;
        }     
    public static int atk(){    
    int atk = (int)(Math.random()*50+20+1);
    return atk;
        }
    public static int def(){
        int def = (int)(Math.random()*20+5+1);
        return def;
        }     
    public static int spd(){
    int spd = (int)(Math.random()*90+10+1);
    return spd;
        }        
    
    public static void almacenarLuchador(int hp, int atk, int def, int spd, String nombre, String faccion, int rango){
    stats[0][0] = "Nombre";
    stats[1][0]= "Rango";
    stats[2][0] = "HP"; //Total
    stats[3][0] = "ATK";//Total
    stats[4][0] = "DEF";//Total
    stats[5][0] = "SPD";//Total
    stats[6][0] = "Facción";
    stats[0][c] = nombre;
    stats[1][c] = String.valueOf(rango);
    stats[2][c] = String.valueOf(hp);
    stats[3][c] = String.valueOf(atk);
    stats[4][c] = String.valueOf(def);
    stats[5][c] = String.valueOf(spd);
    stats[6][c] = faccion;
    c++; 
    }
    
    public static void mostrarPeleadores(){
        for(int i=0; i<7; i++){
          for(int j=0; j<16;j++){
              System.out.print(stats[i][j]+"\t");               
          }
            System.out.println();
        }
    }
}

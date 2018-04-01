import java.util.Random;
import java.util.Scanner;

public class luchador_LucasSandoval {	
	static int c=1; //para almacenar en la matriz de luchadores
	static int a; //para comparar luchadores
public String [][] stats = new String[7][16];    
        
    public static void main(String[] args) {
    	inventarioLuchadores inv = new inventarioLuchadores();
    	inv.menu();
    }    
    
   public void agregarUnLuchador(int rango,int hp, int atk, int def, int spd, String nombre, String faccion){
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
        int hp2=hp*rango;
        int atk2=atk*rango;
        int def2=def*rango;
        int spd2=spd*rango;               
        almacenarLuchador(hp2,atk2,def2,spd2,nombre,faccion,rango);
        }      
	   }
    
    public void compararLuchador(int rango, String nombre, String faccion){    	
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
    
    public String[] nombres(){
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
    
    public String elegirNombre(String []peleadores){
   //n  variable para obtener el normbre del luchador
    int n = (int)(Math.random()*15);
    String name = peleadores[n];
    return name;
    }
    
    public String[] faccion(){
    String [] faccion = new String[3];
    faccion[0]="Agua";
    faccion[1]="Fuego";
    faccion[2]="Tierra";
    return faccion;
    }
    
    public String elegirFaccion(String[]faccion){
    //f variable para obtener facción
    int f = (int)(Math.random()*3);
    String tipo = faccion[f];
    return tipo;
    }
    
    public int rango(){
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
    public int hp(){
        int hp = (int)(Math.random()*300+200+1);
        return hp;
        }     
    public int atk(){    
    int atk = (int)(Math.random()*50+20+1);
    return atk;
        }
    public int def(){
        int def = (int)(Math.random()*20+5+1);
        return def;
        }     
    public int spd(){
    int spd = (int)(Math.random()*90+10+1);
    return spd;
        }   
    public void almacenarLuchador(int hp2, int atk2, int def2, int spd2, String nombre, String faccion, int rango){
    stats[0][0] = "Nombre";
    stats[1][0]= "Rango";    
    stats[2][0] = "Facción";
    stats[3][0] = "ATK";//Total
    stats[4][0] = "DEF";//Total
    stats[5][0] = "SPD";//Total
    stats[6][0] = "HP"; //Total    
    stats[0][c] = "("+c+")"+nombre;
    stats[1][c] = String.valueOf(rango);    
    stats[2][c] = faccion;
    stats[3][c] = String.valueOf(atk2);
    stats[4][c] = String.valueOf(def2);
    stats[5][c] = String.valueOf(spd2);
    stats[6][c] = String.valueOf(hp2);    
    c++; 
    }
    
    public void mostrarPeleadores(){
        for(int i=0; i<3; i++){
          for(int j=0; j<16;j++){
              System.out.print(stats[i][j]+"\t");               
          }
            System.out.println();
        }
        System.out.println("El total de luchadores es: "+(c-1));
    }
    public void mostrarDatosDeUnLuchador(int peleador){          
                System.out.println("Nombre: "+ stats[0][peleador]+"\t");
                System.out.println("Rango: "+ stats[1][peleador]+"\t");
                System.out.println("Faccion: "+ stats[2][peleador]+"\t");
                System.out.println("HP Total: "+ stats[6][peleador]+"\t");
                System.out.println("ATK Total: "+ stats[3][peleador]+"\t");
                System.out.println("DEF Total: "+ stats[4][peleador]+"\t");
                System.out.println("SPD Total: "+ stats[5][peleador]+"\t");
                          System.out.println();                   	
    }
    
    //Los metodos desde aqui son los de importancia para el "avance 2"
    
    public void filtrarFaccion(int fac){
    	int a=0;
    	int d=0;    
    	String F = "";
    	if(fac==1){F="Agua";}
    	if(fac==2){F="Fuego";}
    	if(fac==3){F="Tierra";}    	
    		System.out.println("Los luchadores de la facción del "+F+" son:");     		
    		for(int j=0;j<16;j++){
    			/*no comprendo por que el "if" de aqui abajo hace null 
        		los peleadores creados(ver desde el menu mostrar todos los luchadores), 
        		mismo problema en metodo filtrarRango*/
    			if(F.equals(stats[2][j])){
    			    System.out.print("El peleador N°: "+a); 
    			    d++;
    				}a++;
    				}    	   	
    	System.out.println("Total: "+ d);
    	System.out.println("");
    }
    public void filtrarRango(int rang){
    	int a=0;
    	int d=0;
    	System.out.println("Los luchadores del rango "+rang+ " son:");    	
    		for(int j=0;j<16;j++){
    			if(String.valueOf(rang).equals(stats[1][j])){
    			    System.out.print("El peleador N°: "+a); 
    			    d++;
    				}a++;  
    			}    		  		
    	System.out.println("Total: "+ d);   
    	System.out.println("");
    }
    public void eliminarLuchador(){
    	if(c==1){
    		System.out.println("No hay luchadores que eliminar");
    	}else{
    	stats[0][(c-1)] = "null";
        stats[1][(c-1)] = "null";    
        stats[2][(c-1)] = "null";
        stats[6][(c-1)] = "null";
        stats[3][(c-1)] = "null";
        stats[4][(c-1)] = "null";
        stats[5][(c-1)] = "null";
        c--; }
    }
}

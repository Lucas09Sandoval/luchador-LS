import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;

public class luchador_LucasSandoval {	
	private String nombre;
	private int rango;
	private String faccion;
	private int hp;
	private int atk;
	private int def;
	private int spd;	
		
	/* listaLuch es el ArrayList donde se guardan los luchadores creados
	 public para que se puede ver desde otras clases (para el momento de ver objetos
	 o otras cosas	*/	
	static ArrayList<luchador_LucasSandoval> listaLuchs= new ArrayList<luchador_LucasSandoval>();
	//Constructor de la clase
	public luchador_LucasSandoval(String nombre,int rango, String faccion, int hp, int atk, int def, int spd){
    	//los datos base de cada luchador creado
    	this.nombre=nombre;
    	this.rango=rango;
    	this.faccion=faccion;
    	this.hp = hp;
    	this.atk = atk;
    	this.def = def;
    	this.spd = spd;  	 	
    }

	    public static void main(String[] args){	  
	    	
	    	int luchT=0; //variable para poner limite al número de luchadores (15)
	    	
	    	Scanner leer = new Scanner(System.in);
	    	int opc;
	    	do{
	    	System.out.println("1. Mostrar Luchadores");
	    	System.out.println("2. Agregar Luchador (límite:15)");
	    	System.out.println("3. Ver un luchador");
	    	System.out.println("4. Eliminar un luchador");
	    	System.out.println("5. Filtrar Luchadores");	
	    	System.out.println("6. Crear Objeto equipable");	
	    	System.out.println("7. Salir");	    	
	    	opc = leer.nextInt();
	    	switch(opc){
	    		case 1: mostrarLuchadores();
	    	            break;
	    	            
	    		case 2: if(luchT==15){
	    			System.out.println("Se alcanzo el límite de luchadores");
	    		}else{
	    			luchador_LucasSandoval peleador= new luchador_LucasSandoval(elegirNombre(nombres()),rango(), elegirFaccion(faccion()),hp(),atk(),def(),spd());
	    			    listaLuchs.add(peleador);
	    			    luchT++;
	    			    System.out.println("Se creo un luchador");}
	    		        break;
	    		        
	    		case 3:  do{//"opc" y "leer" son reusados de arriba	    			
	    				System.out.println("Escoja el luchador que desea ver (desde el 0 al 14)");
	    				opc = leer.nextInt();
	    				}while(opc>(listaLuchs.size()-1) || opc<0);	    		          
	    		         verUnLuchador(opc);	    		
	    			    break;
	    			   
	    		case 4: inventarioLuchadores inv = new inventarioLuchadores();
	    			do{//"opc" y "leer" son reusados de arriba	    			
	    				System.out.println("Escoja un luchador que desea eliminar (desde el 0 al 14)");
	    				opc = leer.nextInt();
	    				}while(opc>(listaLuchs.size()-1) || opc<0);	    		          
	    		          inv.eliminarUnluchador(opc, listaLuchs, luchT);  
	    			    break;
	    			    
	    		case 5: inventarioLuchadores inven = new inventarioLuchadores();
	    		         inven.filtrar(listaLuchs);
	    				//inv.Filtrar(listaLuchs);
	    				break;
	    				
	    		case 6: ObjetoEquipable obj= new ObjetoEquipable();
	    		        System.out.println("Se ha creado un objeto equipable");
	    		        obj.mostrarMejoraBase();
	    		        obj.mostrarEstrellas();
	    		        obj.mostrarMejoraFinal();
	    				break;
	    			   
	    		case 7: System.out.println("Adios");
	    			   break;	    			   
	    	 }
	    	}while(opc!=7);
	    }	    	
	    //Metodo que mustre todos los luchadores
	    	public static void mostrarLuchadores(){
	    		for(int i=0; i<listaLuchs.size();i++){	    		
	    		System.out.print("Luchador N°"+" "+i+"\t"+"Nombre "+listaLuchs.get(i).getNom());
	    		System.out.print("\t"+"Rango "+"\t"+listaLuchs.get(i).getRango());
	    		System.out.print("\t"+"Facción "+"\t"+listaLuchs.get(i).getFaccion());
	    		System.out.println(""); 	
	    		}  		
	    	}	    	
	    	//Metodo que muestra un solo luchador con todos sus datos	    	
		  public static void verUnLuchador(int opc){
		    	System.out.println("Luchador N°"+" "+opc);
		    	System.out.println("Nombre "+listaLuchs.get(opc).getNom());
	    		System.out.println("Rango "+"\t"+listaLuchs.get(opc).getRango());
	    		System.out.println("Facción "+"\t"+listaLuchs.get(opc).getFaccion());
	    		System.out.println("HP "+"\t"+listaLuchs.get(opc).getHp());
	    		System.out.println("ATK "+"\t"+listaLuchs.get(opc).getAtk());
	    		System.out.println("DEF "+"\t"+listaLuchs.get(opc).getDef());
	    		System.out.println("SPD "+"\t"+listaLuchs.get(opc).getSpd());
	    		System.out.println(""); 	    	
		    }	    	    	
	    	//Metodos para crear los datos de un luchador (Nombre, faccion, rango, estadisticas)
	    private static String[] nombres(){
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
	    
	    private static String elegirNombre(String []peleadores){
	   //n  variable para obtener el normbre del luchador
	    int n = (int)(Math.random()*15);
	    String name = peleadores[n];
	    return name;
	    }
	    
	    private static String[] faccion(){
	    String [] faccion = new String[3];
	    faccion[0]="Agua";
	    faccion[1]="Fuego";
	    faccion[2]="Tierra";
	    return faccion;
	    }
	    
	    private static String elegirFaccion(String[]faccion){
	    //f variable para obtener facción
	    int f = (int)(Math.random()*3);
	    String tipo = faccion[f];
	    return tipo;
	    }
	    
	    private static int rango(){
	    	int prob = (int)(Math.random()*100+1);
	    	int rango=5;
	    	/*El rango cambiara solo si se cumple la condición.
	    	 Para que el rango se mantenga es 5 (es decir el máximo)
	    	 el entero prob debe 5 o menos (% de que sea esa rango)*/
	    	if(prob>5){rango=4;}
	    	if(prob>15){rango=3;}
	    	if(prob>30){rango=2;}
	    	if(prob>60){rango=1;}
	        return rango;
	        }	
	    
	    private static int hp(){
	        int hp = (int)(Math.random()*301+200);
	        return hp;
	        }     
	    private static int atk(){    
	    int atk = (int)(Math.random()*51+20);
	    return atk;
	        }
	    private static int def(){
	        int def = (int)(Math.random()*21+5);
	        return def;
	        }     
	    private static int spd(){
	    int spd = (int)(Math.random()*91+10);
	    return spd;
	    }	    
	    //Metodos get y set
	    
	    public String getFaccion() {
	   	 return this.faccion;	   	 
	    }
	    public int getRango() {
	   	 return this.rango;
	    }
	    public String getNom() {
	    return this.nombre;
	    }
	    public int getAtk() {
	   	 return this.atk;
	   			 }
	   public int getHp() {
	   	return this.hp;
	   } 
	   public int getDef() {
	   	return this.def;
	   }
	   public int getSpd() {
	   	return this.spd;
	   }
	   public void setFaccion(String faccion) {
	   	this.faccion=faccion;
	   }	   
	   public void setNom(String nombre ) {
	   		this.nombre=nombre;
	   }
	   public void setAtk(int atk) {
	   	this.atk=atk;
	   }
	   public void setHp(int hp) {
	   	this.hp=hp;
	   }
	   public void setDef(int def){
	     this.def=def;
	   }
	   public void setSpd(int spd) {
	   	this.spd=spd;
	   }
}

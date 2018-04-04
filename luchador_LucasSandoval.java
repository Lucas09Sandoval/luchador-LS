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
		
	/*Se coloco el metodo main(menu) al final, en caso de que se quiera probar el funcionamiento	
	  |||
	  |||
	  |||
	  vvv 
	   v 
	 */
	
	/* listaLuchs es el ArrayList donde se guardan los luchadores creados
	  no es privado, porque al mover(agregar) un luchador
	  al arraylist inventario(de la clase inventarioLuchadores)
	  este es eliminado de listaLuchs
   */	
	static ArrayList<luchador_LucasSandoval> listaLuchs= new ArrayList<luchador_LucasSandoval>();
	//Constructor de la clase
	public luchador_LucasSandoval(){
    	//los datos base de cada luchador creado
    	this.nombre= elegirNombre(nombres());
    	this.rango= rango();
    	this.faccion= elegirFaccion(faccion());
    	this.hp = hp();
    	this.atk = atk();
    	this.def = def();
    	this.spd = spd();  	 	
    }    
	    //Metodo que muestre todos los luchadores de listaLuchs
	    	public static void mostrarLuchadores(){
	    		System.out.println("Luchadores de listaLuchs son:");
	    		for(int i=0; i<listaLuchs.size();i++){	    		
	    		System.out.print("Luchador N°"+" "+i+"\t"+"Nombre "+listaLuchs.get(i).getNom());
	    		System.out.print("\t"+"Rango "+"\t"+listaLuchs.get(i).getRango());
	    		System.out.print("\t"+"Facción "+"\t"+listaLuchs.get(i).getFaccion());
	    		System.out.print("\t"+"HP:"+listaLuchs.get(i).getHp());
	    		System.out.print("\t"+"ATK:"+listaLuchs.get(i).getAtk());
	    		System.out.print("\t"+"DEF:"+" "+listaLuchs.get(i).getDef());
	    		System.out.print("\t"+"SPD:"+listaLuchs.get(i).getSpd());
	    		System.out.println(""); 	
	    		}  
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

	    public static void main(String[] args){	    	
	    	Scanner leer = new Scanner(System.in);
	    	int opc;
	    	do{
	    	System.out.println("1. Mostrar Luchadores(de la lista *listaLuchs*)");
	    	System.out.println("2. Crear Luchador (límite:15)");
	    	System.out.println("3. Mostrar luchadores del *inventario*");
	    	System.out.println("4. Ver un luchador(de la lista *inventario*)");
	    	System.out.println("5. Eliminar un luchador del *inventario*");
	    	System.out.println("6. Filtrar Luchadores del *inventario*");	
	    	System.out.println("7. Agregar luchador al *inventario*");
	    	System.out.println("8. Crear objeto equipable");
	    	System.out.println("9. Crear Monstruo");
	    	System.out.println("10. Salir");	    	
	    	opc = leer.nextInt();
	    	switch(opc){
	    		case 1: mostrarLuchadores();
	    	            break;
	    	            
	    		case 2: if((listaLuchs.size())==15){
	    			System.out.println("Se alcanzo el límite de luchadores");
	    		}else{
	    			luchador_LucasSandoval peleador= new luchador_LucasSandoval();
	    			    listaLuchs.add(peleador);
	    			    System.out.println("Se creo un luchador");}
	    		        break;
	    		        
	    		case 3: inventarioLuchadores most = new inventarioLuchadores();
		    		//se crea objeto most para postrar luchadores del inventario
    				most.mostrarInv();     		
	    			    break;
	    			    
	    		case 4: inventarioLuchadores ver = new inventarioLuchadores();
		    		//"ver" es un objeto creado para usar el metodo verUnLuchador de inventarioLuchadores
		    			    do{//"opc" y "leer" son reusados de arriba	    			
		    				System.out.println("Escoja el luchador que desea ver (desde el 0 al 14)");
		    				opc = leer.nextInt();
		    				}while(opc>(listaLuchs.size()-1) || opc<0);	    		          
		    		         ver.verUnLuchador(opc);	
	    				break;
	    			   
	    		case 5: inventarioLuchadores inv = new inventarioLuchadores();
	    			if(inv.inventario.size()==0){
	    				System.out.println("No hay luchadores en el inventario");}
	    		else{
	    			do{
	    				//"opc" y "leer" son reusados de arriba	    			
	    				System.out.println("Escoja un luchador que desea eliminar (desde el 0 al 14)");
	    				opc = leer.nextInt();
	    				}while(opc>(inv.inventario.size()-1) || opc<0);	    		          
	    		          inv.eliminarUnluchador();  }
	    			    break;
	    			    
	    		case 6: inventarioLuchadores inven = new inventarioLuchadores();
	    		         inven.filtrar();
	    				//inv.Filtrar(listaLuchs);
	    				break;
	    				
	    		case 7: if(listaLuchs.size()==0){
	    			System.out.println("No hay luchadores para mover al inventario");}
	    		else{ 
	    			inventarioLuchadores invent= new inventarioLuchadores();
	    		  		invent.agregarLuchador(listaLuchs);	  }  			    
	    				break; 
	    				
	    		case 8: ObjetoEquipable obj= new ObjetoEquipable();
		        		System.out.println("Se ha creado un objeto equipable");
		        		obj.mostrarArma();
	    			    break;
	    				
	    		case 9: Monstruo mons= new Monstruo();
	    		        System.out.println("Se ha creado un monstruo");
	    		        mons.mostrarMonstruo();
	    			   break;
	    			
	    		case 10: System.out.println("Adios");
	    			   break;    	 
	    	}
	    	}while(opc!=10);
	    }	
}

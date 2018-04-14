import java.lang.Math;

public class Monstruo {
	//los datos base de cada Monstruo creado
	private int hp;
	private int atk;
	private int def;
	private int spd;
	private String nom;
	private String faccion;
	
	//Constructor de la clase monstruo
	public Monstruo(){
		this.nom = elegirNombre(nombresDeMonstruo());
		this.faccion= elegirFaccion(faccionMonstruo());
		this.hp = hp();
		this.atk= atk();
		this.def= def();
		this.spd= spd();		
	}
	//metodo que dropea un objeto
	public static void crearObjetoDropeable(){
		System.out.println("El monstruo a sido derrotado");
		System.out.println("DROP:");
		ObjetoEquipable drop = new ObjetoEquipable();
		drop.mostrarDrop();
	}
	
	//método que muestra el monstruo creado
	public void mostrarMonstruo(){
		System.out.println("Se ha creado un monstruo");
		System.out.println("Nombre: "+nom);
		System.out.println("Faccion: "+ faccion);
		System.out.println("HP: "+"\t"+hp);
		System.out.println("ATK: "+"\t"+atk);
		System.out.println("DEF: "+"\t"+def);
		System.out.println("SPD: "+"\t"+spd);	
		
		ObjetoEquipable drop = new ObjetoEquipable();		
		System.out.println("y el objeto que dropea es:");
		drop.mostrarDrop();
	}
	
	//métodos que generan el nombre, faccion y las estadisticas del monstruo
    private static String[] nombresDeMonstruo(){
    String [] monstruos  = new String[3];
    monstruos[0]="Ghost Rider";
    monstruos[1]="Dark Veilnus";
    monstruos[2]="Vanir";
    	   
    return monstruos;
    }	    
    private static String elegirNombre(String []monstruos){
    int m = (int)(Math.random()*3);
    String nombre = monstruos[m];
    return nombre;
    }	 
    private static String[] faccionMonstruo(){
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
	 private static int hp(){
	        int hp = (int)(Math.random()*3501+500);
	        return hp;
	        }     
	    private static int atk(){    
	    int atk = (int)(Math.random()*1001+500);
	    return atk;
	        }
	    private static int def(){
	        int def = (int)(Math.random()*6+20);
	        return def;
	        }     
	    private static int spd(){
	    int spd = (int)(Math.random()*11+90);
	    return spd;
	    }	
	
	//métodos get y set	
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
	   public String getNom() {
		   	return this.nom;
		   }	  
		   public void setNom(String nom) {
		   	this.nom=nom;
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

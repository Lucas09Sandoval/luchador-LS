import java.lang.Math;

public class Monstruo extends Personaje{
	//los datos base de cada Monstruo creado	
	private ObjetoEquipable drop;
	
	//Constructor de la clase monstruo
	public Monstruo(String nombre, String faccion, int hp, int atk, int def, int spd){
		super(nombre, faccion, hp, atk, def, spd);
		this.nombre = elegirNombre(nombresDeMonstruo());
		this.faccion= elegirFaccion(faccionMonstruo());
		this.hp = hp();
		this.atk= atk();
		this.def= def();
		this.spd= spd();
		this.drop= drop();
	}
	//metodo que dropea un objeto
	private static ObjetoEquipable drop(){		
		ObjetoEquipable drop = new ObjetoEquipable();
	
		int prob = (int)(Math.random()*100+1);		
		int estrellas=0;
		//si prob >40 para 60% de que sea de 1 estrellas
		//prob >10 para que sea de 3 (es decir 30%, por los numeros entre 10 y 40)
		//cualquier otro caso (osea 10 o menor) 5 estrellas
		if(prob>40){ estrellas=1;			
		}else{
			if(prob>10){ estrellas=3;		
				}else{ 	estrellas=5;			
					}
		}
		/*los get y set de aqui son para asegurarse que tenga sentido las estadisticas
		porque la mejora final= base*estrellas, y si las estrellas cambian,		
		hay que estar seguro que la mejora final se actualiza*/
		drop.setEstrellas(estrellas);		
		int mejoraBase = drop.getMejoraBase();	
		drop.setMejoraFinal(mejoraBase,estrellas);
		
		return drop;
	}
	
	//método que muestra el monstruo creado
	public void mostrarMonstruo(){
		System.out.println("Se ha creado un monstruo");
		System.out.println("Nombre: "+nombre);
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
	    faccion[2]="Planta";
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
	   public String getNommbre() {
		   	return this.nombre;
		   }		   
	   public void setNombre(String nombre) {
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
	   public ObjetoEquipable getDrop(){
		   return drop;
	   }
	   public void setDrop(ObjetoEquipable drop){
		   this.drop=drop;
	   }
	   public String getFaccion(){
		   return faccion;
	   }
	   public void setFaccion(String faccion){
		   this.faccion=faccion;
	   }
}

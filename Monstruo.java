
public class Monstruo {
	//los datos base de cada Monstruo creado
	private int hp;
	private int atk;
	private int def;
	private int spd;
	
	//Constructor
	public Monstruo(){
		this.hp = hp();
		this.atk= atk();
		this.def= def();
		this.spd= spd();		
	}
	//método que muestra el monstruo creado
	public void mostrarMonstruo(){
		System.out.println("HP: "+"\t"+hp);
		System.out.println("ATK: "+"\t"+atk);
		System.out.println("DEF: "+"\t"+def);
		System.out.println("SPD: "+"\t"+spd);		
	}
	
	//métodos que generan las estadisticas del monstruo
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

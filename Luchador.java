import java.lang.Math;

public class Luchador {	
	private String nombre;
	private int rango;
	private String faccion;
	private int hp;
	private int atk;
	private int def;
	private int spd;	
	private ObjetoEquipable objeto;
	
	//Constructor de la clase
	public Luchador(){
    	//los datos base de cada luchador creado
    	this.nombre= elegirNombre(nombres());
    	this.rango= rango();
    	this.faccion= elegirFaccion(faccion());
    	this.hp = hp()*rango;
    	this.atk = atk()*rango;
    	this.def = def()*rango;
    	this.spd = spd()*rango;  
    	this.objeto = objeto; //un luchador se crea sin tener un objeto    	
    }
	
	//Metodo para equipar objeto
	public void equiparObjeto(Luchador luchador, ObjetoEquipable objeto){
		//Se debe conocer el luchador al que se le aplica un aumento
		//y el objeto, por eso este metodo requiere estos 2 parametros
		setObjeto(objeto);
		actualizarEstadisticas(luchador,objeto);		
	}
	//Metodo para actualizar los stats del luchador segun el objeto
	private static void actualizarEstadisticas(Luchador luchador, ObjetoEquipable objeto){
		int aumento = objeto.getMejoraFinal();
		String estadistica = objeto.getEstadistica();
		//no es necesario hacer else 
		if(estadistica.equals("HP")){actualizarHp(luchador,aumento);}
		if(estadistica.equals("ATK")){actualizarAtk(luchador,aumento);}
		if(estadistica.equals("DEF")){actualizarDef(luchador,aumento);}
		if(estadistica.equals("SPD")){actualizarSpd(luchador,aumento);}		
	}	
	
	private static void actualizarHp(Luchador luchador,int aumento){
		int hp = luchador.getHp();
		/*se obtiene el hp del luchador	tener en cuenta que ese hp ya
		  esta multiplicado por rango, asi que solo se le suma el aumento*/
		
		luchador.setHp((hp+aumento));//se actualiza agregandole aumento
	}	
	//Lo mismo que el actualizarHp pero en las otras estadisticas
	private static void actualizarAtk(Luchador luchador,int aumento){
		int atk = luchador.getAtk();
		luchador.setAtk((atk+aumento));
	}
	private static void actualizarDef(Luchador luchador,int aumento){
		int def = luchador.getDef();
		luchador.setAtk((def+aumento));
	}
	private static void actualizarSpd(Luchador luchador,int aumento){
		int spd = luchador.getSpd();
		luchador.setAtk((spd+aumento));
	}
	//Método para mostrar datos
	public void mostrarLuchador(){
				System.out.println("Nombre: "+nombre);
				System.out.println("Facción: "+ faccion);
				System.out.println("Rango: "+ rango);
				System.out.println("Hp: "+hp);
				System.out.println("ATK: "+atk);
				System.out.println("DEF "+def);
				System.out.println("SPD: "+ spd);				
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
	    faccion[2]="Planta";
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
	   public ObjetoEquipable getObjeto() {
		   	return this.objeto;
		   }
	   public void setObjeto(ObjetoEquipable objeto) {
		   	this.objeto=objeto;
		   }
}

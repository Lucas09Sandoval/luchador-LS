import java.lang.Math;

public class ObjetoEquipable {	
	private String nom;
	private int mejoraBase;
    private int estrellas;
    private int mejoraFinal;
    private String estadistica;
    
    public ObjetoEquipable(){
    	this.nom = elegirNombre(nombres());
        this.mejoraBase =  obtenerMejoraBase();
        this.estrellas = obtenerEstrellas();
        this.mejoraFinal = obtenerMejoraFinal();      
        this.estadistica = elegirEst(estadisticas());
    }    
    //metodo para mostrar el objeto dropeado de un monstruo
    public void mostrarDrop(){
    	System.out.println("Nombre: "+nom);
    	System.out.println("Estrellas: "+estrellas);
    	System.out.println("Mejora total: "+mejoraFinal +" al "+estadistica);
    }
    
    //Metodos que final la base, estrellas y mejora final del objeto equipable
    public static int obtenerMejoraBase(){
            int mejoraBase = (int) (Math.random()*9+1);
            return mejoraBase;
        }    
    public int obtenerEstrellas(){
    	int por = (int) (Math.random()*100+1);
            int estrellas = 1;	            
            if(por>20){estrellas=2;}
            if(por>40){estrellas=3;}
            if(por>60){estrellas=4;}
            if(por>75){estrellas=5;}
            if(por>85){estrellas=6;}
            if(por>90){estrellas=7;}
            if(por>94){estrellas=8;}
            if(por>97){estrellas=9;}
            if(por>99){estrellas=10;}	     
            /*no es necesario hacer "else" porque el valor de las estrellas 
            dejaran de cambiar cuando ya no se cumpla la condición
            (debi hacer lo mismo cuando hacia el rango de 
            los luchadores para la primera tarea)*/
            return estrellas;
        } 
    public int obtenerMejoraFinal(){
        mejoraFinal = mejoraBase*estrellas;
        return mejoraFinal;
    }   
    //Metodo para darle "nombre" al arma
    private static String[] nombres(){
	    String [] nom  = new String[5];
	    nom[0]="Maza";
	    nom[1]="Staff";
	    nom[2]="Espada";
	    nom[3]="Escudo";
	    nom[4]="Dagas";
	    return nom;
	    }   
    private static String elegirNombre(String []nom){
 	    int n = (int)(Math.random()*5);
 	    String name = nom[n];
 	    return name;
 	    }
    private static String[] estadisticas(){
 		    String [] stat  = new String[4];
 		    stat[0]="HP";
 		    stat[1]="ATK";
 		    stat[2]="DEF";
 		    stat[3]="SPD";
 		    return stat;
 		    }   
 	    private static String elegirEst(String []stat){
 	 	    int e = (int)(Math.random()*4);
 	 	    String estadistica = stat[e];
 	 	    return estadistica;
 	 	    } 	 
   
  //Metodos get y set    
    public int getMejoraBase() {
   	 return this.mejoraBase;	   	 
    }
    public int getEstrellas() {
   	 return this.estrellas;
    }
    public int getMejoraFinal() {
    return this.mejoraFinal;
    } 
    public String getNom() {
        return this.nom;        
        } 
    public String getEstadistica() {
        return this.estadistica;
        } 
    public void setEstadistica(String estadistica) {
       	this.nom=estadistica;
       }
    public void setNom(String nom) {
       	this.nom=nom;
       }
   public void setMejoraBase(int mejoraBase) {
   	this.mejoraBase=mejoraBase;
   }
   public void setEstrellas(int estrellas) {
   	this.estrellas=estrellas;
   }
   public void setDef(int mejoraFinal){
     this.mejoraFinal=mejoraFinal;
   }   
}

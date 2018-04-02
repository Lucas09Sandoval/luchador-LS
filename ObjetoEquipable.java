import java.util.ArrayList;

public class ObjetoEquipable {	
	private int mejoraBase;
    private int estrellas;
    private int mejoraFinal;
    
    public ArrayList<ObjetoEquipable> objetos= new ArrayList<ObjetoEquipable>();
    
    public ObjetoEquipable(){
        this.mejoraBase =  obtenerMejoraBase();
        this.estrellas = obtenerEstrellas();
        this.mejoraFinal = obtenerMejoraFinal();        
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
    //Metodos para ver en la consola
    public void mostrarMejoraBase(){
        System.out.println("Mejora Base: " + mejoraBase);
    }
    public void mostrarEstrellas(){
        System.out.println("Estrellas del objeto: " + estrellas);
    }    
    public void mostrarMejoraFinal(){
        System.out.println("Mejora Total: " + mejoraFinal);
    }
  //Metodos get y set
    
    public String getMejoraBase() {
   	 return this.mejoraBase;	   	 
    }
    public int getEstrellas() {
   	 return this.estrellas;
    }
    public String getMejoraFinal() {
    return this.mejoraFinal;
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

public class ObjetoEquipable {	
	    int mejoraBase=0;
	    int estrellasDelObjeto=0;
	    int mejoraFinal=0;
	    
	    public void generarObjetoEquipable(){
	        mejoraBase =  obtenerMejoraBase();
	        estrellasDelObjeto = obtenerEstrellas();
	        obtenerMejoraFinal();
	        mostrarEstrellas();
	        mostrarMejoraBase();
	        mostrarMejoraFinal();
	    }
	    
	    public static int obtenerMejoraBase(){
	            int mb = (int) (Math.random()*9+1);
	            //mb es variable para obtener mejora base
	            return mb;
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
	    
	    public void mostrarEstrellas(){
	        System.out.println("Rango del objeto: " + estrellasDelObjeto);
	    }
	    
	    public int obtenerMejoraFinal(){
	        mejoraFinal = mejoraBase*estrellasDelObjeto;
	        return mejoraFinal;
	    }
	    public void mostrarMejoraBase(){
	        System.out.println("Mejora Base: " + mejoraBase);
	    }
	    
	    public void mostrarMejoraFinal(){
	        System.out.println("Mejora Total: " + mejoraFinal);
	    }
}

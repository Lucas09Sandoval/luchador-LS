import java.util.Scanner;
//Menu para probar las clases creadas para los avances del proyecto ayudantia
public class Main {
	 public static void main(String[] args){
		 menu();
	 }
	
	public static void menu(){	    	
    	Scanner leer = new Scanner(System.in);
    	int opc;
    	/*inventarioLuch: arraylist de luchadores que se mueven del arraylist anterior a este
    	 *inventarioObj: arraylist de objetos que se meven del arraylist de objetos a este.
    	 * */
    	do{    			
        System.out.println("1. Agregar luchador (inventarioLuch)");
        System.out.println("2. Ver un luchador(inventarioLuch)");
    	System.out.println("3. Mostrar luchadores (inventarioLuch)");    	
    	System.out.println("4. Filtrar Luchadores (inventarioLuch)");
    	System.out.println("5. Eliminar un luchador (inventarioLuch)");  
    	System.out.println("6. Mostrar inventario de objetos");
    	System.out.println("7. Agregar objeto (inventarioObj)");
    	System.out.println("8. Eliminar objeto (inventarioObj)");
    	System.out.println("9. Filtrar objeto(inventarioObj)");	    	
    	System.out.println("10. Crear Monstruo");
    	System.out.println("11. Salir");    	

    	opc = leer.nextInt();
    	
    	//creación de objetos para usar en el switch  
    	inventarioLuchadores invLuch = new inventarioLuchadores();
    	inventarioObjetos invObj = new inventarioObjetos();	    	
    	Monstruo mons= new Monstruo();    	
    	
    	switch(opc){ 
    		case 1: invLuch.agregarLuchador();	    					    
    				break;
    			    
    		case 2: invLuch.verUnLuchador();
    				break;    				
    				 
    		case 3: invLuch.mostrarInv();     		
    			    break;
    			    
    		case 4: invLuch.filtrarLuch();
    				break; 
    			   
    		case 5: invLuch.eliminarUnluchador();
    			    break;   		    				
    		
    	    case 6: invObj.mostrarInvObj();
    				break;
    		
    		case 7: invObj.agregarObjeto();
    	 			break;
    	 	
    		case 8: invObj.eliminarUnObjeto();
    				break;
    		
    		case 9: invObj.filtrarObj();
    				break;
    				
    		case 10: mons.mostrarMonstruo();
    			    break;
    			
    		case 11: System.out.println("Adios");
    			   break;    	 
    	}
    	}while(opc!=11);
    }
}

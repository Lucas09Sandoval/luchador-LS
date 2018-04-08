import java.util.Scanner;
//Menu para probar las clases creadas para los avances del proyecto ayudantia
public class Main {
	 public static void main(String[] args){
		 menu();
	 }
	
	public static void menu(){	    	
    	Scanner leer = new Scanner(System.in);
    	int opc;
    	/*listaLuchs: arraylist de luchadores que se crean
    	 *inventario: arraylist de luchadores que se mueven del arraylist anterior a este
    	 *objetos: arraylist de objetos que se crean
    	 *inventarioObj: arraylist de objetos que se meven del arraylist de objetos a este.
    	 * */
    	do{
    	System.out.println("1. Mostrar Luchadores(listaLuchs)");
    	System.out.println("2. Crear Luchador (límite:15)");
    	System.out.println("3. Mostrar luchadores (inventario)");
    	System.out.println("4. Ver un luchador(inventario)");
    	System.out.println("5. Eliminar un luchador (inventario)");
    	System.out.println("6. Filtrar Luchadores (inventario)");	
    	System.out.println("7. Agregar luchador (inventario)");
    	System.out.println("8. Crear objeto equipable");
    	System.out.println("9. Mostrar objetos creados");
    	System.out.println("10. Mostrar inventario de objetos");
    	System.out.println("11. Agregar objeto al inventario");
    	System.out.println("12. Eliminar objeto del inventario");
    	System.out.println("13. Filtrar objeto(inventarioObj)");	    	
    	System.out.println("14. Crear Monstruo");
    	System.out.println("15. Salir");    	

    	opc = leer.nextInt();
    	
    	//creación de objetos para usar en el switch    	 
    	luchador_LucasSandoval luch = new luchador_LucasSandoval();
    	inventarioLuchadores invLuch = new inventarioLuchadores();
    	ObjetoEquipable obj = new ObjetoEquipable();
    	inventarioObjetos invObj = new inventarioObjetos();	    	
    	Monstruo mons= new Monstruo();    	
    	
    	switch(opc){
    		case 1: luch.mostrarLuchadores();
    	            break;
    	            
    		case 2: luch.crearUnLuchador();	    			    
    		        break;
    		        
    		case 3: invLuch.mostrarInv();     		
    			    break;
    			    
    		case 4: invLuch.verUnLuchador();
    				break;
    			   
    		case 5: invLuch.eliminarUnluchador();
    			    break;
    			    
    		case 6: invLuch.filtrarLuch();
    				break;
    				
    		case 7: invLuch.agregarLuchador(luch.listaLuchs);	    					    
    				break; 
    				
    		case 8: obj.crearObjeto();
    			    break;	
    			    
    		case 9:obj.mostrarObjetos();
    				break;
    		
    	    case 10: invObj.mostrarInvObj();
    				break;
    		
    		case 11: invObj.agregarObjeto(obj.objetos);
    	 			break;
    	 	
    		case 12: invObj.eliminarUnObjeto();
    				break;
    		
    		case 13: invObj.filtrarObj();
    				break;
    				
    		case 14: mons.mostrarMonstruo();
    			    break;
    			
    		case 15: System.out.println("Adios");
    			   break;    	 
    	}
    	}while(opc!=15);
    }
}

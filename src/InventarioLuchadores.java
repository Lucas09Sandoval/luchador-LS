import java.util.ArrayList;
import java.util.Scanner;
public class InventarioLuchadores {
	
	static ArrayList<Luchador> inventarioLuch = new ArrayList<Luchador>();
	
	 //Metodo que mustre todos los luchadores del inventario
	public void mostrarInv(){
		for(int i=0; i<inventarioLuch.size();i++){	    		
		System.out.print("Luchador N°"+" "+i+"\t"+"Nombre "+inventarioLuch.get(i).getNombre());
		System.out.print("\t"+"Rango "+"\t"+inventarioLuch.get(i).getRango());
		System.out.print("\t"+"Facción "+"\t"+inventarioLuch.get(i).getFaccion());
		System.out.println(""); 	
		}  
	}
	
	//Metodo que muestra un solo luchador del arraylist inventario con todos sus datos	    	
	  public void verUnLuchador(){
		  if(inventarioLuch.size()==0){
			  System.out.println("No hay luchadores en el inventario");
		  }else{
		  int opc =0;
		  Scanner leer = new Scanner(System.in);
		  do{//"opc" y "leer" son reusados de arriba	    			
				System.out.println("Escoja el luchador que desea ver (desde el 0 al 14)");
				opc = leer.nextInt();
				}while(opc>(inventarioLuch.size()-1) || opc<0);		  
		  
	    	System.out.println("Luchador N°"+" "+opc);
	    	System.out.println("Nombre "+inventarioLuch.get(opc).getNom());
   		System.out.println("Rango "+"\t"+inventarioLuch.get(opc).getRango());
   		System.out.println("Facción "+"\t"+inventarioLuch.get(opc).getFaccion());
   		System.out.println("HP "+"\t"+inventarioLuch.get(opc).getHp());
   		System.out.println("ATK "+"\t"+inventarioLuch.get(opc).getAtk());
   		System.out.println("DEF "+"\t"+inventarioLuch.get(opc).getDef());
   		System.out.println("SPD "+"\t"+inventarioLuch.get(opc).getSpd());
   		System.out.println(""); 
		  }
	    }	   
	
	//Metodo que agrega luchador al inventario
	public void agregarLuchador(){
		if(inventarioLuch.size()==25){
			System.out.println("No se pueden agregar más luchadores");			
		}else{
			System.out.println("Se ha agregado un luchador");
		Luchador luchador = new Luchador("","",0,0,0,0);
		inventarioLuch.add(luchador);
		}
		}  
	//Metodo que elimina un luchador
	   public void eliminarUnluchador(){
		   int opc=0;
		   Scanner leer = new Scanner(System.in);
		   if(inventarioLuch.size()==0){
				System.out.println("No hay luchadores en el inventario");}
		else{
			do{    			
				System.out.println("Escoja un luchador que desea eliminar (desde el 0 al 14)");
				opc = leer.nextInt();
				}while(opc>(inventarioLuch.size()-1) || opc<0);  }
		   inventarioLuch.remove(opc);
	        System.out.println("Se elimino un luchador del inventario");
	    } 
	//Metodo que filtra los luchadores
	public void filtrarLuch(){
		
		int opc;
		Scanner leer = new Scanner(System.in);
		do{//para asegurarse que sea una opción valida
		System.out.println("¿Desea filtrar por:");
		System.out.println("1. Rango");
		System.out.println("2.Facción");
		opc =leer.nextInt();	
		}while(opc>2 || opc<1);
		
		int a=0; //variable para imprimir los peleadores filtrados
		String F=" ";//para filtrar en Facción haciendo uso del metodo equals
		
		if(opc==1){int rang;
			do{
			System.out.println("Ingrese el rango que desea filtrar(desde 1 a 5)");
			rang = leer.nextInt();
			}while(rang>5 || rang<1);
			
			for(int i=0;i<inventarioLuch.size();i++){
				if(inventarioLuch.get(i).getRango()==rang){
					System.out.println("El peleador N°"+i);
					a++;
				}				
			}			
			System.out.println("Los luchadores del rango "+rang+" en el inventario son en total:"+a);			
		}else{int fac;	//para obtener la facción del menu que viene abajo		      
		        do{
				System.out.println("Ingrese la facción que desea filtrar");
				System.out.println("1. Agua");
				System.out.println("2. Fuego");
				System.out.println("3. Tierra");
				fac = leer.nextInt();}while(fac>3 || fac<1);
		        
		        if(fac==1){F= "Agua";}
		        if(fac==2){F= "Fuego";}
		        if(fac==3){F= "Tierra";}
		        
				for(int i=0;i<inventarioLuch.size();i++){
					if(F.equals(inventarioLuch.get(i).getFaccion())){
						System.out.println("El peleador N°"+i);
						a++;
					}				
				}			
				System.out.println("Total de luchadores de la facción "+F+" en el inventario son en total:"+a);				
		}
    }
}
